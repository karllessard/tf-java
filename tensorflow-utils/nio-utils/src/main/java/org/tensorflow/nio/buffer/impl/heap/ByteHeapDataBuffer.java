package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.raw.ByteRawDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.UnsafeMemoryHandle;

public class ByteHeapDataBuffer extends ByteRawDataBuffer {

  public static ByteDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new ByteHeapDataBuffer(new byte[(int)size], false);
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public byte getByte(long index) {
    Validator.getArgs(this, index);
    return super.getByte(index);
  }

  @Override
  public ByteDataBuffer setByte(byte value, long index) {
    Validator.setArgs(this, index);
    return super.setByte(value, index);
  }

  @Override
  public ByteDataBuffer read(byte[] dst) {
    Validator.readArgs(this, dst.length, 0, dst.length);
    return super.read(dst);
  }

  @Override
  public ByteDataBuffer read(byte[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public ByteDataBuffer write(byte[] src) {
    Validator.writeArgs(this, src.length, 0, src.length);
    return super.write(src);
  }

  @Override
  public ByteDataBuffer write(byte[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public ByteDataBuffer copyTo(DataBuffer<Byte> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public ByteDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public ByteDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected ByteDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new ByteHeapDataBuffer(memory, readOnly);
  }

  private ByteHeapDataBuffer(byte[] data, boolean readOnly) {
    super(UnsafeProvider.UNSAFE, data);
    this.readOnly = readOnly;
  }

  private ByteHeapDataBuffer(UnsafeMemoryHandle memory, boolean readOnly) {
    super(memory);
    this.readOnly = readOnly;
  }

  private final boolean readOnly;
}
