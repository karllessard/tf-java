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
package org.tensorflow.nio.nd.impl.dense.mutable;

import java.util.stream.Stream;
import org.tensorflow.nio.buffer.DataBuffer;

@SuppressWarnings("unchecked")
public class MutableDataBuffer<T, U extends DataBuffer<T>> implements DataBuffer<T> {

  public static <T, U extends DataBuffer<T>> MutableDataBuffer<T, U> create(U buffer) {
    return new MutableDataBuffer<>(buffer, 0, buffer.size());
  }

  public void moveTo(long startIndex) {
    this.startIndex = startIndex;
    slice = null;
  }

  @Override
  public long size() {
    return size;
  }

  @Override
  public boolean isReadOnly() {
    return original.isReadOnly();
  }

  @Override
  public Stream<T> stream() {
    return slice().stream();
  }

  @Override
  public T get(long index) {
    return original.get(adjust(index));
  }

  @Override
  public U set(T value, long index) {
    original.set(value, adjust(index));
    return (U)this;
  }

  @Override
  public U copyTo(DataBuffer<T> dst, long size) {
    slice().copyTo(dst, size);
    return (U)this;
  }

  @Override
  public U offset(long index) {
    return (U)original.offset(index + startIndex);
  }

  @Override
  public U narrow(long size) {
    return (U)original.offset(startIndex).narrow(size);
  }

  U original() {
    return original;
  }

  U slice() {
    if (slice == null) {
      slice = (U)original.offset(startIndex).narrow(size);
    }
    return slice;
  }

  long adjust(long index) {
    return index + startIndex;
  }

  MutableDataBuffer(U original, long startIndex, long size) {
    this.original = original;
    this.startIndex = startIndex;
    this.size = size;
  }

  private final U original;
  private U slice;
  private long startIndex;
  private long size;
}
