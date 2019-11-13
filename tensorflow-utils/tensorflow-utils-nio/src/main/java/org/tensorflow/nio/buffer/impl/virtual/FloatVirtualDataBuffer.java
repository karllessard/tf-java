package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.Stream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.adapter.FloatDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class FloatVirtualDataBuffer extends AbstractVirtualDataBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

  public static FloatVirtualDataBuffer create(ByteDataBuffer delegate, FloatDataAdapter floatAdapter) {
    return new FloatVirtualDataBuffer(delegate, floatAdapter);
  }

  @Override
  public float getFloat() {
    return adapter.readFloat(physicalBuffer());
  }

  @Override
  public float getFloat(long index) {
    Validator.getArgs(this, index);
    return adapter.readFloat(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public FloatDataBuffer get(float[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readFloat(physicalBuffer());
    }
    return this;
  }

  @Override
  public FloatDataBuffer putFloat(float value) {
    adapter.writeFloat(physicalBuffer(), value);
    return this;
  }

  @Override
  public FloatDataBuffer putFloat(long index, float value) {
    Validator.copyToArgs(this, index);
    adapter.writeFloat(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public FloatDataBuffer put(float[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeFloat(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public Stream<Float> stream() {
    return Stream.iterate(0.0f, f -> get(f.intValue())).limit(remaining());
  }

  @Override
  public FloatDataBuffer duplicate() {
    return new FloatVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private FloatVirtualDataBuffer(ByteDataBuffer physicalBuffer, FloatDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private FloatDataAdapter adapter;
}
