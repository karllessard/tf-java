package org.tensorflow.nio.buffer.impl.virtual;

import java.util.stream.Stream;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.adapter.DataAdapter;

public class VirtualDataBuffer<T> extends AbstractVirtualDataBuffer<T, DataBuffer<T>> {

  public static <T> VirtualDataBuffer<T> create(ByteDataBuffer delegate, DataAdapter<T> valueAdapter) {
    return new VirtualDataBuffer<>(delegate, valueAdapter);
  }

  @Override
  public Stream<T> stream() {
    throw new UnsupportedOperationException(); // FIXME TODO!
  }

  @Override
  public DataBuffer<T> duplicate() {
    return new VirtualDataBuffer<>(physicalBuffer().duplicate(), adapter());
  }

  private VirtualDataBuffer(ByteDataBuffer physicalBuffer, DataAdapter<T> mapper) {
    super(physicalBuffer, mapper);
  }
}
