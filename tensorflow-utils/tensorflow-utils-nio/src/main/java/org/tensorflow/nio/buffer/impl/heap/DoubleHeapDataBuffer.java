package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.DoubleUnsafeDataBuffer;

public class DoubleHeapDataBuffer extends DoubleUnsafeDataBuffer {

  public static DoubleDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new DoubleHeapDataBuffer(new double[(int)size], false);
  }

  @Override
  public double getDouble(long index) {
    Validator.getArgs(this, index);
    return super.getDouble(index);
  }

  @Override
  public DoubleDataBuffer setDouble(double value, long index) {
    Validator.setArgs(this, index);
    return super.setDouble(value, index);
  }

  @Override
  public DoubleDataBuffer read(double[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public DoubleDataBuffer write(double[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public DoubleDataBuffer copyTo(DataBuffer<Double> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public DoubleDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public DoubleDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected DoubleDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new DoubleHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private DoubleHeapDataBuffer(double[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private DoubleHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
