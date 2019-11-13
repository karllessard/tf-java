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
package org.tensorflow.nio.buffer.impl.misc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class ArrayDataBuffer<T> extends AbstractDataBuffer<T> {

  public static long MAX_CAPACITY = Integer.MAX_VALUE - 2;
  
  public static <T> DataBuffer<T> allocate(Class<T> clazz, long capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity must be non-negative");
    }
    if (capacity > MAX_CAPACITY) {
      throw new IllegalArgumentException("Size for an array-based data buffer cannot exceeds " + MAX_CAPACITY +
          " elements, use a JoinDataBuffer instead");
    }
    @SuppressWarnings("unchecked")
    T[] array = (T[])Array.newInstance(clazz, (int)capacity);
    return new ArrayDataBuffer<>(array, false);
  }

  public static <T> DataBuffer<T> wrap(T[] array, boolean readOnly) {
    return new ArrayDataBuffer<>(array, readOnly);
  }

  @Override
  public long capacity() {
    return length;
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public T get(long index) {
    Validator.getArgs(this, index);
    return values[(int)index + offset];
  }

  @Override
  public Stream<T> stream() {
    return Arrays.stream(values); // FIXME!
  }

  @Override
  public DataBuffer<T> put(long index, T value) {
    Validator.putArgs(this, index);
    values[(int)index + offset] = value;
    return this;
  }

  @Override
  public DataBuffer<T> copyTo(DataBuffer<T> dst) {
    Validator.copyToArgs(this, dst);
    if (dst instanceof ArrayDataBuffer) {
      ArrayDataBuffer<T> dstBuffer = (ArrayDataBuffer<T>)dst;
      System.arraycopy(values, offset, dstBuffer.values, dstBuffer.offset, dstBuffer.length);
    } else {
      slowCopyTo(dst);
    }
    return this;
  }

  @Override
  public DataBuffer<T> offset(long index) {
    Validator.offsetArgs(this, index);
    return new ArrayDataBuffer<>(values, readOnly, (int)index + offset, length);
  }

  @Override
  public DataBuffer<T> narrow(long capacity) {
    Validator.narrowArgs(this, capacity);
    return new ArrayDataBuffer<>(values, readOnly, offset, (int)capacity);
  }

  private ArrayDataBuffer(T[] values, boolean readOnly) {
    this(values, readOnly, 0, values.length);
  }

  private ArrayDataBuffer(T[] values, boolean readOnly, int offset, int length) {
    this.values = values;
    this.readOnly = readOnly;
    this.offset = offset;
    this.length = length;
  }
 
  private final T[] values;
  private final boolean readOnly;
  private final int offset;
  private final int length;
}
