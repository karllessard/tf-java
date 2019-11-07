package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.LongDataBufferTestBase;
import org.tensorflow.nio.buffer.adapter.LongDataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class LongVirtualDataBufferTest extends LongDataBufferTestBase {

  @Override
  protected LongDataBuffer allocate(long capacity) {
    return DataBuffers.ofLongs(capacity, new TestLongAdapter());
  }

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY / 3;
  }

  private static class TestLongAdapter implements LongDataAdapter {

    @Override
    public void writeLong(ByteDataBuffer buffer, long value) {
      buffer.put((byte)(((value >> 56) & 0x80) | ((value >> 16) & 0x7F)));
      buffer.put((byte)((value >> 8) & 0xFF));
      buffer.put((byte)(value & 0xFF));
    }

    @Override
    public long readLong(ByteDataBuffer buffer) {
      long msb = buffer.get();
      long midb = buffer.get();
      long lsb = buffer.get();
      return ((msb & 0x80) << 56) | ((msb & 0x7F) << 16) | ((midb & 0xFF) << 8) | (lsb & 0xFF);
    }

    @Override
    public int sizeInBytes() {
      return 3;
    }
  }
}
