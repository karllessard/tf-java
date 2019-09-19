package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.IntNdArray;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.impl.dense.IntDenseNdArray;
import org.tensorflow.types.family.TNumber;
import org.tensorflow.types.family.TType;

public class TString implements NdArray<String>, TType {

  public static final DataType<TString> DTYPE = new DataType<>(7, -1);
}
