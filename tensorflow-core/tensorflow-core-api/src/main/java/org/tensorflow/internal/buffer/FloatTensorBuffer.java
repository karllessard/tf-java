package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.FloatRawDataBuffer;

public class FloatTensorBuffer extends FloatRawDataBuffer  {

  public static FloatDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new FloatTensorBuffer(address, size);
  }

  private FloatTensorBuffer(long address, long size) {
    super(address, size);
  }
}
