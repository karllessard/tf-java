package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.IntDataBuffer;

public class IntRawDataBuffer extends AbstractRawDataBuffer<Integer, IntDataBuffer>
    implements IntDataBuffer {

  @Override
  public int getInt(long index) {
    return memory.getInt(index);
  }

  @Override
  public IntDataBuffer setInt(int value, long index) {
    memory.setInt(value, index);
    return this;
  }

  @Override
  public IntDataBuffer read(int[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(dst), dst.length);
    return this;
  }

  @Override
  public IntDataBuffer read(int[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(dst).offset(offset), length);
    return this;
  }

  @Override
  public IntDataBuffer write(int[] src) {
    UnsafeMemoryHandle.of(src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public IntDataBuffer write(int[] src, int offset, int length) {
    UnsafeMemoryHandle.of(src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected IntRawDataBuffer(int[] data) {
    this(UnsafeMemoryHandle.of(data));
  }

  protected IntRawDataBuffer(long address, long size) {
    this(UnsafeMemoryHandle.of(address, size, Integer.BYTES));
  }

  protected IntRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected IntDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new IntRawDataBuffer(memory);
  }
}
