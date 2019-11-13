package org.tensorflow.nio.buffer.slice;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;

public class ByteMutableDataBufferTest extends MutableDataBufferTestBase<Byte> {

  @Override
  protected Byte valueOf(Long val) {
    return val.byteValue();
  }

  @Override
  protected DataBuffer<Byte> allocate(long capacity) {
    return DataBuffers.ofBytes(capacity);
  }
}
