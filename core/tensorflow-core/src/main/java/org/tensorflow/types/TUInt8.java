package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.nd.ByteNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.ByteDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TUInt8 extends ByteNdArray, TNumber {

  DataType<TUInt8> DTYPE = new DataType<>(4, 1, (shape, bufs) -> {
    class Impl extends ByteDenseNdArray implements TUInt8 {
      Impl(ByteDataBuffer buffer, Shape shape) {
        super(buffer, shape);
      }
    }
    return new Impl(DataBuffers.wrap(bufs), shape);
  });
}
