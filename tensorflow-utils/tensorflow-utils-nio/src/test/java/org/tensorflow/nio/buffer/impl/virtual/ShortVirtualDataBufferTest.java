package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.buffer.ShortDataBufferTestBase;
import org.tensorflow.nio.buffer.adapter.ShortDataAdapter;
import org.tensorflow.nio.buffer.adapter.ShortDataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class ShortVirtualDataBufferTest extends ShortDataBufferTestBase {

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY;
  }

  private static class TestShort8Adapter implements ShortDataAdapter {

    @Override
    public void writeShort(ByteDataBuffer buffer, short value) {
      buffer.put((byte)(((value & 0x8000) >> 8) | (value & 0x7F)));
    }

    @Override
    public short readShort(ByteDataBuffer buffer) {
      int b = buffer.get();
      return (short)(((b & 0x80) << 8) | (b & 0x7F));
    }

    @Override
    public int sizeInBytes() {
      return 1;
    }
  }

  public ShortDataBuffer allocate(long capacity) {
    return DataBuffers.ofShorts(capacity, new TestShort8Adapter());
  }
}
