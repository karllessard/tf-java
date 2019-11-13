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
import java.nio.ReadOnlyBufferException;
import java.util.stream.Stream;

/**
 * A container of data of a specific type.
 *
 * <p>Instances of {@code DataBuffer} map native or heap memory segments to a linear view that
 * supports:
 * <ul>
 *  <li>64-bits indexation, allowing to work with a single buffer with a capacity up to
 *      approximately 2<sup>63</sup> bytes</li>
 *  <li>Storage of object of any types and not only primitives</li>
 *  <li>Generic types allows to work directly with boxed types as well, which does not require
 *      explicit buffer types as with the standard JDK buffers.
 * </ul> 
 * It is important to note that there is no guarantee the memory managed by a {@code DataBuffer}
 * is linear, specially when dealing with non-primitive types or large buffers.
 * 
 * @param <T> type of data stored in this buffer
 */
public interface DataBuffer<T> {

  /**
   * Size of the buffer, in elements.
   * <p>
   * For exemple, in case of a byte buffer, this value is equal to the number of bytes this buffer
   * can hold. For an integer buffer, it is equal to the number of integers, therefore the size
   * in bytes of this buffer is {@code capacity() * Integer.BYTES}.
   * 
   * @return the buffer capacity
   */
  long capacity();

  /**
   * Tells whether or not this buffer is backed by an accessible array.
   * 
   * @return true if, and only if, this buffer is read-only
   */
  boolean isReadOnly();

  /**
   * Retrieve values of this buffer as a Java stream <i>(optional operation)</i>.
   *
   * @return values, as a stream
   * @throws UnsupportedOperationException if streaming is not supported by this buffer
   */
  default Stream<T> stream() {
    throw new UnsupportedOperationException("Data streaming from this buffer is not supported");
  }

  /**
   * Reads the value at the given index.
   *
   * <b>Important: </b>Usage of this method should be limited to buffers of non-primitive types or
   * when the data type is not deterministically known by the caller. In any other case, prefer
   * the usage of its primitive variant which will significantly improve performances
   * (e.g. {@code IntDataBuffer.getInt(idx)}
   * 
   * @param index the index from which the float will be read
   * @return the value at the given index
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer capacity
   */
  T get(long index);

  /**
   * Writes the given value into this buffer at the given index.
   *
   * <b>Important: </b>Usage of this method should be limited to buffers of non-primitive types or
   * when the data type is not deterministically known by the caller. In any other case, prefer
   * the usage of its primitive variant which will significantly improve performances
   * (e.g. {@code IntDataBuffer.putInt(idx)}
   *
   * @param index the index at which the value will be written
   * @param value the value to be written
   * @return this buffer
   * @throws IndexOutOfBoundsException if index is negative or not smaller than the buffer capacity
   * @throws ReadOnlyBufferException if this buffer is read-only
   */
  DataBuffer<T> put(long index, T value);
  
  /**
   * Copy data of this buffer in the given buffer.
   * <p>
   * If there are more values in this buffer than the destination buffer capacity, that is, if
   * {@code capacity() > dst.capacity()}, then no values are transferred and a
   * BufferOverflowException is thrown.
   * <p>
   * Otherwise, this method copies {@code n = capacity()} values from this buffer into
   * the destination buffer.
   *
   * @param dst the destination buffer into which values are copied; must not be this buffer
   * @return this buffer
   * @throws BufferOverflowException if there is insufficient space in the destination buffer for
   *                                 the number of values stored in this buffer
   * @throws IllegalArgumentException if the destination buffer is this buffer
   * @throws ReadOnlyBufferException if the destination buffer is read-only
   */
  DataBuffer<T> copyTo(DataBuffer<T> dst);

  /**
   * Creates a new buffer whose content is a shared subsequence of this buffer's content, starting
   * at the given index.
   * <p>
   * The index must not be greater than this buffer capacity. Changes to this buffer's content will
   * be visible in the new buffer and vice versa. The new buffer will be read-only if, and only if,
   * this buffer is read-only.
   *
   * @param index index of the first value of the new buffer created, must not be greater than
   *              {@code capacity()}
   * @return the new buffer
   * @throws IllegalArgumentException if index do not pass validation checks
   */
  DataBuffer<T> offset(long index);

  /**
   * Creates a new buffer whose content is a shared subsequence of this buffer's content, whose
   * capacity is set to the given value.
   * <p>
   * The new capacity must not be greater than this buffer capacity. Changes to this buffer's
   * content will be visible in the new buffer and vice versa. The new buffer will be read-only if,
   * and only if, this buffer is read-only.
   *
   * @param capacity capacity of this new buffer, must not be greater than {@code capacity()}
   * @return the new buffer
   * @throws IllegalArgumentException if capacity value do not pass validation checks
   */
  DataBuffer<T> narrow(long capacity);
}
