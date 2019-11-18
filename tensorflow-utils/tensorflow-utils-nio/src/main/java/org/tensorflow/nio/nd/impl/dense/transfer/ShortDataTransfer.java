package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.ShortDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class ShortDataTransfer extends AbstractDataTransfer<Short, ShortDataBuffer> {

  public static void execute(ShortDataBuffer srcBuffer, DimensionalSpace srcDimensions, ShortDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(ShortDataBuffer srcBuffer, long srcPosition, ShortDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setShort(srcBuffer.getShort(srcPosition), dstPosition);
  }

  private static final ShortDataTransfer INSTANCE = new ShortDataTransfer();

  private ShortDataTransfer() {}
}
