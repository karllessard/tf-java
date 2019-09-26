package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.single.IntJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.single.LongJdkDataBuffer;
import org.tensorflow.nio.nd.LongNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.LongDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TInt64 extends LongNdArray, TNumber {

  DataType<TInt64> DTYPE = new DataType<>(9, 8, "INT64", TInt64Impl::mapTensor);

  static Tensor<TInt64> scalar(long value) {
    Tensor<TInt64> t = tensorOfShape(Shape.scalar());
    t.data().set(value);
    return t;
  }

  static Tensor<TInt64> vector(long... values) {
    Tensor<TInt64> t = tensorOfShape(Shape.make(values.length));
    t.data().write(values);
    return t;
  }

  static Tensor<TInt64> tensorOfShape(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }
}

class TInt64Impl extends LongDenseNdArray implements TInt64 {

  static TInt64 mapTensor(ByteBuffer[] tensorBuffers, Shape shape) {
    LongDataBuffer buffer = BufferUtils.toLongDataBuffer(tensorBuffers, b ->
        LongJdkDataBuffer.wrap(b.asLongBuffer())
    );
    return new TInt64Impl(buffer, shape);
  }

  private TInt64Impl(LongDataBuffer buffer, Shape shape) {
    super(buffer, shape);
  }
}
