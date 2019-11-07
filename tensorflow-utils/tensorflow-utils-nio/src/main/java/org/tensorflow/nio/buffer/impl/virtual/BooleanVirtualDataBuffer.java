package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.Stream;
import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.adapter.BooleanDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class BooleanVirtualDataBuffer extends AbstractVirtualDataBuffer<Boolean, BooleanDataBuffer>
    implements BooleanDataBuffer {

  public static BooleanVirtualDataBuffer create(ByteDataBuffer delegate, BooleanDataAdapter booleanAdapter) {
    return new BooleanVirtualDataBuffer(delegate, booleanAdapter);
  }

  @Override
  public boolean getBoolean() {
    return adapter.readBoolean(physicalBuffer());
  }

  @Override
  public boolean getBoolean(long index) {
    Validator.getArgs(this, index);
    return adapter.readBoolean(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public BooleanDataBuffer get(boolean[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readBoolean(physicalBuffer());
    }
    return this;
  }

  @Override
  public BooleanDataBuffer putBoolean(boolean value) {
    adapter.writeBoolean(physicalBuffer(), value);
    return this;
  }

  @Override
  public BooleanDataBuffer putBoolean(long index, boolean value) {
    Validator.putArgs(this, index);
    adapter.writeBoolean(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public BooleanDataBuffer put(boolean[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeBoolean(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public Stream<Boolean> stream() {
    throw new UnsupportedOperationException("BooleanDataBuffer does not support value streaming at the moment");
  }

  @Override
  public BooleanDataBuffer duplicate() {
    return new BooleanVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private BooleanVirtualDataBuffer(ByteDataBuffer physicalBuffer, BooleanDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private BooleanDataAdapter adapter;
}
