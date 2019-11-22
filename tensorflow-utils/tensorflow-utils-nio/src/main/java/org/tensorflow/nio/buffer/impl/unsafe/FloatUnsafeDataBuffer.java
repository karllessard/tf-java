package org.tensorflow.nio.buffer.impl.unsafe;

import org.tensorflow.nio.buffer.FloatDataBuffer;

public class FloatUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

  public static FloatDataBuffer allocate(long size) {
    return new FloatUnsafeDataBuffer(new float[(int)size], false);
  }

  @Override
  public float getFloat(long index) {
    return unsafe.getFloat(object, align(index));
  }

  @Override
  public FloatDataBuffer setFloat(float value, long index) {
    unsafe.putFloat(object, align(index), value);
    return this;
  }

  @Override
  public FloatDataBuffer read(float[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected FloatUnsafeDataBuffer(float[] data, boolean readOnly) {
    this(data, FLOAT_ARRAYS.baseOffset, data.length * FLOAT_ARRAYS.indexScale, readOnly);
  }

  protected FloatUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected FloatDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new FloatUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return FLOAT_ARRAYS;
  }

  private static final ArrayInfo FLOAT_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(float[].class),
      unsafe.arrayIndexScale(float[].class)
  );
}
