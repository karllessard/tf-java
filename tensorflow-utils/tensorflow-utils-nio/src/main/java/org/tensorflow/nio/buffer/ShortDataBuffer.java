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
package org.tensorflow.nio.buffer;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ReadOnlyBufferException;
import org.tensorflow.nio.buffer.slice.ShortDataBufferSlice;

/**
 * A {@link DataBuffer} of shorts.
 */
public interface ShortDataBuffer extends DataBuffer<Short> {

  /**
   * Relative <i>get</i> method.
   *
   * Reads the short at this buffer's current position, and then increments the position.
   *
   * @return the short at the buffer's current position
   * @throws BufferUnderflowException if the buffer's current position is not smaller than its limit
   */
  short getShort();

  /**
   * Absolute <i>get</i> method.
   *
   * Reads the short at the given index.
   *
   * @param index the index from which the short will be read
   * @return the short at the given index
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer's limit
   */
  short getShort(long index);

  /**
   * Relative bulk <i>get</i> method, using short arrays.
   * <p>
   * This method transfers values from this buffer into the given destination array. If there are 
   * fewer values remaining in the buffer than are required to satisfy the request, that is, if 
   * {@code dst.length > remaining()}, then no values are transferred and a BufferUnderflowException is thrown.
   * <p>
   * Otherwise, this method copies {@code n = dst.length} values from this buffer into the given array, starting at the current 
   * position of this buffer. The position of this buffer is then incremented by {@code n}. 
   * 
   * @param dst the array into which values are to be written
   * @return this buffer
   * @throws BufferUnderflowException if there are fewer than length values remaining in this buffer
   */
  default ShortDataBuffer get(short[] dst) { return get(dst, 0, dst.length); }
  
  /**
   * Relative bulk <i>get</i> method, using short arrays.
   * <p>
   * This method transfers values from this buffer into the given destination array. If there are 
   * fewer values remaining in the buffer than are required to satisfy the request, that is, if 
   * {@code length > remaining()}, then no values are transferred and a BufferUnderflowException is thrown.
   * <p>
   * Otherwise, this method copies {@code n = length} values from this buffer into the given array, starting at the current 
   * position of this buffer and at the given offset in the array. The position of this buffer is then incremented by {@code n}. 
   * 
   * @param dst the array into which values are to be written
   * @param offset the offset within the array of the first value to be written; must be non-negative and no larger than {@code dst.length}
   * @param length the maximum number of values to be written to the given array; must be non-negative and no larger than {@code dst.length - offset}
   * @return this buffer
   * @throws BufferUnderflowException if there are fewer than length values remaining in this buffer
   * @throws IndexOutOfBoundsException if the preconditions on the offset and length parameters do not hold
   */
  ShortDataBuffer get(short[] dst, int offset, int length);

  /**
   * Relative <i>put</i> method.
   *
   * Writes the given short into this buffer at the current position, and then increments the position.

   * @param value short to be written
   * @return this buffer
   * @throws BufferOverflowException if this buffer's current position is not smaller than its limit
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  ShortDataBuffer putShort(short value);

  /**
   * Absolute <i>put</i> method.
   *
   * Writes the given short into this buffer at the given index.
   *
   * @param index the index at which the value will be written
   * @param value the short to be written
   * @return this buffer
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer's limit
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  ShortDataBuffer putShort(long index, short value);

  /**
   * Relative bulk <i>put</i> method, using short arrays.
   * <p>
   * This method transfers the values in the given source array into this buffer. If there are 
   * more values in the source array than in this buffer, that is, if {@code src.length > remaining()}, 
   * then no values are transferred and a BufferOverflowException is thrown.
   * <p>
   * Otherwise, this method copies {@code n = src.length} values from the given array into this buffer, 
   * starting at this buffer current position. The position of this buffer is then incremented by {@code n}.
   * 
   * @param src the source array from which values are to be read
   * @return this buffer
   * @throws BufferOverflowException if there is insufficient space in this buffer for the remaining values in the source array
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  default ShortDataBuffer put(short[] src) { return put(src, 0, src.length); }
  
  /**
   * Relative bulk <i>put</i> method, using short arrays.
   * <p>
   * This method transfers the values in the given source array into this buffer. If there are 
   * more values in the source array than in this buffer, that is, if {@code length > remaining()}, 
   * then no values are transferred and a BufferOverflowException is thrown.
   * <p>
   * Otherwise, this method copies {@code n = length} values from the given array into this buffer, 
   * starting at the given offset in the array and at this buffer current position. The position of this buffer 
   * is then incremented by {@code n}.
   * 
   * @param src the source array from which values are to be read
   * @param offset the offset within the array of the first value to be read; must be non-negative and no larger than {@code src.length}
   * @param length the number of values to be read from the given array; must be non-negative and no larger than {@code src.length - offset}
   * @return this buffer
   * @throws BufferOverflowException if there is insufficient space in this buffer for the remaining values in the source array
   * @throws IndexOutOfBoundsException if the preconditions on the offset and length parameters do not hold
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  ShortDataBuffer put(short[] src, int offset, int length);
  
  @Override
  ShortDataBuffer limit(long newLimit);

  @Override
  default ShortDataBuffer withLimit(long limit) {
    return duplicate().limit(limit);
  }

  @Override
  ShortDataBuffer position(long newPosition);

  @Override
  default ShortDataBuffer withPosition(long position) {
    return duplicate().position(position);
  }

  @Override
  ShortDataBuffer rewind();

  @Override
  default Short get() {
    return getShort();
  }

  @Override
  default Short get(long index) {
    return getShort(index);
  }

  @Override
  default ShortDataBuffer put(Short value) {
    return putShort(value);
  }

  @Override
  default ShortDataBuffer put(long index, Short value) {
    return putShort(index, value);
  }

  @Override
  ShortDataBuffer put(DataBuffer<Short> src);
  
  @Override
  ShortDataBuffer duplicate();

  @Override
  default ShortDataBuffer slice() {
    return mutableSlice();
  }

  @Override
  default ShortDataBufferSlice mutableSlice() {
    return ShortDataBufferSlice.create(this);
  }
}
