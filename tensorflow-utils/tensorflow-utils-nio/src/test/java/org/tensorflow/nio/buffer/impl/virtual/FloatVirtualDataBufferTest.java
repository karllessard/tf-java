package org.tensorflow.nio.buffer.impl.virtual;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.FloatDataBufferTestBase;
import org.tensorflow.nio.buffer.adapter.FloatDataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class FloatVirtualDataBufferTest extends FloatDataBufferTestBase {

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY / 2;
  }

  private static class TestFloat16Adapter implements FloatDataAdapter {

    @Override
    public void writeFloat(ByteDataBuffer buffer, float value) {
      int bits = Float.floatToIntBits(value);
      buffer.put((byte)((bits >> 24) & 0xFF));
      buffer.put((byte)((bits >> 16) & 0xFF));
    }

    @Override
    public float readFloat(ByteDataBuffer buffer) {
      int byte3 = buffer.get();
      int byte2 = buffer.get();
      return Float.intBitsToFloat(((byte3 & 0xFF) << 24) | ((byte2 & 0xFF) << 16));
    }

    @Override
    public int sizeInBytes() {
      return 2;
    }
  }

  public FloatDataBuffer allocate(long capacity) {
    return DataBuffers.ofFloats(capacity, new TestFloat16Adapter());
  }
}
