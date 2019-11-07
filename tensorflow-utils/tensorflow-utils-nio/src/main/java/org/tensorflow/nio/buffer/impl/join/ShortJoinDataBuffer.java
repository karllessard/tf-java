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
package org.tensorflow.nio.buffer.impl.join;

import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.ShortJdkDataBuffer;

public final class ShortJoinDataBuffer extends
    AbstractJoinDataBuffer<Short, ShortDataBuffer> implements ShortDataBuffer {

  public static long MAX_CAPACITY = ShortJdkDataBuffer.MAX_CAPACITY * ShortJdkDataBuffer.MAX_CAPACITY;

  public static ShortDataBuffer allocate(long capacity) {
    if (capacity > MAX_CAPACITY) {
      throw new IllegalArgumentException("Capacity for a joined data buffer cannot exceeds " + MAX_CAPACITY + " bytes");
    }
    ShortDataBuffer[] buffers = allocateBuffers(ShortDataBuffer.class, capacity, ShortJdkDataBuffer.MAX_CAPACITY, ShortJdkDataBuffer::allocate);
    return new ShortJoinDataBuffer(buffers, false);
  }

  public static ShortDataBuffer join(ShortDataBuffer... buffers) {
    boolean readOnly = Validator.joinBuffers(buffers);
    return new ShortJoinDataBuffer(buffers, readOnly);
  }

  @Override
  public short getShort() {
    short value = currentBuffer().getShort();
    onPositionIncrement();
    return value;
  }

  @Override
  public short getShort(long index) {
    Validator.getArgs(this, index);
    int bufferIdx = bufferIndex(index);
    return buffer(bufferIdx).getShort(indexInBuffer(bufferIdx, index));
  }

  @Override
  public ShortDataBuffer get(short[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    copyArray(offset, length, (b, o, l) -> ((ShortDataBuffer)b).get(dst, o, l));
    return this;
  }

  @Override
  public ShortDataBuffer putShort(short value) {
    Validator.put(this);
    currentBuffer().putShort(value);
    onPositionIncrement();
    return this;
  }

  @Override
  public ShortDataBuffer putShort(long index, short value) {
    Validator.putArgs(this, index);
    int bufferIdx = bufferIndex(index);
    buffer(bufferIdx).putShort(indexInBuffer(bufferIdx, index), value);
    return this;
  }

  @Override
  public ShortDataBuffer put(short[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    copyArray(offset, length, (b, o, l) -> ((ShortDataBuffer)b).put(src, o, l));
    return this;
  }

  @Override
  protected ShortJoinDataBuffer instantiate(ShortDataBuffer[] buffers, boolean readOnly) {
    return new ShortJoinDataBuffer(buffers, readOnly);
  }

  private ShortJoinDataBuffer(ShortDataBuffer[] buffers, boolean readOnly) {
    super(buffers, readOnly);
  }
}
