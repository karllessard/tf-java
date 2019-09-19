package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.IntNdArray;
import org.tensorflow.types.family.TNumber;

public class TInt32 implements IntNdArray, TNumber {

  public static final DataType<TInt32> DTYPE = new DataType<>(3, 4);
}
