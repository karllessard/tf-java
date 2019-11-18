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

import java.util.concurrent.atomic.AtomicLong;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.impl.AbstractNdArray;
import org.tensorflow.nio.nd.impl.dense.transfer.DataTransfer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpaceWithOffset;
import org.tensorflow.nio.nd.index.Index;

@SuppressWarnings("unchecked")
public abstract class AbstractDenseNdArray<T, U extends NdArray<T>> extends AbstractNdArray<T, U> {

  @Override
  public U slice(Index... indices) {
    if (indices == null) {
      throw new IllegalArgumentException("Slicing requires at least one index");
    }
    DimensionalSpaceWithOffset sliceDimensions = dimensions().mapTo(indices);
    DataBuffer<T> sliceBuffer = buffer();
    if (sliceDimensions.offset() > 0) {
      sliceBuffer = sliceBuffer.offset(sliceDimensions.offset());
    }
    return instantiate(sliceBuffer, sliceDimensions);
  }

  @Override
  public U get(long... coords) {
    DimensionalSpace sliceDimensions = dimensions().from(coords.length);
    long slicePosition = positionOf(coords, false);
    return instantiate(buffer().offset(slicePosition), sliceDimensions);
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
    buffer().set(value, positionOf(coords, true));
    return (U)this;
  }

  @Override
  public U read(DataBuffer<T> dst) {
    Validator.readToBufferArgs(this, dst);
    DataTransfer.execute(buffer(), dimensions(), dst, null);
    return (U)this;
  }

  @Override
  public U write(DataBuffer<T> src) {
    Validator.writeFromBufferArgs(this, src);
    DataTransfer.execute(src, null, buffer(), dimensions());
    return (U)this;
  }

  protected AbstractDenseNdArray(DimensionalSpace dimensions) {
    super(dimensions);
  }

  abstract protected DataBuffer<T> buffer();

  abstract U instantiate(DataBuffer<T> buffer, DimensionalSpace dimensions);

  long positionOf(long[] coords, boolean isValue) {
    if (coords == null || coords.length == 0) {
      return 0;
    }
    if (coords.length > dimensions().size()) {
      throw new IndexOutOfBoundsException();
    }
    return dimensions().positionOf(coords, isValue);
  }

  @Override
  protected void slowCopyTo(NdArray<T> array) {
    if (array instanceof AbstractDenseNdArray) {
      AbstractDenseNdArray<T, U> dst = (AbstractDenseNdArray)array;
      AtomicLong off = new AtomicLong();
      scalars().forEach(s -> dst.buffer().set(s.getValue(), off.getAndIncrement()));
    } else {
      super.slowCopyTo(array);
    }
  }
}
