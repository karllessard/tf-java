package org.tensorflow.nio.nd.impl.sequence;

import java.util.PrimitiveIterator;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class DimensionalPositionIterator implements PrimitiveIterator.OfLong {

  @Override
  public boolean hasNext() {
    return coords != null;
  }

  @Override
  public long nextLong() {
    long position = dimensions.positionOf(coords, false);
    for (int i = coords.length - 1; i >= 0; --i) {
      if ((coords[i] = (coords[i] + 1) % dimensions.get(i).size()) > 0) {
        return position;
      }
    }
    coords = null;
    return position;
  }

  public DimensionalPositionIterator(DimensionalSpace dimensions, int dimensionIdx) {
    this.dimensions = dimensions;
    coords = new long[dimensionIdx + 1];
  }

  private DimensionalSpace dimensions;
  private long[] coords;
}
