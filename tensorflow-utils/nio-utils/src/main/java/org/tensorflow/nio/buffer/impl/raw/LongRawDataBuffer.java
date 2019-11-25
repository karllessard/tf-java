package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.LongDataBuffer;
import sun.misc.Unsafe;

public class LongRawDataBuffer extends AbstractRawDataBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

  @Override
  public long getLong(long index) {
    return memory.getLong(index);
  }

  @Override
  public LongDataBuffer setLong(long value, long index) {
    memory.setLong(value, index);
    return this;
  }

  @Override
  public LongDataBuffer read(long[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst), dst.length);
    return this;
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst).offset(offset), length);
    return this;
  }

  @Override
  public LongDataBuffer write(long[] src) {
    UnsafeMemoryHandle.of(memory.unsafe, src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public LongDataBuffer write(long[] src, int offset, int length) {
    UnsafeMemoryHandle.of(memory.unsafe, src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected LongRawDataBuffer(Unsafe unsafe, long[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected LongRawDataBuffer(Unsafe unsafe, long address, long length) {
    this(UnsafeMemoryHandle.of(unsafe, address, length, Long.BYTES));
  }

  protected LongRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected LongDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new LongRawDataBuffer(memory);
  }
}
