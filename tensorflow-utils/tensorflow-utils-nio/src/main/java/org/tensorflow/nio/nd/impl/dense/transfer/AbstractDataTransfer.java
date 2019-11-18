package org.tensorflow.nio.nd.impl.dense.transfer;

import java.util.PrimitiveIterator;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.impl.dimension.Dimension;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.DimensionalPositionIterator;
import org.tensorflow.nio.nd.impl.sequence.SequentialPositionIterator;

abstract class AbstractDataTransfer<T, B extends DataBuffer<T>> {

  void doExecute(B srcBuffer, DimensionalSpace srcDimensions, B dstBuffer, DimensionalSpace dstDimensions) {
    int srcSegmentationIdx = srcDimensions != null ? srcDimensions.segmentationIdx() : -1;
    int dstSegmentationIdx = dstDimensions != null ? dstDimensions.segmentationIdx() : -1;
    if (srcSegmentationIdx < 0 && dstSegmentationIdx < 0) {
      srcBuffer.copyTo(dstBuffer, Math.min(srcBuffer.size(), dstBuffer.size())); // FIXME are the buffers the right size??
    } else {
      int dimensionIdx = Math.max(srcSegmentationIdx, dstSegmentationIdx);
      PrimitiveIterator.OfLong srcIterator = iteratorFor(srcDimensions, srcSegmentationIdx, dimensionIdx);
      PrimitiveIterator.OfLong dstIterator = iteratorFor(dstDimensions, dstSegmentationIdx, dimensionIdx);
      if (dimensionIdx == srcDimensions.size() - 1) {
        while (srcIterator.hasNext()) {
          copyValue(srcBuffer, srcIterator.nextLong(), dstBuffer, dstIterator.nextLong());
        }
      } else {
        long size = srcDimensions.get(dimensionIdx).stride();
        while (srcIterator.hasNext()) {
          srcBuffer.offset(srcIterator.nextLong()).copyTo(dstBuffer.offset(dstIterator.nextLong()), size);
        }
      }
    }
  }

  abstract void copyValue(B srcBuffer, long srcPosition, B dstBuffer, long dstPosition);

  private PrimitiveIterator.OfLong iteratorFor(DimensionalSpace dimensions, int segmentIdx, int dimensionIdx) {
    if (segmentIdx >= 0) {
      return new DimensionalPositionIterator(dimensions, dimensionIdx);
    }
    // FIXME! if dimensions is null???
    Dimension dimension = dimensions.get(dimensionIdx);
    return new SequentialPositionIterator(dimension.stride(), dimension.size() - 1);
  }
}
