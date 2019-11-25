package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.DoubleRawDataBuffer;

public class DoubleTensorBuffer extends DoubleRawDataBuffer  {

  public static DoubleDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new DoubleTensorBuffer(address, size);
  }

  private DoubleTensorBuffer(long address, long size) {
    super(address, size);
  }
}
