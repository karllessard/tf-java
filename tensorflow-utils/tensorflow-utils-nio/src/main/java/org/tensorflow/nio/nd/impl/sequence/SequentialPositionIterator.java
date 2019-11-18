package org.tensorflow.nio.nd.impl.sequence;

import java.util.PrimitiveIterator;
import org.tensorflow.nio.nd.impl.dimension.Dimension;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class SequentialPositionIterator implements PrimitiveIterator.OfLong {

  @Override
  public boolean hasNext() {
    return index <= maxIndex;
  }

  @Override
  public long nextLong() {
    return stride * index++;
  }

  public SequentialPositionIterator(long stride, long maxIndex) {
    this.stride = stride;
    this.maxIndex = maxIndex;
  }

  private final long stride;
  private final long maxIndex;
  private long index;
}
