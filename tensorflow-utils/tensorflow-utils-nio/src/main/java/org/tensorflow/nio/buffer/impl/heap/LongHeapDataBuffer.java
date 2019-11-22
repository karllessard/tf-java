package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.LongUnsafeDataBuffer;

public class LongHeapDataBuffer extends LongUnsafeDataBuffer {

  public static LongDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new LongHeapDataBuffer(new long[(int)size], false);
  }

  @Override
  public long getLong(long index) {
    Validator.getArgs(this, index);
    return super.getLong(index);
  }

  @Override
  public LongDataBuffer setLong(long value, long index) {
    Validator.setArgs(this, index);
    return super.setLong(value, index);
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public LongDataBuffer write(long[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public LongDataBuffer copyTo(DataBuffer<Long> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public LongDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public LongDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected LongDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new LongHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private LongHeapDataBuffer(long[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private LongHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
