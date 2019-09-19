package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.types.family.TType;

public class TBool implements NdArray<Boolean>, TType {

  public static final DataType<TBool> DTYPE = new DataType<>(10, 1);
}
