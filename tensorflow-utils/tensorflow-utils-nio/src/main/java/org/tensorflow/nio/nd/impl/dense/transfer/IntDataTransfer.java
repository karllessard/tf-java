package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class IntDataTransfer extends AbstractDataTransfer<Integer, IntDataBuffer> {

  public static void execute(IntDataBuffer srcBuffer, DimensionalSpace srcDimensions, IntDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(IntDataBuffer srcBuffer, long srcPosition, IntDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setInt(srcBuffer.getInt(srcPosition), dstPosition);
  }

  private static final IntDataTransfer INSTANCE = new IntDataTransfer();

  private IntDataTransfer() {}
}
