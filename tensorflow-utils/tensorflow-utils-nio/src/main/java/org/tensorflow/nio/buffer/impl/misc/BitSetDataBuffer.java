package org.tensorflow.nio.buffer.impl.misc;

import java.util.BitSet;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class BitSetDataBuffer extends AbstractDataBuffer<Boolean> implements BooleanDataBuffer  {

  public static long MAX_CAPACITY = Integer.MAX_VALUE - 2;

  public static BooleanDataBuffer allocate(long capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity must be non-negative");
    }
    if (capacity > MAX_CAPACITY) {
      throw new IllegalArgumentException("Size for an bit-set data buffer cannot exceeds " + MAX_CAPACITY +
          " elements, use a JoinDataBuffer instead");
    }
    return new BitSetDataBuffer(new BitSet((int)capacity), false);
  }

  @Override
  public long capacity() {
    return length;
  }

  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  @Override
  public Stream<Boolean> stream() {
    throw new UnsupportedOperationException("BooleanDataBuffer does not support value streaming at the moment");
  }

  @Override
  public boolean getBoolean(long index) {
    Validator.getArgs(this, index);
    return bitSet.get((int)index + offset);
  }

  @Override
  public BooleanDataBuffer putBoolean(long index, boolean value) {
    Validator.putArgs(this, index);
    bitSet.set((int)index + offset, value);
    return this;
  }

  @Override
  public BooleanDataBuffer copyTo(DataBuffer<Boolean> dst) {
    Validator.copyToArgs(this, dst);
    slowCopyTo(dst);
    return this;
  }

  @Override
  public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    for (int idx = 0; idx < length; ++idx) {
      dst[idx + offset] = bitSet.get(idx + this.offset);
    }
    return this;
  }

  @Override
  public BooleanDataBuffer write(boolean[] src, int offset, int length) {
    Validator.readArgs(this, src.length, offset, length);
    for (int idx = 0; idx < length; ++idx) {
      bitSet.set(idx + this.offset, src[idx + offset]);
    }
    return this;
  }

  @Override
  public BooleanDataBuffer offset(long index) {
    Validator.offsetArgs(this, index);
    return new BitSetDataBuffer(bitSet, readOnly, (int)index + offset, length);
  }

  @Override
  public BooleanDataBuffer narrow(long capacity) {
    Validator.narrowArgs(this, capacity);
    return new BitSetDataBuffer(bitSet, readOnly, offset, (int)capacity);
  }

  private BitSetDataBuffer(BitSet bitSet, boolean readOnly) {
    this(bitSet, readOnly, 0, bitSet.length());
  }

  private BitSetDataBuffer(BitSet bitSet, boolean readOnly, int offset, int length) {
    this.bitSet = bitSet;
    this.readOnly = readOnly;
    this.offset = offset;
    this.length = length;
  }

  private final BitSet bitSet;
  private final boolean readOnly;
  private final int offset;
  private final int length;
}
