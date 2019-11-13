package org.tensorflow.nio.nd.impl.sequence;

import org.tensorflow.nio.nd.NdArray;

public interface NdArrayCursor<T, U extends NdArray<T>> {

  U elementAt(long[] coords);
}
