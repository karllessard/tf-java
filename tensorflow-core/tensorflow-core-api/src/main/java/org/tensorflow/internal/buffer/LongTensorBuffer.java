package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.LongRawDataBuffer;

public class LongTensorBuffer extends LongRawDataBuffer {

  public static LongDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new LongTensorBuffer(address, size);
  }

  LongTensorBuffer(long address, long size) {
    super(address, size);
  }
}
