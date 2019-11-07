package org.tensorflow.types;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;
import org.tensorflow.EagerSession;
import org.tensorflow.Tensor;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Constant;
import org.tensorflow.op.core.Fill;
import org.tensorflow.op.math.Sub;
import org.tensorflow.types.family.TNumber;

import static org.tensorflow.nio.StaticApi.*;

abstract class NumericTypesTestBase<T extends TNumber & NdArray<U>, U> {

  abstract Tensor<T> allocateTensor(Shape shape);

  abstract DataBuffer<U> allocateBuffer(long capacity);

  abstract U valueOf(int value);

  abstract Constant<T> constantOf(Ops tf, int value);

  @Test
  public void initializeTensorsWithZeros() {
    // Allocate a tensor of 32-bits integer of the shape (2, 3, 2)
    Tensor<T> tensor = allocateTensor(Shape.make(2, 3, 2));

    // Access tensor memory directly
    NdArray<U> tensorData = tensor.data();
    assertEquals(3, tensorData.rank());
    assertEquals(12, tensorData.size());

    try (EagerSession session = EagerSession.create()) {
      Ops tf = Ops.create(session);

      // Initialize tensor memory with zeros
      tensorData.write(allocateBuffer(tensorData.size()));
      tensorData.scalars().forEach(scalar ->
          assertEquals(valueOf(0), scalar.getValue())
      );
      Constant<T> x = tf.constant(tensor);  // take snapshot of `tensor` with all zeros

      // Initialize tensor memory with all ones
      Fill<T> ones = tf.fill(tf.constant(tensor.shape().asArray()), constantOf(tf, 1));
      ones.tensorData().copyTo(tensorData);
      tensorData.scalars().forEach(scalar ->
          assertEquals(valueOf(1), scalar.getValue())
      );
      Constant<T> y = tf.constant(tensor);  // take snapshot of `tensor` with all ones

      // Subtract y from x and validate the result
      Sub<T> sub = tf.math.sub(x, y);
      sub.tensorData().scalars().forEach(scalar ->
          assertEquals(valueOf(-1), scalar.getValue())
      );
    }
  }
}
