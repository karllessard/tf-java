package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.IntStream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.adapter.IntDataAdapter;
import org.tensorflow.nio.buffer.impl.Validator;

public class IntVirtualDataBuffer extends AbstractVirtualDataBuffer<Integer, IntDataBuffer>
    implements IntDataBuffer {

  public static IntVirtualDataBuffer create(ByteDataBuffer delegate, IntDataAdapter intAdapter) {
    return new IntVirtualDataBuffer(delegate, intAdapter);
  }

  @Override
  public IntStream intStream() {
    return IntStream.iterate(0, this::get).limit(remaining());
  }

  @Override
  public int getInt() {
    return adapter.readInt(physicalBuffer());
  }

  @Override
  public int getInt(long index) {
    Validator.getArgs(this, index);
    return adapter.readInt(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public IntDataBuffer get(int[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      dst[i] = adapter.readInt(physicalBuffer());
    }
    return this;
  }

  @Override
  public IntDataBuffer putInt(int value) {
    adapter.writeInt(physicalBuffer(), value);
    return this;
  }

  @Override
  public IntDataBuffer putInt(long index, int value) {
    Validator.copyToArgs(this, index);
    adapter.writeInt(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return this;
  }

  @Override
  public IntDataBuffer put(int[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    for (int i = offset; i < offset + length; ++i) {
      adapter.writeInt(physicalBuffer(), src[i]);
    }
    return this;
  }

  @Override
  public IntDataBuffer duplicate() {
    return new IntVirtualDataBuffer(physicalBuffer().duplicate(), adapter);
  }

  private IntVirtualDataBuffer(ByteDataBuffer physicalBuffer, IntDataAdapter adapter) {
    super(physicalBuffer, adapter);
    this.adapter = adapter;
  }

  private IntDataAdapter adapter;
}
