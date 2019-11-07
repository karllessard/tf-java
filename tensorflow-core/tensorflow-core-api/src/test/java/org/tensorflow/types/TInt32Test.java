package org.tensorflow.types;

import org.tensorflow.Tensor;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Constant;

public class TInt32Test extends NumericTypesTestBase<TInt32, Integer> {

  @Override
  Tensor<TInt32> allocateTensor(Shape shape) {
    return TInt32.tensor(shape);
  }

  @Override
  DataBuffer<Integer> allocateBuffer(long capacity) {
    return DataBuffers.ofInts(capacity);
  }

  @Override
  Integer valueOf(int value) {
    return value;
  }

  @Override
  Constant<TInt32> constantOf(Ops tf, int value) {
    return tf.constant(value);
  }
}
