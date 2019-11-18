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
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.nd.BooleanNdArray;
import org.tensorflow.nio.nd.DoubleNdArray;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.mutable.BooleanMutableDataBuffer;
import org.tensorflow.nio.nd.impl.dense.transfer.BooleanDataTransfer;
import org.tensorflow.nio.nd.impl.dense.transfer.DoubleDataTransfer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.NdArrayCursor;

public class BooleanDenseNdArray extends AbstractDenseNdArray<Boolean, BooleanNdArray>
    implements BooleanNdArray {

  public static BooleanNdArray create(BooleanDataBuffer buffer, Shape shape) {
    Validator.denseShape(buffer, shape);
    return new BooleanDenseNdArray(buffer, shape);
  }

  @Override
  public boolean getBoolean(long... indices) {
    return buffer().getBoolean(positionOf(indices, true));
  }

  @Override
  public BooleanNdArray setBoolean(boolean value, long... indices) {
    buffer().setBoolean(value, positionOf(indices, true));
    return this;
  }

  @Override
  public BooleanNdArray read(boolean[] dst, int offset) {
    Validator.getArrayArgs(this, dst.length, offset);
    return read(DataBuffers.wrap(dst, false).offset(offset));
  }

  @Override
  public BooleanNdArray write(boolean[] src, int offset) {
    Validator.putArrayArgs(this, src.length, offset);
    return write(DataBuffers.wrap(src, true).offset(offset));
  }

  @Override
  public BooleanNdArray copyTo(NdArray<Boolean> dst) {
    Validator.copyToNdArrayArgs(this, dst);
    if (dst instanceof BooleanDenseNdArray) {
      BooleanDenseNdArray floatDst = (BooleanDenseNdArray)dst;
      BooleanDataTransfer.execute(buffer, dimensions(), floatDst.buffer, floatDst.dimensions());
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public BooleanNdArray read(BooleanDataBuffer dst) {
    Validator.readToBufferArgs(this, dst);
    BooleanDataTransfer.execute(buffer, dimensions(), dst, null);
    return this;
  }

  @Override
  public BooleanNdArray write(BooleanDataBuffer src) {
    Validator.writeFromBufferArgs(this, src);
    BooleanDataTransfer.execute(src, null, buffer, dimensions());
    return this;
  }

  @Override
  public NdArrayCursor<Boolean, BooleanNdArray> cursor(int dimensionIdx) {
    BooleanDataBuffer mutableBuffer = BooleanMutableDataBuffer.create(buffer());
    BooleanDenseNdArray mutableElement = new BooleanDenseNdArray(mutableBuffer, dimensions().from(dimensionIdx));
    return new DenseNdArrayCursor<>(mutableElement, dimensions());
  }

  protected BooleanDenseNdArray(BooleanDataBuffer buffer, Shape shape) {
    this(buffer, DimensionalSpace.create(shape));
  }

  @Override
  BooleanDenseNdArray instantiate(DataBuffer<Boolean> buffer, DimensionalSpace dimensions) {
    return new BooleanDenseNdArray((BooleanDataBuffer)buffer, dimensions);
  }

  @Override
  protected BooleanDataBuffer buffer() {
    return buffer;
  }

  private final BooleanDataBuffer buffer;

  private BooleanDenseNdArray(BooleanDataBuffer buffer, DimensionalSpace dimensions) {
    super(dimensions);
    this.buffer = buffer;
  }
}