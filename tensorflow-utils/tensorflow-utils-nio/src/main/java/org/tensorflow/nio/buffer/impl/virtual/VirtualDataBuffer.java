package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.adapter.BooleanDataAdapter;
import org.tensorflow.nio.buffer.adapter.DataAdapter;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

@SuppressWarnings("unchecked")
public class VirtualDataBuffer<T> extends AbstractVirtualDataBuffer<T, DataBuffer<T>> {

  public static <T> VirtualDataBuffer<T> create(ByteDataBuffer delegate, DataAdapter<T> adapter) {
    return new VirtualDataBuffer<>(delegate, adapter);
  }

  @Override
  public DataBuffer<T> offset(long index) {
    return new VirtualDataBuffer<>(physicalBuffer().offset(index * adapter().sizeInBytes()), adapter());
  }

  @Override
  public DataBuffer<T> narrow(long size) {
    return new VirtualDataBuffer<>(physicalBuffer().narrow(size * adapter().sizeInBytes()), adapter());
  }

  private VirtualDataBuffer(ByteDataBuffer physicalBuffer, DataAdapter<T> adapter) {
    super(physicalBuffer, adapter);
  }
}
