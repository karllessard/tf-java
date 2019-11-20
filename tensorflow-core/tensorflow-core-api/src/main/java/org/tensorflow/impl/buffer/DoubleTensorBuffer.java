package org.tensorflow.impl.buffer;

import java.util.stream.DoubleStream;
import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class DoubleTensorBuffer extends AbstractUnsafeBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

  public static DoubleDataBuffer map(TF_Tensor nativeTensor) {
    return new DoubleTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public DoubleStream doubleStream() {
    return null; // TODO!
  }

  @Override
  public double getDouble(long index) {
    Validator.getArgs(this, index);
    return unsafe.getDouble(addressAt(index));
  }

  @Override
  public DoubleDataBuffer setDouble(double value, long index) {
    Validator.putArgs(this, index);
    unsafe.putDouble(addressAt(index), value);
    return this;
  }

  @Override
  public DoubleDataBuffer read(double[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, size());
    unsafe.copyMemory(null, 0, dst, arrayOffset(offset), effectiveLength);
    return this;
  }

  @Override
  public DoubleDataBuffer write(double[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, 0, length);
    return this;
  }

  @Override
  public DoubleDataBuffer offset(long index) {
    return new DoubleTensorBuffer(memory.segment(index, size() - index), isReadOnly());
  }

  @Override
  public DoubleDataBuffer narrow(long size) {
    return new DoubleTensorBuffer(memory.segment(0, size), isReadOnly());
  }

  DoubleTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(TYPE_INFO, memory, readOnly);
  }

  private static final TypeInfo TYPE_INFO = new TypeInfo(
      Double.BYTES,
      unsafe.arrayBaseOffset(int[].class),
      unsafe.arrayIndexScale(int[].class)
  );
}
