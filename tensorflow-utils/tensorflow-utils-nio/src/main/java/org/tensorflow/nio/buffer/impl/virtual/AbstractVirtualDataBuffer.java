package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.adapter.DataAdapter;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

@SuppressWarnings("unchecked")
abstract class AbstractVirtualDataBuffer<T, B extends DataBuffer<T>> extends
    AbstractDataBuffer<T, B> {

  @Override
  public long capacity() {
    return physicalBuffer.capacity() / adapter.sizeInBytes();
  }

  @Override
  public long limit() {
    return physicalBuffer.limit() / adapter.sizeInBytes();
  }

  @Override
  public B limit(long newLimit) {
    physicalBuffer.limit(newLimit * adapter.sizeInBytes());
    return (B) this;
  }

  @Override
  public boolean hasRemaining() {
    return physicalBuffer.hasRemaining();
  }

  @Override
  public long remaining() {
    return physicalBuffer.remaining() / adapter.sizeInBytes();
  }

  @Override
  public long position() {
    return physicalBuffer.position() / adapter.sizeInBytes();
  }

  @Override
  public B position(long newPosition) {
    physicalBuffer.position(newPosition * adapter.sizeInBytes());
    return (B) this;
  }

  @Override
  public B rewind() {
    physicalBuffer.rewind();
    return (B) this;
  }

  @Override
  public boolean isReadOnly() {
    return physicalBuffer.isReadOnly();
  }

  @Override
  public T get() {
    return adapter.readValue(physicalBuffer());
  }

  @Override
  public T get(long index) {
    Validator.getArgs(this, index);
    // FIXME this duplicates the physical buffer on each call
    return adapter.readValue(physicalBuffer().withPosition(index * adapter.sizeInBytes()));
  }

  @Override
  public B put(T value) {
    adapter.writeValue(physicalBuffer(), value);
    return (B) this;
  }

  @Override
  public B put(long index, T value) {
    Validator.copyToArgs(this, index);
    // FIXME this duplicates the physical buffer on each call
    adapter.writeValue(physicalBuffer().withPosition(index * adapter.sizeInBytes()), value);
    return (B) this;
  }

  protected ByteDataBuffer physicalBuffer() {
    return physicalBuffer;
  }

  protected DataAdapter<T> adapter() {
    return adapter;
  }

  AbstractVirtualDataBuffer(ByteDataBuffer physicalBuffer, DataAdapter<T> adapter) {
    this.physicalBuffer = physicalBuffer;
    this.adapter = adapter;
  }

  private final ByteDataBuffer physicalBuffer;
  private final DataAdapter<T> adapter;
}
