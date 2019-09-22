package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.nd.IntNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.IntDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TInt32 extends IntNdArray, TNumber {
  DataType<TInt32> DTYPE = new DataType<>(3, 4, TInt32Impl::new);
}

class TInt32Impl extends IntDenseNdArray implements TInt32 {
  TInt32Impl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toIntDataBuffer(tensorBuffers), shape);
  }
}

