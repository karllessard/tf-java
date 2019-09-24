package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.nio.buffer.impl.single.ByteJdkDataBuffer;
import org.tensorflow.nio.nd.ByteNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.ByteDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TUInt8 extends ByteNdArray, TNumber {

  DataType<TUInt8> DTYPE = new DataType<>(4, 1, TUInt8Impl::new);

  static Tensor<TUInt8> scalar(byte value) {
    Tensor<TUInt8> t = tensorOfShape(Shape.scalar());
    t.data().set(value);
    return t;
  }

  static Tensor<TUInt8> vector(byte... values) {
    Tensor<TUInt8> t = tensorOfShape(Shape.make(values.length));
    t.data().write(values);
    return t;
  }

  static Tensor<TUInt8> tensorOfShape(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }
}

class TUInt8Impl extends ByteDenseNdArray implements TUInt8 {

  TUInt8Impl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toByteDataBuffer(tensorBuffers, ByteJdkDataBuffer::wrap), shape);
  }
}
