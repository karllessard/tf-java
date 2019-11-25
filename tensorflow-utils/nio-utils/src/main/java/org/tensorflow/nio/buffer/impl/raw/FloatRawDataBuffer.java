package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.FloatDataBuffer;

public class FloatRawDataBuffer extends AbstractRawDataBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

  @Override
  public float getFloat(long index) {
    return memory.getFloat(index);
  }

  @Override
  public FloatDataBuffer setFloat(float value, long index) {
    memory.setFloat(value, index);
    return this;
  }

  @Override
  public FloatDataBuffer read(float[] dst) {
    memory.copyTo(UnsafeMemoryHandle.of(dst), dst.length);
    return this;
  }

  @Override
  public FloatDataBuffer read(float[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(dst).offset(offset), length);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src) {
    UnsafeMemoryHandle.of(src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src, int offset, int length) {
    UnsafeMemoryHandle.of(src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected FloatRawDataBuffer(float[] data) {
    this(UnsafeMemoryHandle.of(data));
  }

  protected FloatRawDataBuffer(long address, long size) {
    this(UnsafeMemoryHandle.of(address, size, Float.BYTES));
  }

  protected FloatRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected FloatDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new FloatRawDataBuffer(memory);
  }
}
