package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.DoubleDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class DoubleDataTransfer extends AbstractDataTransfer<Double, DoubleDataBuffer> {

  public static void execute(DoubleDataBuffer srcBuffer, DimensionalSpace srcDimensions, DoubleDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(DoubleDataBuffer srcBuffer, long srcPosition, DoubleDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setDouble(srcBuffer.getDouble(srcPosition), dstPosition);
  }

  private static final DoubleDataTransfer INSTANCE = new DoubleDataTransfer();

  private DoubleDataTransfer() {}
}
