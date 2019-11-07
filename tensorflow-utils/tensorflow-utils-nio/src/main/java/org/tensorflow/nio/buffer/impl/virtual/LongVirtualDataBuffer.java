package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.LongStream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.adapter.LongDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class LongVirtualDataBuffer extends AbstractVirtualDataBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

  public static LongVirtualDataBuffer create(ByteDataBuffer delegate, LongDataAdapter longAdapter) {
    return new LongVirtualDataBuffer(delegate, longAdapter);
  }

  @Override
  public LongStream longStream() {
    return LongStream.iterate(0, this::get).limit(remaining());
  }

  @Override
  public long getLong() {
    return adapter.readLong(physicalBuffer());
  }

  @Override
  public long getLong(long index) {
    Validator.getArgs(this, index);
    return adapter.readLong(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public LongDataBuffer get(long[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readLong(physicalBuffer());
    }
    return this;
  }

  @Override
  public LongDataBuffer putLong(long value) {
    adapter.writeLong(physicalBuffer(), value);
    return this;
  }

  @Override
  public LongDataBuffer putLong(long index, long value) {
    Validator.putArgs(this, index);
    adapter.writeLong(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public LongDataBuffer put(long[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeLong(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public LongDataBuffer duplicate() {
    return new LongVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private LongVirtualDataBuffer(ByteDataBuffer physicalBuffer, LongDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private LongDataAdapter adapter;
}
