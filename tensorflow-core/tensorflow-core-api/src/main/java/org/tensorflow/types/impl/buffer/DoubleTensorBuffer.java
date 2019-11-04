package org.tensorflow.types.impl.buffer;

import java.util.stream.DoubleStream;
import org.tensorflow.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class DoubleTensorBuffer extends AbstractUnsafeBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

  public static DoubleDataBuffer map(TF_Tensor nativeTensor) {
    return new DoubleTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public DoubleStream doubleStream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public double getDouble() {
    Validator.get(this);
    return unsafe.getDouble(nextAddress());
  }

  @Override
  public double getDouble(long index) {
    Validator.getArgs(this, index);
    return unsafe.getDouble(addressAt(index));
  }

  @Override
  public DoubleDataBuffer get(double[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, remaining());
    unsafe.copyMemory(null, currentAddress(), dst, arrayOffset(offset), effectiveLength);
    movePosition(effectiveLength);
    return this;
  }

  @Override
  public DoubleDataBuffer putDouble(double value) {
    Validator.put(this);
    unsafe.putDouble(nextAddress(), value);
    return this;
  }

  @Override
  public DoubleDataBuffer putDouble(long index, double value) {
    Validator.putArgs(this, index);
    unsafe.putDouble(addressAt(index), value);
    return this;
  }

  @Override
  public DoubleDataBuffer put(double[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, currentAddress(), length);
    movePosition(length);
    return this;
  }

  @Override
  public DoubleDataBuffer duplicate() {
    return new DoubleTensorBuffer(memory, isReadOnly(), position(), limit());
  }

  DoubleTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(DOUBLE_INFO, memory, readOnly);
  }

  private DoubleTensorBuffer(TensorMemory memory, boolean readOnly, long position, long limit) {
    super(DOUBLE_INFO, memory, readOnly, position, limit);
  }

  private static final TypeInfo DOUBLE_INFO = new TypeInfo(
    Double.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
