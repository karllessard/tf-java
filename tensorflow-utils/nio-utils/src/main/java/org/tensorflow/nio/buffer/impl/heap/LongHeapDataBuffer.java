package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.raw.LongRawDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.UnsafeMemoryHandle;

public class LongHeapDataBuffer extends LongRawDataBuffer {

  public static LongDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new LongHeapDataBuffer(new long[(int)size], false);
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
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
  public LongDataBuffer read(long[] dst) {
    Validator.readArgs(this, dst.length, 0, dst.length);
    return super.read(dst);
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public LongDataBuffer write(long[] src) {
    Validator.writeArgs(this, src.length, 0, src.length);
    return super.write(src);
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
  protected LongDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new LongHeapDataBuffer(memory, readOnly);
  }

  private LongHeapDataBuffer(long[] data, boolean readOnly) {
    super(data);
    this.readOnly = readOnly;
  }

  private LongHeapDataBuffer(UnsafeMemoryHandle memory, boolean readOnly) {
    super(memory);
    this.readOnly = readOnly;
  }

  private final boolean readOnly;
}
