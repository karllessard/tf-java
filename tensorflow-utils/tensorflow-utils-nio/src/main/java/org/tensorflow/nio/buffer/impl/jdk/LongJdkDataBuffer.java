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

import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.stream.LongStream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

/**
 * A buffer of bytes using a JDK {@link LongBuffer} for storage.
 * <p>
 * Since JDK buffers supports only 32-bits indexation, the size of this buffer type cannot
 * exceed 2<sup>32</sup> - 1 (see {@link LongJdkDataBuffer#MAX_CAPACITY} for the real maximum
 * value supported).
 */
public final class LongJdkDataBuffer extends AbstractJdkDataBuffer<Long>
    implements LongDataBuffer {

  /**
   * The maximum size for a buffer of this type, i.e. the maximum number of bytes it can store.
   * <p>
   * As the maximum size may vary depending on the JVM implementation and on the platform, this
   * property returns a value that is safe for most of them.
   */
  public static long MAX_CAPACITY = AbstractJdkDataBuffer.MAX_CAPACITY;

  /**
   * Allocates a new byte buffer, initialized with zeroes.
   *
   * @param size the new buffer's size, in bytes
   * @return the new byte buffer
   * @throws IllegalArgumentException if the size is a negative integer or exceeds
   *                                  {@link #MAX_CAPACITY}.
   */
  public static LongDataBuffer allocate(long size) {
    if (size > MAX_CAPACITY) {
      throw new IllegalArgumentException("Capacity of a JDK data buffer cannot exceeds "
          + MAX_CAPACITY + " bytes, use LongJoinDataBuffer instead");
    }
    return new LongJdkDataBuffer(LongBuffer.allocate((int)size));
  }

  /**
   * Wraps a JDK {@link LongBuffer} into a {@code LongDataBuffer}.
   *
   * @param buffer buffer to wrap
   * @return the new byte buffer
   */
  public static LongDataBuffer wrap(LongBuffer buffer) {
    return new LongJdkDataBuffer(buffer);
  }

  @Override
  public LongStream longStream() {
    if (!buf.hasArray()) {
      throw new UnsupportedOperationException("Only buffers backed by an array supports streaming");
    }
    return Arrays.stream(buf.array());
  }

  @Override
  public long getLong(long index) {
    Validator.getArgs(this, index);
    return buf.get((int)index);
  }

  @Override
  public LongDataBuffer setLong(long value, long index) {
    Validator.putArgs(this, index);
    buf.put((int)index, value);
    return this;
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    buf.get(dst, offset, length).rewind();
    return this;
  }

  @Override
  public LongDataBuffer write(long[] src, int offset, int length) {
    buf.put(src, offset, length).rewind();
    return this;
  }

  @Override
  public LongDataBuffer copyTo(DataBuffer<Long> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    if (dst instanceof LongJdkDataBuffer) {
      LongBuffer dstBuf = ((LongJdkDataBuffer)dst).buf.duplicate();
      LongBuffer srcBuf = (LongBuffer)buf.duplicate().limit((int)size);
      dstBuf.put(srcBuf);
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public LongDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return new LongJdkDataBuffer(((LongBuffer)buf.duplicate().position((int)index)).slice());
  }

  @Override
  public LongDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return new LongJdkDataBuffer(((LongBuffer)buf.duplicate().limit((int)size)).slice());
  }

  @Override
  LongBuffer buf() {
    return buf;
  }

  private LongJdkDataBuffer(LongBuffer buf) {
    this.buf = buf;
  }

  private LongBuffer buf;
}
