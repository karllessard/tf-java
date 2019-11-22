package org.tensorflow.nio.buffer.impl.unsafe;

import java.lang.reflect.Field;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import sun.misc.Unsafe;

abstract class AbstractUnsafeDataBuffer<T, B extends DataBuffer<T>> extends AbstractDataBuffer<T> {

  /*
   * The maximum size for a buffer of this type, i.e. the maximum number of bytes it can store.
   * <p>
   * As the maximum size may vary depending on the JVM implementation and on the platform, this
   * property returns a value that is safe for most of them.
   */
  public static long MAX_SIZE = Integer.MAX_VALUE - 10;

  public long size() {
    return length / arrayInfo().indexScale;
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public Stream<T> stream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  @SuppressWarnings("unchecked")
  public B copyTo(DataBuffer<T> dst, long size) {
    if (dst instanceof AbstractUnsafeDataBuffer) {
      AbstractUnsafeDataBuffer unsafeDst = (AbstractUnsafeDataBuffer)dst;
      unsafe.copyMemory(object, offset, unsafeDst.object, unsafeDst.offset, scale(size));
    } else {
      slowCopyTo(dst, size);
    }
    return (B)this;
  }

  @Override
  public B offset(long index) {
    return instantiate(object, align(index), length - scale(index), isReadOnly());
  }

  @Override
  public B narrow(long size) {
    return instantiate(object, offset, scale(size), isReadOnly());
  }

  protected static class ArrayInfo {

    protected ArrayInfo(int baseOffset, int indexScale) {
      this.baseOffset = baseOffset;
      this.indexScale = indexScale;
    }
    final int baseOffset;
    final int indexScale;
  }

  protected abstract B instantiate(Object object, long baseOffset, long length, boolean readOnly);

  // Important: Keep this package-private, do not expose publicly!
  static final Unsafe unsafe;

  static {
    try {
      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafe.setAccessible(true);
      unsafe = (Unsafe) theUnsafe.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  final Object object;
  final long offset;
  final long length;

  AbstractUnsafeDataBuffer(Object object, long offset, long length, boolean readOnly) {
    this.object = object;
    this.offset = offset;
    this.length = length;
    this.readOnly = readOnly;
  }

  abstract ArrayInfo arrayInfo();

  void read(Object dst, int offset, int length) {
    long effectiveLength = Math.min(scale(length), this.length);
    unsafe.copyMemory(object, this.offset, dst, alignToBase(offset), effectiveLength);
  }

  void write(Object src, int offset, int length) {
    unsafe.copyMemory(src, alignToBase(offset), object, this.offset, scale(length));
  }

  long scale(long value) {
    return value * arrayInfo().indexScale;
  }

  long align(long index) {
    return offset + scale(index);
  }

  private long alignToBase(long index) {
    return arrayInfo().baseOffset + scale(index);
  }

  private final boolean readOnly;
}
