package org.tensorflow.nio.buffer.impl.raw;

import sun.misc.Unsafe;

public final class UnsafeMemoryHandle {

  static UnsafeMemoryHandle of(Unsafe unsafe, byte[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_BYTE_BASE_OFFSET, array.length, Unsafe.ARRAY_BYTE_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, boolean[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_BOOLEAN_BASE_OFFSET, array.length, Unsafe.ARRAY_BOOLEAN_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, short[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_SHORT_BASE_OFFSET, array.length, Unsafe.ARRAY_SHORT_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, int[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_INT_BASE_OFFSET, array.length, Unsafe.ARRAY_INT_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, float[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_FLOAT_BASE_OFFSET, array.length, Unsafe.ARRAY_FLOAT_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, double[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_DOUBLE_BASE_OFFSET, array.length, Unsafe.ARRAY_DOUBLE_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, long[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_LONG_BASE_OFFSET, array.length, Unsafe.ARRAY_LONG_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, Object[] array) {
    return new UnsafeMemoryHandle(unsafe, array, Unsafe.ARRAY_OBJECT_BASE_OFFSET, array.length, Unsafe.ARRAY_OBJECT_INDEX_SCALE);
  }

  static UnsafeMemoryHandle of(Unsafe unsafe, long address, long length, long scale) {
    return new UnsafeMemoryHandle(unsafe, null, address, length, scale);
  }

  final Unsafe unsafe;

  long size() {
    return size;
  }

  boolean isArray() {
    return object != null;
  }

  byte getByte(long index) {
    return unsafe.getByte(object, align(index));
  }

  void setByte(byte value, long index) {
    unsafe.putByte(object, align(index), value);
  }

  boolean getBoolean(long index) {
    return unsafe.getBoolean(object, align(index));
  }

  void setBoolean(boolean value, long index) {
    unsafe.putBoolean(object, align(index), value);
  }

  short getShort(long index) {
    return unsafe.getShort(object, align(index));
  }

  void setShort(short value, long index) {
    unsafe.putShort(object, align(index), value);
  }

  int getInt(long index) {
    return unsafe.getInt(object, align(index));
  }

  void setInt(int value, long index) {
    unsafe.putInt(object, align(index), value);
  }

  float getFloat(long index) {
    return unsafe.getFloat(object, align(index));
  }

  void setFloat(float value, long index) {
    unsafe.putFloat(object, align(index), value);
  }

  double getDouble(long index) {
    return unsafe.getDouble(object, align(index));
  }

  void setDouble(double value, long index) {
    unsafe.putDouble(object, align(index), value);
  }

  long getLong(long index) {
    return unsafe.getLong(object, align(index));
  }

  void setLong(long value, long index) {
    unsafe.putLong(object, align(index), value);
  }

  @SuppressWarnings("unchecked")
  <T> T getObject(long index) {
    return (T)unsafe.getObject(object, align(index));
  }

  <T> void setObject(T value, long index) {
    unsafe.putObject(object, align(index), value);
  }

  void copyTo(UnsafeMemoryHandle memory, long length) {
    unsafe.copyMemory(object, byteOffset, memory.object, memory.byteOffset, length * scale);
  }

  void arrayCopyTo(UnsafeMemoryHandle memory, long length) {
    System.arraycopy(object, 0, memory.object, 0, (int)length);
  }

  UnsafeMemoryHandle offset(long index) {
    return new UnsafeMemoryHandle(unsafe, object, this.byteOffset + scale(index), size - index, scale);
  }

  UnsafeMemoryHandle narrow(long size) {
    return new UnsafeMemoryHandle(unsafe, object, byteOffset, size, scale);
  }

  private final Object object;
  private final long byteOffset;
  private final long size;
  private final long scale;

  private UnsafeMemoryHandle(Unsafe unsafe, Object object, long byteOffset, long size, long scale) {
    this.unsafe = unsafe;
    this.object = object;
    this.byteOffset = byteOffset;
    this.size = size; // unscaled
    this.scale = scale;
  }

  private long align(long index) {
    return byteOffset + index * scale;
  }

  private long scale(long value) {
    return value * scale;
  }
}
