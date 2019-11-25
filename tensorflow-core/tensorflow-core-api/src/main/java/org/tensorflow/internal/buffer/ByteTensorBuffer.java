package org.tensorflow.internal.buffer;

import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.internal.c_api.global.tensorflow.TF_TensorData;

import org.bytedeco.mkldnn.memory;
import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.ByteRawDataBuffer;

public class ByteTensorBuffer extends ByteRawDataBuffer {

  public static ByteDataBuffer map(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long size = TF_TensorByteSize(nativeTensor);
    return new ByteTensorBuffer(address, size);
  }

  ByteTensorBuffer(long address, long size) {
    super(UnsafeProvider.UNSAFE, address, size);
  }
}
