/* Copyright 2016 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package org.tensorflow;

import java.nio.ByteBuffer;
import org.tensorflow.nio.nd.Shape;

/** Represents the type of elements in a {@link Tensor} as an enum. */
public class DataType<T> {

  @FunctionalInterface
  public interface TensorDataMapper<T> {
    T mapTensor(ByteBuffer[] tensorBuffer, Shape shape);
  }

  private final int value;
  private final int byteSize;
  private final TensorDataMapper<T> tensorDataMapper;

  /**
   * @param value must match the corresponding TF_* value in the TensorFlow C API.
   * @param byteSize size of an element of this type, in bytes, -1 if unknown
   */
  public DataType(int value, int byteSize, TensorDataMapper<T> tensorDataMapper) {
    this.value = value;
    this.byteSize = byteSize;
    this.tensorDataMapper = tensorDataMapper;
  }

  /**
   * Returns the size of an element of this type, in bytes, or -1 if element size is variable.
   */
  public int byteSize() {
    return byteSize;
  }

  /** Corresponding value of the TF_DataType enum in the TensorFlow C API. */
  int c() {
    return value;
  }

  T mapTensor(Shape shape, ByteBuffer[] tensorBuffers) {
    return tensorDataMapper.mapTensor(tensorBuffers, shape);
  }
}
