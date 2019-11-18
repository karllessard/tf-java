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
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.nd.ByteNdArray;
import org.tensorflow.nio.nd.ByteNdArray;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.mutable.ByteMutableDataBuffer;
import org.tensorflow.nio.nd.impl.dense.transfer.ByteDataTransfer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.NdArrayCursor;

public class ByteDenseNdArray extends AbstractDenseNdArray<Byte, ByteNdArray>
    implements ByteNdArray {

  public static ByteNdArray create(ByteDataBuffer buffer, Shape shape) {
    Validator.denseShape(buffer, shape);
    return new ByteDenseNdArray(buffer, shape);
  }

  @Override
  public byte getByte(long... indices) {
    return buffer().getByte(positionOf(indices, true));
  }

  @Override
  public ByteNdArray setByte(byte value, long... indices) {
    buffer().setByte(value, positionOf(indices, true));
    return this;
  }

  @Override
  public ByteNdArray read(byte[] dst, int offset) {
    Validator.getArrayArgs(this, dst.length, offset);
    return read(DataBuffers.wrap(dst, false).offset(offset));
  }

  @Override
  public ByteNdArray write(byte[] src, int offset) {
    Validator.putArrayArgs(this, src.length, offset);
    return write(DataBuffers.wrap(src, true).offset(offset));
  }

  @Override
  public ByteNdArray copyTo(NdArray<Byte> dst) {
    Validator.copyToNdArrayArgs(this, dst);
    if (dst instanceof ByteDenseNdArray) {
      ByteDenseNdArray floatDst = (ByteDenseNdArray)dst;
      ByteDataTransfer.execute(buffer, dimensions(), floatDst.buffer, floatDst.dimensions());
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public ByteNdArray read(ByteDataBuffer dst) {
    Validator.readToBufferArgs(this, dst);
    ByteDataTransfer.execute(buffer, dimensions(), dst, null);
    return this;
  }

  @Override
  public ByteNdArray write(ByteDataBuffer src) {
    Validator.writeFromBufferArgs(this, src);
    ByteDataTransfer.execute(src, null, buffer, dimensions());
    return this;
  }

  @Override
  public NdArrayCursor<Byte, ByteNdArray> cursor(int dimensionIdx) {
    ByteDataBuffer mutableBuffer = ByteMutableDataBuffer.create(buffer());
    ByteDenseNdArray mutableElement = new ByteDenseNdArray(mutableBuffer, dimensions().from(dimensionIdx));
    return new DenseNdArrayCursor<>(mutableElement, dimensions());
  }

  protected ByteDenseNdArray(ByteDataBuffer buffer, Shape shape) {
    this(buffer, DimensionalSpace.create(shape));
  }

  @Override
  ByteDenseNdArray instantiate(DataBuffer<Byte> buffer, DimensionalSpace dimensions) {
    return new ByteDenseNdArray((ByteDataBuffer)buffer, dimensions);
  }

  @Override
  protected ByteDataBuffer buffer() {
    return buffer;
  }

  private final ByteDataBuffer buffer;

  private ByteDenseNdArray(ByteDataBuffer buffer, DimensionalSpace dimensions) {
    super(dimensions);
    this.buffer = buffer;
  }
}