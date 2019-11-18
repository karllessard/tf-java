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
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.nd.FloatNdArray;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.mutable.FloatMutableDataBuffer;
import org.tensorflow.nio.nd.impl.dense.transfer.FloatDataTransfer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.NdArrayCursor;

public class FloatDenseNdArray extends AbstractDenseNdArray<Float, FloatNdArray>
    implements FloatNdArray {

  public static FloatNdArray create(FloatDataBuffer buffer, Shape shape) {
    Validator.denseShape(buffer, shape);
    return new FloatDenseNdArray(buffer, shape);
  }

  @Override
  public float getFloat(long... indices) {
    return buffer().getFloat(positionOf(indices, true));
  }

  @Override
  public FloatNdArray setFloat(float value, long... indices) {
    buffer().setFloat(value, positionOf(indices, true));
    return this;
  }

  @Override
  public FloatNdArray read(float[] dst, int offset) {
    Validator.getArrayArgs(this, dst.length, offset);
    return read(DataBuffers.wrap(dst, false).offset(offset));
  }

  @Override
  public FloatNdArray write(float[] src, int offset) {
    Validator.putArrayArgs(this, src.length, offset);
    return write(DataBuffers.wrap(src, true).offset(offset));
  }

  @Override
  public FloatNdArray copyTo(NdArray<Float> dst) {
    Validator.copyToNdArrayArgs(this, dst);
    if (dst instanceof FloatDenseNdArray) {
      FloatDenseNdArray floatDst = (FloatDenseNdArray)dst;
      FloatDataTransfer.execute(buffer, dimensions(), floatDst.buffer, floatDst.dimensions());
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public FloatNdArray read(FloatDataBuffer dst) {
    Validator.readToBufferArgs(this, dst);
    FloatDataTransfer.execute(buffer, dimensions(), dst, null);
    return this;
  }

  @Override
  public FloatNdArray write(FloatDataBuffer src) {
    Validator.writeFromBufferArgs(this, src);
    FloatDataTransfer.execute(src, null, buffer, dimensions());
    return this;
  }

  @Override
  public NdArrayCursor<Float, FloatNdArray> cursor(int dimensionIdx) {
    FloatDataBuffer mutableBuffer = FloatMutableDataBuffer.create(buffer());
    FloatDenseNdArray mutableElement = new FloatDenseNdArray(mutableBuffer,
        dimensions().from(dimensionIdx));
    return new DenseNdArrayCursor<>(mutableElement, dimensions());
  }

  protected FloatDenseNdArray(FloatDataBuffer buffer, Shape shape) {
    this(buffer, DimensionalSpace.create(shape));
  }

  @Override
  FloatDenseNdArray instantiate(DataBuffer<Float> buffer, DimensionalSpace dimensions) {
    return new FloatDenseNdArray((FloatDataBuffer) buffer, dimensions);
  }

  @Override
  public FloatDataBuffer buffer() {
    return buffer;
  }

  private final FloatDataBuffer buffer;

  private FloatDenseNdArray(FloatDataBuffer buffer, DimensionalSpace dimensions) {
    super(dimensions);
    this.buffer = buffer;
  }
}
