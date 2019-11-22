package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.IntUnsafeDataBuffer;

public class IntHeapDataBuffer extends IntUnsafeDataBuffer {

  public static IntDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new IntHeapDataBuffer(new int[(int)size], false);
  }

  @Override
  public int getInt(long index) {
    Validator.getArgs(this, index);
    return super.getInt(index);
  }

  @Override
  public IntDataBuffer setInt(int value, long index) {
    Validator.setArgs(this, index);
    return super.setInt(value, index);
  }

  @Override
  public IntDataBuffer read(int[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public IntDataBuffer write(int[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public IntDataBuffer copyTo(DataBuffer<Integer> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public IntDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public IntDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected IntDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new IntHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private IntHeapDataBuffer(int[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private IntHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
