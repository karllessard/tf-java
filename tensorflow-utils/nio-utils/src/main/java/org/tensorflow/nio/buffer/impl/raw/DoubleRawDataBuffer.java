package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.DoubleDataBuffer;

public class DoubleRawDataBuffer extends AbstractRawDataBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

  @Override
  public double getDouble(long index) {
    return memory.getDouble(index);
  }

  @Override
  public DoubleDataBuffer setDouble(double value, long index) {
    memory.setDouble(value, index);
    return this;
  }

  @Override
  public DoubleDataBuffer read(double[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(dst), dst.length);
    return this;
  }

  @Override
  public DoubleDataBuffer read(double[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(dst).offset(offset), length);
    return this;
  }

  @Override
  public DoubleDataBuffer write(double[] src) {
    UnsafeMemoryHandle.of(src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public DoubleDataBuffer write(double[] src, int offset, int length) {
    UnsafeMemoryHandle.of(src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected DoubleRawDataBuffer(double[] data) {
    this(UnsafeMemoryHandle.of(data));
  }

  protected DoubleRawDataBuffer(long address, long size) {
    this(UnsafeMemoryHandle.of(address, size, Double.BYTES));
  }

  protected DoubleRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected DoubleDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new DoubleRawDataBuffer(memory);
  }
}
