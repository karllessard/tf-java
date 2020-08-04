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

import static org.tensorflow.internal.c_api.global.tensorflow.TF_Dim;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_NumDims;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorType;

import java.util.function.Consumer;
import org.bytedeco.javacpp.PointerScope;
import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.internal.tensor.buffer.TensorBuffers;
import org.tensorflow.ndarray.NdArray;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.ndarray.buffer.ByteDataBuffer;
import org.tensorflow.types.family.TType;

/**
 * A statically typed multi-dimensional array whose elements are of a type described by T.
 *
 * <p>Instances of a Tensor are <b>not</b> thread-safe.
 *
 * <p><b>WARNING:</b> Resources consumed by the Tensor object <b>must</b> be explicitly freed by
 * invoking the {@link #close()} method when the object is no longer needed. For example, using a
 * try-with-resources block:
 *
 * <pre>{@code
 * try (Tensor t = Tensor.of(...)) {
 *   doSomethingWith(t);
 * }
 * }</pre>
 */
public abstract class AbstractTensor<T> implements Tensor<T> {

  /**
   * Returns this Tensor object with the type {@code Tensor<U>}. This method is useful when given a
   * value of type {@code Tensor<?>}.
   *
   * @param dt any supported tensor data type
   * @throws IllegalArgumentException if the actual data type of this object does not match the type
   *     {@code U}.
   */
  @SuppressWarnings("unchecked")
  public <U extends TType> U expect(DataType<U> dt) {
    if (!dt.equals(this.dtype)) {
      throw new IllegalArgumentException(
          "Cannot cast from tensor of " + dtype + " to tensor of " + dt);
    }
    return (U)this;
  }

  /**
   * Release resources associated with the Tensor.
   *
   * <p><b>WARNING:</b>This must be invoked for all tensors that were not been produced by an eager
   * operation or memory will be leaked.
   *
   * <p>The Tensor object is no longer usable after {@code close} returns.
   */
  @Override
  public void close() {
    nativeHandle.close();
  }

  /** Returns the {@link DataType} of elements stored in the Tensor. */
  public DataType<?> dataType() {
    return dtype;
  }

  /** Returns the size, in bytes, of the tensor data. */
  public long numBytes() {
    if (numBytes == null) {
      numBytes = TF_TensorByteSize(nativeHandle);
    }
    return numBytes;
  }

  /**
   * Returns the raw data of this tensor as a buffer of bytes.
   *
   * <p>Use this method to obtain a read-only serializable view of the tensor raw data and must be
   * used with care since there is no guard on the element boundaries. For regular input or output
   * operations, use {@link #data()}.
   *
   * @return the tensor raw data mapped to a read-only byte buffer
   * @throws IllegalStateException if the tensor has been closed
   */
  public ByteDataBuffer rawData() {
    return TensorBuffers.toBytes(nativeHandle(), true);
  }

  /** Returns a string describing the type and shape of the Tensor. */
  @Override
  public String toString() {
    return String.format("%s tensor with shape %s", dtype.toString(), shape());
  }

  protected AbstractTensor(TF_Tensor nativeHandle, DataType<?> dtype) {
    this.nativeHandle = nativeHandle;
    this.dtype = dtype;
    nativeHandle.retainReference();
  }

  /**
   * @return native handle to this tensor
   * @throws IllegalStateException if tensor has been closed
   */
  TF_Tensor nativeHandle() {
    return requireHandle(nativeHandle);
  }

  void attachTo(EagerSession session) {
    session.attach(nativeHandle);
    nativeHandle.releaseReference();
  }

  protected static TF_Tensor requireHandle(TF_Tensor handle) {
    if (handle == null || handle.isNull()) {
      throw new IllegalStateException("close() was called on the Tensor");
    }
    return handle;
  }

  protected final TF_Tensor nativeHandle;
  private final DataType<?> dtype;
  private Long numBytes = null;
}
