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

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

/**
 * A buffer of bytes using a JDK {@link IntBuffer} for storage.
 * <p>
 * Since JDK buffers supports only 32-bits indexation, the capacity of this buffer type cannot
 * exceed 2<sup>32</sup> - 1 (see {@link IntJdkDataBuffer#MAX_CAPACITY} for the real maximum
 * value supported).
 */
public final class IntJdkDataBuffer extends AbstractJdkDataBuffer<Integer>
    implements IntDataBuffer {

  /**
   * The maximum capacity for a buffer of this type, i.e. the maximum number of bytes it can store.
   * <p>
   * As the maximum capacity may vary depending on the JVM implementation and on the platform, this
   * property returns a value that is safe for most of them.
   */
  public static long MAX_CAPACITY = AbstractJdkDataBuffer.MAX_CAPACITY;

  /**
   * Allocates a new byte buffer, initialized with zeroes.
   *
   * @param capacity the new buffer's capacity, in bytes
   * @return the new byte buffer
   * @throws IllegalArgumentException if the capacity is a negative integer or exceeds
   *                                  {@link #MAX_CAPACITY}.
   */
  public static IntDataBuffer allocate(long capacity) {
    if (capacity > MAX_CAPACITY) {
      throw new IllegalArgumentException("Capacity of a JDK data buffer cannot exceeds "
          + MAX_CAPACITY + " bytes, use IntJoinDataBuffer instead");
    }
    return new IntJdkDataBuffer(IntBuffer.allocate((int)capacity));
  }

  /**
   * Wraps a JDK {@link IntBuffer} into a {@code IntDataBuffer}.
   *
   * @param buffer buffer to wrap
   * @return the new byte buffer
   */
  public static IntDataBuffer wrap(IntBuffer buffer) {
    return new IntJdkDataBuffer(buffer);
  }

  @Override
  public IntStream intStream() {
    if (!buf.hasArray()) {
      throw new UnsupportedOperationException("Only buffers backed by an array supports streaming");
    }
    return Arrays.stream(buf.array());
  }

  @Override
  public int getInt(long index) {
    Validator.getArgs(this, index);
    return buf.get((int)index);
  }

  @Override
  public IntDataBuffer putInt(long index, int value) {
    Validator.putArgs(this, index);
    buf.put((int)index, value);
    return this;
  }

  @Override
  public IntDataBuffer read(int[] dst, int offset, int length) {
    buf.get(dst, offset, length);
    return this;
  }

  @Override
  public IntDataBuffer write(int[] src, int offset, int length) {
    buf.put(src, offset, length);
    return this;
  }

  @Override
  public IntDataBuffer copyTo(DataBuffer<Integer> dst) {
    Validator.copyToArgs(this, dst);
    if (dst instanceof IntJdkDataBuffer) {
      ((IntJdkDataBuffer)dst).buf.duplicate().put(buf.duplicate());
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public IntDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return new IntJdkDataBuffer(((IntBuffer)buf.duplicate().position((int)index)).slice());
  }

  @Override
  public IntDataBuffer narrow(long capacity) {
    Validator.narrowArgs(this, capacity);
    return new IntJdkDataBuffer(((IntBuffer)buf.duplicate().limit((int)capacity)).slice());
  }

  @Override
  IntBuffer buf() {
    return buf;
  }

  private IntJdkDataBuffer(IntBuffer buf) {
    this.buf = buf;
  }

  private IntBuffer buf;
}
