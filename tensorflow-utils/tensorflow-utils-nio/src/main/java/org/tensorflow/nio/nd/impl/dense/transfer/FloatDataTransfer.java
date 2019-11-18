package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class FloatDataTransfer extends AbstractDataTransfer<Float, FloatDataBuffer> {

  public static void execute(FloatDataBuffer srcBuffer, DimensionalSpace srcDimensions, FloatDataBuffer dstBuffer, DimensionalSpace dstDimensions) {
    INSTANCE.doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(FloatDataBuffer srcBuffer, long srcPosition, FloatDataBuffer dstBuffer, long dstPosition) {
    dstBuffer.setFloat(srcBuffer.getFloat(srcPosition), dstPosition);
  }

  private static final FloatDataTransfer INSTANCE = new FloatDataTransfer();

  private FloatDataTransfer() {}
}
