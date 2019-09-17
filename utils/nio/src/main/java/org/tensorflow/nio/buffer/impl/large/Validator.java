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
package org.tensorflow.nio.buffer.impl.large;

import org.tensorflow.nio.buffer.DataBuffer;

class Validator extends org.tensorflow.nio.buffer.impl.Validator {

  static <T> boolean joinBuffers(DataBuffer<T>[] buffers) {
    if (buffers == null || buffers.length == 0) {
      throw new IllegalArgumentException("Large buffers need at least one sub buffer");
    }
    boolean readOnly = false;
    long bufferMaxCapacity = buffers[0].capacity();
    for (int i = 0; i < buffers.length; ++i) {
      if (buffers[i].capacity() != bufferMaxCapacity && i < buffers.length - 1) {
        throw new IllegalArgumentException("The first (n - 1) buffers must have the same capacity");
      }
      if (buffers[i].isReadOnly()) {
        readOnly = true; // large buffer is read-only as soon as one of its sub buffer is read-only
      }
    }
    return readOnly;
  }
}
