package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.Stream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.buffer.adapter.ShortDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class ShortVirtualDataBuffer extends AbstractVirtualDataBuffer<Short, ShortDataBuffer>
    implements ShortDataBuffer {

  public static ShortVirtualDataBuffer create(ByteDataBuffer delegate, ShortDataAdapter shortAdapter) {
    return new ShortVirtualDataBuffer(delegate, shortAdapter);
  }

  @Override
  public short getShort() {
    return adapter.readShort(physicalBuffer());
  }

  @Override
  public short getShort(long index) {
    Validator.getArgs(this, index);
    return adapter.readShort(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public ShortDataBuffer get(short[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readShort(physicalBuffer());
    }
    return this;
  }

  @Override
  public ShortDataBuffer putShort(short value) {
    adapter.writeShort(physicalBuffer(), value);
    return this;
  }

  @Override
  public ShortDataBuffer putShort(long index, short value) {
    Validator.copyToArgs(this, index);
    adapter.writeShort(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public ShortDataBuffer put(short[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeShort(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public Stream<Short> stream() {
    return Stream.iterate((short)0, s -> get(s.intValue())).limit(remaining());
  }

  @Override
  public ShortDataBuffer duplicate() {
    return new ShortVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private ShortVirtualDataBuffer(ByteDataBuffer physicalBuffer, ShortDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private ShortDataAdapter adapter;
}
