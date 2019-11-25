package org.tensorflow.nio.buffer.impl.heap;

import java.lang.reflect.Array;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.buffer.impl.raw.ObjectRawDataBuffer;
import org.tensorflow.nio.buffer.impl.raw.UnsafeMemoryHandle;

public class ObjectHeapDataBuffer<T> extends ObjectRawDataBuffer<T> {

  public static <T> DataBuffer<T> allocate(Class<T> type, long size) {
    Validator.allocateArgs(size, MAX_SIZE);
    @SuppressWarnings("unchecked")
    T[] data = (T[]) Array.newInstance(type, (int)size);
    return new ObjectHeapDataBuffer<>(data, false);
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public T get(long index) {
    Validator.getArgs(this, index);
    return super.get(index);
  }

  @Override
  public DataBuffer<T> set(T value, long index) {
    Validator.setArgs(this, index);
    return super.set(value, index);
  }

  @Override
  public DataBuffer<T> copyTo(DataBuffer<T> dst, long size) {
    Validator.copyToArgs(this, dst, size);
    return super.copyTo(dst, size);
  }

  @Override
  public DataBuffer<T> offset(long index) {
    Validator.offsetArgs(this, index);
    return super.offset(index);
  }

  @Override
  public DataBuffer<T> narrow(long size) {
    Validator.narrowArgs(this, size);
    return super.narrow(size);
  }

  @Override
  protected DataBuffer<T> instantiate(UnsafeMemoryHandle memory) {
    return new ObjectHeapDataBuffer<>(memory, readOnly);
  }

  private ObjectHeapDataBuffer(T[] data, boolean readOnly) {
    super(data);
    this.readOnly = readOnly;
  }

  private ObjectHeapDataBuffer(UnsafeMemoryHandle memory, boolean readOnly) {
    super(memory);
    this.readOnly = readOnly;
  }

  private final boolean readOnly;
}
