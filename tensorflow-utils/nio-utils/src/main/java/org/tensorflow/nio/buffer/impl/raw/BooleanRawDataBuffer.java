package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.BooleanDataBuffer;
import sun.misc.Unsafe;

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
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst), dst.length);
    return this;
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst).offset(offset), length);
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src) {
    UnsafeMemoryHandle.of(memory.unsafe, src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src, int offset, int length) {
    UnsafeMemoryHandle.of(memory.unsafe, src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected BooleanRawDataBuffer(Unsafe unsafe, boolean[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected BooleanRawDataBuffer(Unsafe unsafe, long address, long size) {
    this(UnsafeMemoryHandle.of(unsafe, address, size, BOOLEAN_BYTES));
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
