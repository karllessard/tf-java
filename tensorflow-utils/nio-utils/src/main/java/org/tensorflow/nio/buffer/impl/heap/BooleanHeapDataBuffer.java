package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.raw.BooleanRawDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.UnsafeMemoryHandle;

public class BooleanHeapDataBuffer extends BooleanRawDataBuffer {

  public static BooleanDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new BooleanHeapDataBuffer(new boolean[(int)size], false);
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public boolean getBoolean(long index) {
    Validator.getArgs(this, index);
    return super.getBoolean(index);
  }

  @Override
  public BooleanDataBuffer setBoolean(boolean value, long index) {
    Validator.setArgs(this, index);
    return super.setBoolean(value, index);
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst) {
    Validator.readArgs(this, dst.length, 0, dst.length);
    return super.read(dst);
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public BooleanDataBuffer write(boolean[] src) {
    Validator.writeArgs(this, src.length, 0, src.length);
    return super.write(src);
  }

  @Override
  public BooleanDataBuffer write(boolean[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public BooleanDataBuffer copyTo(DataBuffer<Boolean> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public BooleanDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public BooleanDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected BooleanDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new BooleanHeapDataBuffer(memory, readOnly);
  }

  private BooleanHeapDataBuffer(boolean[] array, boolean readOnly) {
    super(UnsafeProvider.UNSAFE, array);
    this.readOnly = readOnly;
  }

  private BooleanHeapDataBuffer(UnsafeMemoryHandle memory, boolean readOnly) {
    super(memory);
    this.readOnly = readOnly;
  }

  private final boolean readOnly;
}
