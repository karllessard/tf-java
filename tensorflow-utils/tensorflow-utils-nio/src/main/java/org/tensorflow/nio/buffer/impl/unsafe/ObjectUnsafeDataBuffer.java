package org.tensorflow.nio.buffer.impl.unsafe;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.tensorflow.nio.buffer.DataBuffer;

public class ObjectUnsafeDataBuffer<T> extends AbstractUnsafeDataBuffer<T, DataBuffer<T>>
    implements DataBuffer<T> {

  public static <T> DataBuffer<T> allocate(Class<T> type, long size) {
    @SuppressWarnings("unchecked")
    T[] data = (T[])Array.newInstance(type, (int)size);
    return new ObjectUnsafeDataBuffer<>(data, false);
  }

  @Override
  public T get(long index) {
    return (T)unsafe.getObject(object, align(index));
  }

  @Override
  public DataBuffer<T> set(T value, long index) {
    unsafe.putObject(object, align(index), value);
    return this;
  }

  @Override
  public DataBuffer<T> copyTo(DataBuffer<T> dst, long size) {
    if (dst instanceof ObjectUnsafeDataBuffer) {
      ObjectUnsafeDataBuffer unsafeDst = (ObjectUnsafeDataBuffer)dst;
      System.arraycopy(object, 0, unsafeDst.object, 0, (int)size);
    } else {
      slowCopyTo(dst, size);
    }
    return this;
  }

  protected ObjectUnsafeDataBuffer(T[] data, boolean readOnly) {
    this(data, OBJECT_ARRAYS.baseOffset, data.length * OBJECT_ARRAYS.indexScale, readOnly);
  }

  protected ObjectUnsafeDataBuffer(Object object, long baseOffset, long length, boolean readOnly) {
    super(object, baseOffset, length, readOnly);
  }

  @Override
  protected DataBuffer<T> instantiate(Object object, long baseOffset, long length, boolean readOnly) {
    return new ObjectUnsafeDataBuffer<>(object, baseOffset, length, readOnly);
  }

  @Override
  protected ArrayInfo arrayInfo() {
    return OBJECT_ARRAYS;
  }

  private static final ArrayInfo OBJECT_ARRAYS = new ArrayInfo(
      unsafe.arrayBaseOffset(Object[].class),
      unsafe.arrayIndexScale(Object[].class)
  );
}
