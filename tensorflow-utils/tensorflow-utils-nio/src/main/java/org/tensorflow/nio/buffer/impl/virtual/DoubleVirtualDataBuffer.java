package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.DoubleStream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.adapter.DoubleDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class DoubleVirtualDataBuffer extends AbstractVirtualDataBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

  public static DoubleVirtualDataBuffer create(ByteDataBuffer delegate, DoubleDataAdapter doubleAdapter) {
    return new DoubleVirtualDataBuffer(delegate, doubleAdapter);
  }

  @Override
  public DoubleStream doubleStream() {
    return DoubleStream.iterate(0.0, d -> get((int)d)).limit(remaining());
  }

  @Override
  public double getDouble() {
    return adapter.readDouble(physicalBuffer());
  }

  @Override
  public double getDouble(long index) {
    Validator.getArgs(this, index);
    return adapter.readDouble(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public DoubleDataBuffer get(double[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readDouble(physicalBuffer());
    }
    return this;
  }

  @Override
  public DoubleDataBuffer putDouble(double value) {
    adapter.writeDouble(physicalBuffer(), value);
    return this;
  }

  @Override
  public DoubleDataBuffer putDouble(long index, double value) {
    Validator.putArgs(this, index);
    adapter.writeDouble(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public DoubleDataBuffer put(double[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeDouble(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public DoubleDataBuffer duplicate() {
    return new DoubleVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private DoubleVirtualDataBuffer(ByteDataBuffer physicalBuffer, DoubleDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private DoubleDataAdapter adapter;
}
