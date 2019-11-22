package org.tensorflow.nio.buffer.impl.unsafe;

import org.tensorflow.nio.buffer.ByteDataBuffer;

public class ByteUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Byte, ByteDataBuffer>
    implements ByteDataBuffer {

  public static ByteDataBuffer allocate(long size) {
    return new ByteUnsafeDataBuffer(new byte[(int)size], false);
  }

  @Override
  public byte getByte(long index) {
    return unsafe.getByte(object, align(index));
  }

  @Override
  public ByteDataBuffer setByte(byte value, long index) {
    unsafe.putByte(object, align(index), value);
    return this;
  }

  @Override
  public ByteDataBuffer read(byte[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public ByteDataBuffer write(byte[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected ByteUnsafeDataBuffer(byte[] data, boolean readOnly) {
    this(data, BYTE_ARRAYS.baseOffset, data.length * BYTE_ARRAYS.indexScale, readOnly);
  }

  protected ByteUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected ByteDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new ByteUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return BYTE_ARRAYS;
  }

  private static final ArrayInfo BYTE_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(byte[].class),
      unsafe.arrayIndexScale(byte[].class)
  );
}
