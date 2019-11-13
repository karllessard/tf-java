package org.tensorflow.nio.nd.impl.sequence;

import java.util.function.BiConsumer;
import org.tensorflow.nio.nd.NdArraySequence;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.impl.AbstractNdArray;
import org.tensorflow.nio.nd.impl.dimension.DimensionalSpace;

public class ElementSequence<T, U extends NdArray<T>> implements NdArraySequence<U> {

  public static <T, U extends NdArray<T>> NdArraySequence<U> create(AbstractNdArray<T, U> ndArray, int dimensionIdx) {
    if (ndArray.rank() == 0 && dimensionIdx < 0) {
      return new SingleElementSequence<>(ndArray);
    }
    return new ElementSequence<>(ndArray, dimensionIdx);
  }

  @Override
  public void forEachIdx(BiConsumer<long[], U> consumer) {
    long[] coords = new long[dimensionIdx + 1];
    NdArrayCursor<T, U> cursor = ndArray.cursor(coords.length);
    while (true) {
      consumer.accept(coords, cursor.elementAt(coords));
      int j;
      for (j = dimensionIdx; j >= 0; --j) {
        if ((coords[j] = (coords[j] + 1) % ndArray.shape().size(j)) > 0) {
          break;
        }
      }
      if (j < 0) {
        return;
      }
    }
  }

  ElementSequence(AbstractNdArray<T, U> ndArray, int dimensionIdx) {
    this.ndArray = ndArray;
    this.dimensionIdx = dimensionIdx;
  }

  private final AbstractNdArray<T, U> ndArray;
  private final int dimensionIdx;
}
