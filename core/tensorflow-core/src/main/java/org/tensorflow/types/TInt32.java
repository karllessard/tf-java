package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.nio.buffer.impl.single.IntJdkDataBuffer;
import org.tensorflow.nio.nd.IntNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.IntDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TInt32 extends IntNdArray, TNumber {

  DataType<TInt32> DTYPE = new DataType<>(3, 4, TInt32Impl::new);

  static Tensor<TInt32> scalar(int value) {
    Tensor<TInt32> t = tensorOfShape(Shape.scalar());
    t.data().set(value);
    return t;
  }

  static Tensor<TInt32> vector(int... values) {
    Tensor<TInt32> t = tensorOfShape(Shape.make(values.length));
    t.data().write(values);
    return t;
  }

  static Tensor<TInt32> tensorOfShape(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }
}

class TInt32Impl extends IntDenseNdArray implements TInt32 {

  TInt32Impl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toIntDataBuffer(tensorBuffers, b -> IntJdkDataBuffer.wrap(b.asIntBuffer())), shape);
  }
}

