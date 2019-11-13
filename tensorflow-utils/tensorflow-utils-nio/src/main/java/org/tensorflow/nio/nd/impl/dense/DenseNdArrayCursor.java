package org.tensorflow.nio.nd.impl.dense;

import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.impl.dense.mutable.MutableDataBuffer;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;
import org.tensorflow.nio.nd.impl.sequence.NdArrayCursor;

public class DenseNdArrayCursor<T, U extends NdArray<T>> implements NdArrayCursor<T, U> {

  @Override
  @SuppressWarnings("unchecked")
  public U elementAt(long[] coords) {
    long elementPos = dimensions.positionOf(coords, false);
    ((MutableDataBuffer<T, ?>)mutableElement.buffer()).moveTo(elementPos);
    return (U)mutableElement;
  }

  DenseNdArrayCursor(AbstractDenseNdArray<T, U> mutableElement, DimensionalSpace dimensions) {
    this.mutableElement = mutableElement;
    this.dimensions = dimensions;
  }

  private final AbstractDenseNdArray<T, U> mutableElement;
  private final DimensionalSpace dimensions;
}
