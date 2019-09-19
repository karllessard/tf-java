package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.FloatNdArray;
import org.tensorflow.types.family.TDecimal;

public class TFloat implements FloatNdArray, TDecimal {

  public static final DataType<TFloat> DTYPE = new DataType<>(1, 4);
}
