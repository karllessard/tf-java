package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.BooleanDataBuffer;

public class BooleanRawDataBuffer extends AbstractRawDataBuffer<Boolean, BooleanDataBuffer>
    implements BooleanDataBuffer {

  @Override
  public boolean getBoolean(long index) {
    return memory.getBoolean(index);
  }

  @Override
  public BooleanDataBuffer setBoolean(boolean value, long index) {
    memory.setBoolean(value, index);
    return this;
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(dst), dst.length);
    return this;
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(dst).offset(offset), length);
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src) {
    UnsafeMemoryHandle.of(src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src, int offset, int length) {
    UnsafeMemoryHandle.of(src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected BooleanRawDataBuffer(boolean[] data) {
    this(UnsafeMemoryHandle.of(data));
  }

  protected BooleanRawDataBuffer(long address, long size) {
    this(UnsafeMemoryHandle.of(address, size, BOOLEAN_BYTES));
  }

  protected BooleanRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected BooleanDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new BooleanRawDataBuffer(memory);
  }

  private static final int BOOLEAN_BYTES = 1;
}
