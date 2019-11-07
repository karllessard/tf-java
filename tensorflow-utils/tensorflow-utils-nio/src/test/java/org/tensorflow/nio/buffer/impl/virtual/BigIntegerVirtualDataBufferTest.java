package org.tensorflow.nio.buffer.impl.virtual;

import java.math.BigInteger;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.DataBufferTestBase;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.adapter.DataAdapter;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;

public class BigIntegerVirtualDataBufferTest extends DataBufferTestBase<BigInteger> {

  @Override
  protected DataBuffer<BigInteger> allocate(long capacity) {
    return DataBuffers.of(capacity, new TestBigIntegerAdapter());
  }

  @Override
  protected long maxCapacity() {
    return ByteJoinDataBuffer.MAX_CAPACITY / 3;
  }

  @Override
  protected BigInteger valueOf(Long val) {
    return BigInteger.valueOf(val);
  }

  private static class TestBigIntegerAdapter implements DataAdapter<BigInteger> {

    @Override
    public void writeValue(ByteDataBuffer buffer, BigInteger value) {
      byte[] bytes = value.toByteArray();
      buffer.put(bytes.length > 2 ? bytes[2] : 0);
      buffer.put(bytes.length > 1 ? bytes[1] : 0);
      buffer.put(bytes[0]);
    }

    @Override
    public BigInteger readValue(ByteDataBuffer buffer) {
      byte byte2 = buffer.get();
      byte byte1 = buffer.get();
      byte byte0 = buffer.get();
      return new BigInteger(new byte[] { byte2, byte1, byte0 });
    }

    @Override
    public int sizeInBytes() {
      return 3;
    }
  }
}
