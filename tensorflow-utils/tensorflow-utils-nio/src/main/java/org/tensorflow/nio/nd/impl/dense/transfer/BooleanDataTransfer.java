package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class BooleanDataTransfer extends AbstractDataTransfer<Boolean, BooleanDataBuffer> {

  public static void execute(BooleanDataBuffer srcBuffer, DimensionalSpace srcDimensions, BooleanDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(BooleanDataBuffer srcBuffer, long srcPosition, BooleanDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setBoolean(srcBuffer.getBoolean(srcPosition), dstPosition);
  }

  private static final BooleanDataTransfer INSTANCE = new BooleanDataTransfer();

  private BooleanDataTransfer() {}
}
