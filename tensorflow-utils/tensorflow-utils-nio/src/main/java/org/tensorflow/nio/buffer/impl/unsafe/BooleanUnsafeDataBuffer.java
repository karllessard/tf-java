package org.tensorflow.nio.buffer.impl.unsafe;

import org.tensorflow.nio.buffer.BooleanDataBuffer;

public class BooleanUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Boolean, BooleanDataBuffer>
    implements BooleanDataBuffer {

  public static BooleanDataBuffer allocate(long size) {
    return new BooleanUnsafeDataBuffer(new boolean[(int)size], false);
  }

  @Override
  public boolean getBoolean(long index) {
    return unsafe.getBoolean(object, align(index));
  }

  @Override
  public BooleanDataBuffer setBoolean(boolean value, long index) {
    unsafe.putBoolean(object, align(index), value);
    return this;
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected BooleanUnsafeDataBuffer(boolean[] data, boolean readOnly) {
    this(data, BOOLEAN_ARRAYS.baseOffset, data.length * BOOLEAN_ARRAYS.indexScale, readOnly);
  }

  protected BooleanUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected BooleanDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new BooleanUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return BOOLEAN_ARRAYS;
  }

  private static final ArrayInfo BOOLEAN_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(boolean[].class),
      unsafe.arrayIndexScale(boolean[].class)
  );
}
