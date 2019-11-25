package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.DataBuffer;
import sun.misc.Unsafe;

public class ObjectRawDataBuffer<T> extends AbstractRawDataBuffer<T, DataBuffer<T>>
    implements DataBuffer<T> {

  @Override
  public T get(long index) {
    return memory.getObject(index);
  }

  @Override
  public DataBuffer<T> set(T value, long index) {
    memory.setObject(value, index);
    return this;
  }

  @Override
  public DataBuffer<T> copyTo(DataBuffer<T> dst, long size) {
    if (dst instanceof AbstractRawDataBuffer) {
      AbstractRawDataBuffer unsafeDst = (AbstractRawDataBuffer)dst;

      // We can't use unsafe copy memory on object arrays, so if both memory regions are arrays,
      // then use system array copy. Otherwise, only use unsafe copy memory if both regions
      // are not arrays.
      if (memory.isArray() && unsafeDst.memory.isArray()) {
        memory.arrayCopyTo(unsafeDst.memory, size);
      } else if (!memory.isArray() && !unsafeDst.memory.isArray()) {
        memory.copyTo(unsafeDst.memory, size);
      } else {
        slowCopyTo(dst, size);
      }

    } else {
      slowCopyTo(dst, size);
    }
    return this;
  }

  protected ObjectRawDataBuffer(Unsafe unsafe, T[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected ObjectRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected DataBuffer<T> instantiate(UnsafeMemoryHandle memory) {
    return new ObjectRawDataBuffer<>(memory);
  }
}
