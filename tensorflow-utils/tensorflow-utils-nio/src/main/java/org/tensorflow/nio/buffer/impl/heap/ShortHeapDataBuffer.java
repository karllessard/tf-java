package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.ShortUnsafeDataBuffer;

public class ShortHeapDataBuffer extends ShortUnsafeDataBuffer {

  public static ShortDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new ShortHeapDataBuffer(new short[(int)size], false);
  }

  @Override
  public short getShort(long index) {
    Validator.getArgs(this, index);
    return super.getShort(index);
  }

  @Override
  public ShortDataBuffer setShort(short value, long index) {
    Validator.setArgs(this, index);
    return super.setShort(value, index);
  }

  @Override
  public ShortDataBuffer read(short[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public ShortDataBuffer write(short[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public ShortDataBuffer copyTo(DataBuffer<Short> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public ShortDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public ShortDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected ShortDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new ShortHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private ShortHeapDataBuffer(short[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private ShortHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
