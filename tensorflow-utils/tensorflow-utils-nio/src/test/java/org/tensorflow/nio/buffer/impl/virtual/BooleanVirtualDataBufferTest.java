package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.BooleanDataBufferTestBase;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.adapter.BooleanDataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class BooleanVirtualDataBufferTest extends BooleanDataBufferTestBase {

  @Override
  protected BooleanDataBuffer allocate(long capacity) {
    return DataBuffers.ofBooleans(capacity, new TestBooleanAdapter());
  }

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY;
  }

  private static class TestBooleanAdapter implements BooleanDataAdapter {

    @Override
    public void writeBoolean(ByteDataBuffer buffer, boolean value) {
      buffer.put((byte)(value ? 1 : 0));
    }

    @Override
    public boolean readBoolean(ByteDataBuffer buffer) {
      return buffer.get() > 0;
    }

    @Override
    public int sizeInBytes() {
      return 1;
    }
  }
}
