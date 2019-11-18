package org.tensorflow.nio.nd.impl.dense.transfer;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class DataTransfer<T> extends AbstractDataTransfer<T, DataBuffer<T>> {

  public static <T> void execute(DataBuffer<T> srcBuffer, DimensionalSpace srcDimensions, DataBuffer<T> dstBuffer, DimensionalSpace dstDimensions) {
    new DataTransfer<T>().doExecute(srcBuffer, srcDimensions, dstBuffer, dstDimensions);
  }

  @Override
  void copyValue(DataBuffer<T> srcBuffer, long srcPosition, DataBuffer<T> dstBuffer, long dstPosition) {
    dstBuffer.set(srcBuffer.get(srcPosition), dstPosition);
  }

  private DataTransfer() {}
}
