package org.tensorflow.nio.buffer.impl.unsafe;

import org.tensorflow.nio.buffer.ShortDataBuffer;

public class ShortUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Short, ShortDataBuffer>
    implements ShortDataBuffer {

  public static ShortDataBuffer allocate(long size) {
    return new ShortUnsafeDataBuffer(new short[(int)size], false);
  }

  @Override
  public short getShort(long index) {
    return unsafe.getShort(object, align(index));
  }

  @Override
  public ShortDataBuffer setShort(short value, long index) {
    unsafe.putShort(object, align(index), value);
    return this;
  }

  @Override
  public ShortDataBuffer read(short[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public ShortDataBuffer write(short[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected ShortUnsafeDataBuffer(short[] data, boolean readOnly) {
    this(data, SHORT_ARRAYS.baseOffset, data.length * SHORT_ARRAYS.indexScale, readOnly);
  }

  protected ShortUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected ShortDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new ShortUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return SHORT_ARRAYS;
  }

  private static final ArrayInfo SHORT_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(short[].class),
      unsafe.arrayIndexScale(short[].class)
  );
}
