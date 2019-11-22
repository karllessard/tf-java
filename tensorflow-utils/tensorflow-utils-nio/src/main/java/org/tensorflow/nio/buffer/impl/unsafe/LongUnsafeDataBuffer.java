package org.tensorflow.nio.buffer.impl.unsafe;

import java.util.stream.LongStream;
import org.tensorflow.nio.buffer.LongDataBuffer;

public class LongUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

  public static LongDataBuffer allocate(long size) {
    return new LongUnsafeDataBuffer(new long[(int)size], false);
  }

  @Override
  public LongStream longStream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public long getLong(long index) {
    return unsafe.getLong(object, align(index));
  }

  @Override
  public LongDataBuffer setLong(long value, long index) {
    unsafe.putLong(object, align(index), value);
    return this;
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public LongDataBuffer write(long[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected LongUnsafeDataBuffer(long[] data, boolean readOnly) {
    this(data, LONG_ARRAYS.baseOffset, data.length * LONG_ARRAYS.indexScale, readOnly);
  }

  protected LongUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected LongDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new LongUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return LONG_ARRAYS;
  }

  private static final ArrayInfo LONG_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(long[].class),
      unsafe.arrayIndexScale(long[].class)
  );
}
