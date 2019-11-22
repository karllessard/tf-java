package org.tensorflow.nio.buffer.impl.unsafe;

import java.util.stream.IntStream;
import org.tensorflow.nio.buffer.IntDataBuffer;

public class IntUnsafeDataBuffer extends AbstractUnsafeDataBuffer<Integer, IntDataBuffer>
    implements IntDataBuffer {

  public static IntDataBuffer allocate(long size) {
    return new IntUnsafeDataBuffer(new int[(int)size], false);
  }

  @Override
  public IntStream intStream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public int getInt(long index) {
    return unsafe.getInt(object, align(index));
  }

  @Override
  public IntDataBuffer setInt(int value, long index) {
    unsafe.putInt(object, align(index), value);
    return this;
  }

  @Override
  public IntDataBuffer read(int[] dst, int offset, int length) {
    super.read(dst, offset, length);
    return this;
  }

  @Override
  public IntDataBuffer write(int[] src, int offset, int length) {
    super.write(src, offset, length);
    return this;
  }

  protected IntUnsafeDataBuffer(int[] data, boolean readOnly) {
    this(data, INT_ARRAYS.baseOffset, data.length * INT_ARRAYS.indexScale, readOnly);
  }

  protected IntUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected IntDataBuffer instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new IntUnsafeDataBuffer(object, baseOffset, length, readOnly);
  }

  @Override
  ArrayInfo arrayInfo() {
    return INT_ARRAYS;
  }

  private static final ArrayInfo INT_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(int[].class),
      unsafe.arrayIndexScale(int[].class)
  );
}
