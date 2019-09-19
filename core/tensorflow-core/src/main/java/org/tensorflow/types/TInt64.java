package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.LongNdArray;
import org.tensorflow.types.family.TNumber;

public class TInt64 implements LongNdArray, TNumber {

  public static final DataType<TInt64> DTYPE = new DataType<>(9, 8);
}
