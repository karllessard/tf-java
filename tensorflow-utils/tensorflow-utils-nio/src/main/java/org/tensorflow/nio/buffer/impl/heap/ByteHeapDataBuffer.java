package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.ByteUnsafeDataBuffer;

public class ByteHeapDataBuffer extends ByteUnsafeDataBuffer {

  public static ByteDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new ByteHeapDataBuffer(new byte[(int)size], false);
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
  public ByteDataBuffer read(byte[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
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
  protected ByteDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new ByteHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private ByteHeapDataBuffer(byte[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private ByteHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
