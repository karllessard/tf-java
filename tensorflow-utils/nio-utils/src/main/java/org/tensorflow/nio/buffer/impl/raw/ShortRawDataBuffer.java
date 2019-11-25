package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.ShortDataBuffer;
import sun.misc.Unsafe;

public class ShortRawDataBuffer extends AbstractRawDataBuffer<Short, ShortDataBuffer>
    implements ShortDataBuffer {

  @Override
  public short getShort(long index) {
    return memory.getShort(index);
  }

  @Override
  public ShortDataBuffer setShort(short value, long index) {
    memory.setShort(value, index);
    return this;
  }

  @Override
  public ShortDataBuffer read(short[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst), dst.length);
    return this;
  }

  @Override
  public ShortDataBuffer read(short[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst).offset(offset), length);
    return this;
  }

  @Override
  public ShortDataBuffer write(short[] src) {
    UnsafeMemoryHandle.of(memory.unsafe, src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public ShortDataBuffer write(short[] src, int offset, int length) {
    UnsafeMemoryHandle.of(memory.unsafe, src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected ShortRawDataBuffer(Unsafe unsafe, short[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected ShortRawDataBuffer(Unsafe unsafe, long address, long size) {
    this(UnsafeMemoryHandle.of(unsafe, address, size, Short.BYTES));
  }

  protected ShortRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected ShortDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new ShortRawDataBuffer(memory);
  }
}
