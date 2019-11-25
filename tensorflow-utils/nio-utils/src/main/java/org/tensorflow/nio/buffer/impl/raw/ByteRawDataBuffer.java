package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import sun.misc.Unsafe;

public class ByteRawDataBuffer extends AbstractRawDataBuffer<Byte, ByteDataBuffer>
    implements ByteDataBuffer {

  @Override
  public byte getByte(long index) {
    return memory.getByte(index);
  }

  @Override
  public ByteDataBuffer setByte(byte value, long index) {
    memory.setByte(value, index);
    return this;
  }

  @Override
  public ByteDataBuffer read(byte[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst), dst.length);
    return this;
  }

  @Override
  public ByteDataBuffer read(byte[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst).offset(offset), length);
    return this;
  }

  @Override
  public ByteDataBuffer write(byte[] src) {
    UnsafeMemoryHandle.of(memory.unsafe, src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public ByteDataBuffer write(byte[] src, int offset, int length) {
    UnsafeMemoryHandle.of(memory.unsafe, src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected ByteRawDataBuffer(Unsafe unsafe, byte[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected ByteRawDataBuffer(Unsafe unsafe, long address, long size) {
    this(UnsafeMemoryHandle.of(unsafe, address, size, Byte.BYTES));
  }

  protected ByteRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected ByteDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new ByteRawDataBuffer(memory);
  }
}
