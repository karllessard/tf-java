package org.tensorflow.impl.buffer;

import static org.tensorflow.impl.c_api.global.tensorflow.TF_TensorByteSize;
import static org.tensorflow.impl.c_api.global.tensorflow.TF_TensorData;

import org.tensorflow.impl.c_api.TF_Tensor;

class TensorMemory {

  static TensorMemory of(TF_Tensor nativeTensor) {
    long address = TF_TensorData(nativeTensor).address();
    long length = TF_TensorByteSize(nativeTensor);
    return new TensorMemory(address, length);
  }

  TensorMemory segment(long startOffset, long endOffset) {
    return new TensorMemory(address + startOffset, endOffset - startOffset);
  }

  final long address;
  final long length;

  private TensorMemory(long address, long length) {
    this.address = address;
    this.length = length;
  }
}
