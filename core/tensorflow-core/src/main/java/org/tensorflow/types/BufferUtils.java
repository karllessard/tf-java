package org.tensorflow.types;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.DataBuffer.ValueMapper;
import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.large.ByteLargeDataBuffer;
import org.tensorflow.nio.buffer.impl.large.DoubleLargeDataBuffer;
import org.tensorflow.nio.buffer.impl.large.FloatLargeDataBuffer;
import org.tensorflow.nio.buffer.impl.large.IntLargeDataBuffer;
import org.tensorflow.nio.buffer.impl.large.LargeDataBuffer;
import org.tensorflow.nio.buffer.impl.large.LongLargeDataBuffer;
import org.tensorflow.nio.buffer.impl.logical.LogicalDataBuffer;
import org.tensorflow.nio.buffer.impl.single.ByteJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.single.DoubleJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.single.FloatJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.single.IntJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.single.LongJdkDataBuffer;

final class BufferUtils {

  static ByteDataBuffer toByteDataBuffer(ByteBuffer[] bufs) {
    ByteDataBuffer[] buffers = Arrays.stream(bufs).map(ByteJdkDataBuffer::wrap).toArray(ByteDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : ByteLargeDataBuffer.join(buffers);
  }

  static IntDataBuffer toIntDataBuffer(ByteBuffer[] bufs) {
    IntDataBuffer[] buffers = Arrays.stream(bufs).map(b -> IntJdkDataBuffer.wrap(b.asIntBuffer())).toArray(IntDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : IntLargeDataBuffer.join(buffers);
  }

  static LongDataBuffer toLongDataBuffer(ByteBuffer[] bufs) {
    LongDataBuffer[] buffers = Arrays.stream(bufs).map(b -> LongJdkDataBuffer.wrap(b.asLongBuffer())).toArray(LongDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : LongLargeDataBuffer.join(buffers);
  }

  static FloatDataBuffer toFloatDataBuffer(ByteBuffer[] bufs) {
    FloatDataBuffer[] buffers = Arrays.stream(bufs).map(b -> FloatJdkDataBuffer.wrap(b.asFloatBuffer())).toArray(FloatDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : FloatLargeDataBuffer.join(buffers);
  }

  static DoubleDataBuffer toDoubleDataBuffer(ByteBuffer[] bufs) {
    DoubleDataBuffer[] buffers = Arrays.stream(bufs).map(b -> DoubleJdkDataBuffer.wrap(b.asDoubleBuffer())).toArray(DoubleDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : DoubleLargeDataBuffer.join(buffers);
  }

  static <T> DataBuffer<T> toDataBuffer(ByteBuffer[] bufs, ValueMapper<T> valueMapper) {
    LogicalDataBuffer<T>[] buffers = Arrays.stream(bufs).map(b -> LogicalDataBuffer.map(ByteJdkDataBuffer.wrap(b), valueMapper)).toArray(LogicalDataBuffer[]::new);
    return (buffers.length == 1) ? buffers[0] : LargeDataBuffer.join(buffers);
  }

  private BufferUtils() {
  }
}
