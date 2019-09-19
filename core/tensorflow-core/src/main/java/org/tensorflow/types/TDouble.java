package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.DoubleNdArray;
import org.tensorflow.types.family.TDecimal;

public class TDouble implements DoubleNdArray, TDecimal {

  public static final DataType<TDouble> DTYPE = new DataType<>(2, 8);
}
