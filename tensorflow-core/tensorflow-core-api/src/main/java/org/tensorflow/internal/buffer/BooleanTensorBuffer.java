package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.BooleanRawDataBuffer;

public class BooleanTensorBuffer extends BooleanRawDataBuffer {

  public static BooleanDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new BooleanTensorBuffer(address, size);
  }

  private BooleanTensorBuffer(long address, long size) {
    super(address, size);
  }
}
