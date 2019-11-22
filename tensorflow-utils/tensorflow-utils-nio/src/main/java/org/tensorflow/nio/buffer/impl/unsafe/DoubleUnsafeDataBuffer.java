package org.tensorflow.nio.buffer.impl.unsafe;

import java.util.stream.DoubleStream;
import org.tensorflow.nio.buffer.DoubleDataBuffer;

public class DoubleUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

  public static DoubleDataBuffer allocate(long size) {
    return new DoubleUnsafeDataBuffer(new double[(int)size], false);
  }

  @Override
  public DoubleStream doubleStream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public double getDouble(long index) {
    return unsafe.getDouble(object, align(index));
  }

  @Override
  public DoubleDataBuffer setDouble(double value, long index) {
    unsafe.putDouble(object, align(index), value);
    return this;
  }

  @Override
  public DoubleDataBuffer read(double[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public DoubleDataBuffer write(double[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected DoubleUnsafeDataBuffer(double[] data, boolean readOnly) {
    this(data, DOUBLE_ARRAYS.baseOffset, data.length * DOUBLE_ARRAYS.indexScale, readOnly);
  }

  protected DoubleUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected DoubleDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new DoubleUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return DOUBLE_ARRAYS;
  }

  private static final ArrayInfo DOUBLE_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(double[].class),
      unsafe.arrayIndexScale(double[].class)
  );
}
