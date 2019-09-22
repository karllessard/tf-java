package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.nd.ByteNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.ByteDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TUInt8 extends ByteNdArray, TNumber {
  DataType<TUInt8> DTYPE = new DataType<>(4, 1, TUInt8Impl::new);
}

class TUInt8Impl extends ByteDenseNdArray implements TUInt8 {
  TUInt8Impl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toByteDataBuffer(tensorBuffers), shape);
  }
}
