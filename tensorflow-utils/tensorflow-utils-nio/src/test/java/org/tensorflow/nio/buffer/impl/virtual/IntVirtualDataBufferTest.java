package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.IntDataBufferTestBase;
import org.tensorflow.nio.buffer.adapter.IntDataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class IntVirtualDataBufferTest extends IntDataBufferTestBase {

  @Override
  protected IntDataBuffer allocate(long capacity) {
    return DataBuffers.ofInts(capacity, new TestIntAdapter());
  }

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY;
  }

  private static class TestIntAdapter implements IntDataAdapter {

    @Override
    public void writeInt(ByteDataBuffer buffer, int value) {
      buffer.put((byte)(((value & 0x80000000) >> 24) | ((value & 0x7F) >> 7)));
      buffer.put((byte)(value));
    }

    @Override
    public int readInt(ByteDataBuffer buffer) {
      int msb = buffer.get();
      int lsb = buffer.get();
      return ((msb & 0x80) << 24) | ((msb & 0x7F) << 7) | lsb;
    }

    @Override
    public int sizeInBytes() {
      return 2;
    }
  }
}
