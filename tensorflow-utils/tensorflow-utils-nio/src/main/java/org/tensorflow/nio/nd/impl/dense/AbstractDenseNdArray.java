/*
 Copyright 2019 The TensorFlow Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 =======================================================================
 */
package org.tensorflow.nio.nd.impl.dense;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.NdArraySequence;
import org.tensorflow.nio.nd.impl.AbstractNdArray;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.ElementSequence;
import org.tensorflow.nio.nd.index.Index;

@SuppressWarnings("unchecked")
abstract class AbstractDenseNdArray<T, U extends NdArray<T>> extends AbstractNdArray<T, U> {

  @Override
  public U slice(Index... coords) {
    DimensionalSpace sliceDimensions = dimensions().mapTo(coords);

    // Skip all leading dimensions that are a single point (i.e. a coordinate)
    long slicePosition = 0L;
    int i = 0;
    while (i < sliceDimensions.size() && sliceDimensions.get(i).isSinglePoint()) {
      slicePosition += sliceDimensions.get(i++).position();
    }
    if (i > 0) {
      sliceDimensions = sliceDimensions.from(i);
    }
    return allocateSlice(slicePosition, sliceDimensions);
  }

  @Override
  public NdArraySequence<U> elements(int dimensionIdx) {
    if (dimensionIdx >= shape().numDimensions()) {
      throw new IllegalArgumentException("Cannot iterate elements in dimension '" + dimensionIdx +
          "' of array with shape " + shape());
    }
    return ElementSequence.create(this, dimensionIdx);
  }

  @Override
  public NdArraySequence<U> scalars() {
    return ElementSequence.create(this, shape().numDimensions() - 1);  // negative if this array is a scalar
  }

  @Override
  public U get(long... coords) {
    DimensionalSpace sliceDimensions = dimensions().from(coords.length);
    long slicePosition = positionOf(coords, false);
    return allocateSlice(slicePosition, sliceDimensions);
  }

  @Override
  public T getValue(long... coords) {
    return buffer().get(positionOf(coords, true));
  }

  @Override
  public U set(NdArray<T> src, long... coordinates) {
    src.copyTo((coordinates == null || coordinates.length == 0) ? this : get(coordinates));
    return (U)this;
  }

  @Override
  public U setValue(T value, long... coords) {
    buffer().put(positionOf(coords, true), value);
    return (U)this;
  }

  @Override
  public U copyTo(NdArray<T> dst) {
    Validator.copyToNdArrayArgs(this, dst);
    if (!BulkDataTransfer.execute(this, dst)) {
      slowCopyTo(dst);
    }
    return (U)this;
  }

  @Override
  public U read(DataBuffer<T> dst) {
    Validator.readToBufferArgs(this, dst);
    if (!BulkDataTransfer.execute(this, dst)) {
      slowRead(dst);
    }
    return (U)this;
  }

  @Override
  public U write(DataBuffer<T> src) {
    Validator.writeFromBufferArgs(this, src);
    if (!BulkDataTransfer.execute(src, this)) {
      slowWrite(src);
    }
    return (U)this;
  }

  protected AbstractDenseNdArray(DimensionalSpace dimensions) {
    super(dimensions);
  }

  abstract DataBuffer<T> buffer();

  abstract U allocate(DataBuffer<T> buffer, DimensionalSpace dimensions);

  long positionOf(long[] coords, boolean isValue) {
    if (coords == null || coords.length == 0) {
      return 0;
    }
    return dimensions().positionOf(coords, isValue);
  }

  private U allocateSlice(long position, DimensionalSpace dims) {
    return allocate(buffer().offset(position), dims);
  }
}
