package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.IntRawDataBuffer;

public class IntTensorBuffer extends IntRawDataBuffer  {

  public static IntDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new IntTensorBuffer(address, size);
  }

  private IntTensorBuffer(long address, long size) {
    super(address, size);
  }
}
