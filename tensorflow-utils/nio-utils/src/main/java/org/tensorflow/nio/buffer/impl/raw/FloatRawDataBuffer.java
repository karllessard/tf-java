package org.tensorflow.nio.buffer.impl.raw;

import org.tensorflow.nio.buffer.FloatDataBuffer;
import sun.misc.Unsafe;

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
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst), dst.length);
    return this;
  }

  @Override
  public FloatDataBuffer read(float[] dst, int offset, int length) {
    memory.copyTo(UnsafeMemoryHandle.of(memory.unsafe, dst).offset(offset), length);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src) {
    UnsafeMemoryHandle.of(memory.unsafe, src).copyTo(memory, src.length);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src, int offset, int length) {
    UnsafeMemoryHandle.of(memory.unsafe, src).offset(offset).copyTo(memory, length);
    return this;
  }

  protected FloatRawDataBuffer(Unsafe unsafe, float[] data) {
    this(UnsafeMemoryHandle.of(unsafe, data));
  }

  protected FloatRawDataBuffer(Unsafe unsafe, long address, long size) {
    this(UnsafeMemoryHandle.of(unsafe, address, size, Float.BYTES));
  }

  protected FloatRawDataBuffer(UnsafeMemoryHandle memory) {
    super(memory);
  }

  @Override
  protected FloatDataBuffer instantiate(UnsafeMemoryHandle memory) {
    return new FloatRawDataBuffer(memory);
  }
}
