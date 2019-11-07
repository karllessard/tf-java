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

package org.tensorflow.nio.buffer.impl.jdk;

import java.nio.ShortBuffer;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.ShortDataBuffer;

/**
 * A buffer of bytes using a JDK {@link ShortBuffer} for storage.
 * <p>
 * Since JDK buffers supports only 32-bits indexation, the capacity of this buffer type cannot exceed
 * 2<sup>32</sup> - 1 (see {@link ShortJdkDataBuffer.MAX_CAPACITY} for the real maximum value supported).
 */
public final class ShortJdkDataBuffer extends AbstractJdkDataBuffer<Short, ShortDataBuffer> implements ShortDataBuffer {

  /**
   * The maximum capacity for a buffer of this type, i.e. the maximum number of bytes it can store.
   * <p>
   * As the maximum capacity may vary depending on the JVM implementation and on the platform, this property returns
   * a value that is safe for most of them.
   */
  public static long MAX_CAPACITY = AbstractJdkDataBuffer.MAX_CAPACITY;

  /**
   * Allocates a new byte buffer.
   * <p>
   * The new buffer's position will be zero, its limit will be its capacity, and each of its elements will be initialized to zero.
   *
   * @param capacity the new buffer's capacity, in bytes
   * @return the new byte buffer
   * @throws IllegalArgumentException if the capacity is a negative integer or exceeds {@link MAX_CAPACITY}.
   */
  public static ShortDataBuffer allocate(long capacity) {
    if (capacity > MAX_CAPACITY) {
      throw new IllegalArgumentException("Capacity of a JDK data buffer cannot exceeds " + MAX_CAPACITY +
          " bytes, use ShortJoinDataBuffer instead");
    }
    return new ShortJdkDataBuffer(ShortBuffer.allocate((int)capacity));
  }

  /**
   * Wraps a JDK {@link ShortBuffer} into a {@code ShortDataBuffer}.
   *
   * The new buffer's position, limit and capacity will be the one of the buf passed in parameter, and each of its elements will
   * preserver their values.
   *
   * @param buffer buffer to wrap
   * @return the new byte buffer
   */
  public static ShortDataBuffer wrap(ShortBuffer buffer) {
    return new ShortJdkDataBuffer(buffer);
  }

  @Override
  public short getShort() {
    return buf.get();
  }

  @Override
  public short getShort(long index) {
    return buf.get((int)index);
  }

  @Override
  public ShortDataBuffer get(short[] dst, int offset, int length) {
    buf.get(dst, offset, length);
    return this;
  }

  @Override
  public Stream<Short> stream() {
    throw new UnsupportedOperationException("ShortDataBuffer does not support value streaming at the moment");
  }

  @Override
  public ShortDataBuffer putShort(short value) {
    buf.put(value);
    return this;
  }

  @Override
  public ShortDataBuffer putShort(long index, short value) {
    buf.put((int)index, value);
    return this;
  }

  @Override
  public ShortDataBuffer put(short[] src, int offset, int length) {
    buf.put(src, offset, length);
    return this;
  }

  @Override
  public ShortDataBuffer put(DataBuffer<Short> src) {
    if (src instanceof ShortJdkDataBuffer) {
      buf.put(((ShortJdkDataBuffer)src).buf);
      return this;
    }
    return super.put(src);
  }

  @Override
  public ShortDataBuffer duplicate() {
    return new ShortJdkDataBuffer(buf.duplicate());
  }

  @Override
  public ShortDataBuffer slice() {
    return new ShortJdkDataBuffer(buf.slice());
  }

  @Override
  protected ShortBuffer buf() {
    return buf;
  }

  private ShortJdkDataBuffer(ShortBuffer buf) {
    this.buf = buf;
  }
  
  private ShortBuffer buf;
}
