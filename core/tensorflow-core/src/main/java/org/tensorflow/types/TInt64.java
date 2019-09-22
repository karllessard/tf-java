package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.nd.LongNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.LongDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TInt64 extends LongNdArray, TNumber {
  DataType<TInt64> DTYPE = new DataType<>(9, 8, TInt64Impl::new);
}

class TInt64Impl extends LongDenseNdArray implements TInt64 {
  TInt64Impl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toLongDataBuffer(tensorBuffers), shape);
  }
}
