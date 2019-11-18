package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class LongDataTransfer extends AbstractDataTransfer<Long, LongDataBuffer> {

  public static void execute(LongDataBuffer srcBuffer, DimensionalSpace srcDimensions, LongDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(LongDataBuffer srcBuffer, long srcPosition, LongDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setLong(srcBuffer.getLong(srcPosition), dstPosition);
  }

  private static final LongDataTransfer INSTANCE = new LongDataTransfer();

  private LongDataTransfer() {}
}
