package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;

abstract class AbstractRawDataBuffer<T, B extends DataBuffer<T>> extends AbstractDataBuffer<T> {

  /*
   * The maximum size for a buffer of this type, i.e. the maximum number of bytes it can store.
   * <p>
   * As the maximum size may vary depending on the JVM implementation and on the platform, this
   * property returns a value that is safe for most of them.
   */
  public static long MAX_SIZE = Integer.MAX_VALUE - 10;

  public long size() {
    return memory.size();
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  @SuppressWarnings("unchecked")
  public B copyTo(DataBuffer<T> dst, long size) {
    if (dst instanceof AbstractRawDataBuffer) {
      AbstractRawDataBuffer unsafeDst = (AbstractRawDataBuffer)dst;
      memory.copyTo(unsafeDst.memory, size);
    } else {
      slowCopyTo(dst, size);
    }
    return (B)this;
  }

  @Override
  public B offset(long index) {
    return instantiate(memory.offset(index));
  }

  @Override
  public B narrow(long size) {
    return instantiate(memory.narrow(size));
  }

  protected abstract B instantiate(UnsafeMemoryHandle region);

  final UnsafeMemoryHandle memory;

  AbstractRawDataBuffer(UnsafeMemoryHandle memory) {
    this.memory = memory;
  }
}
