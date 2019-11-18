package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class ByteDataTransfer extends AbstractDataTransfer<Byte, ByteDataBuffer> {

  public static void execute(ByteDataBuffer srcBuffer, DimensionalSpace srcDimensions, ByteDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(ByteDataBuffer srcBuffer, long srcPosition, ByteDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setByte(srcBuffer.getByte(srcPosition), dstPosition);
  }

  private static final ByteDataTransfer INSTANCE = new ByteDataTransfer();

  private ByteDataTransfer() {}
}
