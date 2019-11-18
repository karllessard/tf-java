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
import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.nd.ShortNdArray;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.ShortNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.mutable.ShortMutableDataBuffer;
import org.tensorflow.nio.nd.impl.dense.transfer.ShortDataTransfer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.NdArrayCursor;

public class ShortDenseNdArray extends AbstractDenseNdArray<Short, ShortNdArray>
    implements ShortNdArray {

  public static ShortNdArray create(ShortDataBuffer buffer, Shape shape) {
    Validator.denseShape(buffer, shape);
    return new ShortDenseNdArray(buffer, shape);
  }

  @Override
  public short getShort(long... indices) {
    return buffer().getShort(positionOf(indices, true));
  }

  @Override
  public ShortNdArray setShort(short value, long... indices) {
    buffer().setShort(value, positionOf(indices, true));
    return this;
  }

  @Override
  public ShortNdArray read(short[] dst, int offset) {
    Validator.getArrayArgs(this, dst.length, offset);
    return read(DataBuffers.wrap(dst, false).offset(offset));
  }

  @Override
  public ShortNdArray write(short[] src, int offset) {
    Validator.putArrayArgs(this, src.length, offset);
    return write(DataBuffers.wrap(src, true).offset(offset));
  }

  @Override
  public ShortNdArray copyTo(NdArray<Short> dst) {
    Validator.copyToNdArrayArgs(this, dst);
    if (dst instanceof ShortDenseNdArray) {
      ShortDenseNdArray floatDst = (ShortDenseNdArray)dst;
      ShortDataTransfer.execute(buffer, dimensions(), floatDst.buffer, floatDst.dimensions());
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public ShortNdArray read(ShortDataBuffer dst) {
    Validator.readToBufferArgs(this, dst);
    ShortDataTransfer.execute(buffer, dimensions(), dst, null);
    return this;
  }

  @Override
  public ShortNdArray write(ShortDataBuffer src) {
    Validator.writeFromBufferArgs(this, src);
    ShortDataTransfer.execute(src, null, buffer, dimensions());
    return this;
  }

  @Override
  public NdArrayCursor<Short, ShortNdArray> cursor(int dimensionIdx) {
    ShortDataBuffer mutableBuffer = ShortMutableDataBuffer.create(buffer());
    ShortDenseNdArray mutableElement = new ShortDenseNdArray(mutableBuffer, dimensions().from(dimensionIdx));
    return new DenseNdArrayCursor<>(mutableElement, dimensions());
  }

  protected ShortDenseNdArray(ShortDataBuffer buffer, Shape shape) {
    this(buffer, DimensionalSpace.create(shape));
  }

  @Override
  ShortDenseNdArray instantiate(DataBuffer<Short> buffer, DimensionalSpace dimensions) {
    return new ShortDenseNdArray((ShortDataBuffer)buffer, dimensions);
  }

  @Override
  protected ShortDataBuffer buffer() {
    return buffer;
  }

  private final ShortDataBuffer buffer;

  private ShortDenseNdArray(ShortDataBuffer buffer, DimensionalSpace dimensions) {
    super(dimensions);
    this.buffer = buffer;
  }
}