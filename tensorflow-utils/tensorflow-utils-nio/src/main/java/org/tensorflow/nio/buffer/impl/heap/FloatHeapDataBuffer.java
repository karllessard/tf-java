package org.tensorflow.nio.buffer.impl.heap;

import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.unsafe.FloatUnsafeDataBuffer;

public class FloatHeapDataBuffer extends FloatUnsafeDataBuffer {

  public static FloatDataBuffer allocate(long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    return new FloatHeapDataBuffer(new float[(int)size], false);
  }

  @Override
  public float getFloat(long index) {
    Validator.getArgs(this, index);
    return super.getFloat(index);
  }

  @Override
  public FloatDataBuffer setFloat(float value, long index) {
    Validator.setArgs(this, index);
    return super.setFloat(value, index);
  }

  @Override
  public FloatDataBuffer read(float[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    return super.read(dst, offset, length);
  }

  @Override
  public FloatDataBuffer write(float[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    return super.write(src, offset, length);
  }

  @Override
  public FloatDataBuffer copyTo(DataBuffer<Float> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public FloatDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public FloatDataBuffer narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected FloatDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new FloatHeapDataBuffer(object, baseOffset, length, readOnly);
  }

  private FloatHeapDataBuffer(float[] data, boolean readOnly) {
    super(data, readOnly);
  }

  private FloatHeapDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }
}
