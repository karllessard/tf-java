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
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.slice.IntDataBufferSlice;

/**
 * A {@link DataBuffer} of integers.
 */
public interface IntDataBuffer extends DataBuffer<Integer> {

  /**
   * Retrieve values of this buffer as a stream of integers <i>(optional operation)</i>.
   * 
   * @return values, as a stream
   * @throws UnsupportedOperationException if streaming is not supported by this buffer
   */
  IntStream intStream();

  /**
   * Relative <i>get</i> method.
   *
   * Reads the integer at this buffer's current position, and then increments the position.
   *
   * @return the integer at the buffer's current position
   * @throws BufferUnderflowException if the buffer's current position is not smaller than its limit
   */
  int getInt();

  /**
   * Absolute <i>get</i> method.
   *
   * Reads the integer at the given index.
   *
   * @param index the index from which the float will be read
   * @return the integer at the given index
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer's limit
   */
  int getInt(long index);

  /**
   * Relative bulk <i>get</i> method, using int arrays.
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
  default IntDataBuffer get(int[] dst) { return get(dst, 0, dst.length); }
  
  /**
   * Relative bulk <i>get</i> method, using int arrays.
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
  IntDataBuffer get(int[] dst, int offset, int length);

  /**
   * Relative <i>put</i> method.
   *
   * Writes the given integer into this buffer at the current position, and then increments the position.

   * @param value integer to be written
   * @return this buffer
   * @throws BufferOverflowException if this buffer's current position is not smaller than its limit
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  IntDataBuffer putInt(int value);

  /**
   * Absolute <i>put</i> method.
   *
   * Writes the given integer into this buffer at the given index.
   *
   * @param index the index at which the value will be written
   * @param value the integer to be written
   * @return this buffer
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer's limit
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  IntDataBuffer putInt(long index, int value);

  /**
   * Relative bulk <i>put</i> method, using int arrays.
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
  default IntDataBuffer put(int[] src) { return put(src, 0, src.length); }
  
  /**
   * Relative bulk <i>put</i> method, using int arrays.
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
  IntDataBuffer put(int[] src, int offset, int length);
  
  @Override
  IntDataBuffer limit(long newLimit);

  @Override
  default IntDataBuffer withLimit(long limit) {
    return duplicate().limit(limit);
  }

  @Override
  IntDataBuffer position(long newPosition);

  @Override
  default IntDataBuffer withPosition(long position) {
    return duplicate().position(position);
  }

  @Override
  IntDataBuffer rewind();

  @Override
  default Stream<Integer> stream() {
    return intStream().boxed();
  }

  @Override
  default Integer get() {
    return getInt();
  }

  @Override
  default Integer get(long index) {
    return getInt(index);
  }

  @Override
  default IntDataBuffer put(Integer value) {
    return putInt(value);
  }

  @Override
  default IntDataBuffer put(long index, Integer value) {
    return putInt(index, value);
  }

  @Override
  IntDataBuffer put(DataBuffer<Integer> src);
  
  @Override
  IntDataBuffer duplicate();

  @Override
  default IntDataBuffer slice() {
    return mutableSlice();
  }

  @Override
  default IntDataBufferSlice mutableSlice() {
    return IntDataBufferSlice.create(this);
  }
}
