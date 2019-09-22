package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.types.family.TType;

public interface TString extends NdArray<String>, TType {
  DataType<TString> DTYPE = new DataType<>(7, -1, (b, s) -> { throw new UnsupportedOperationException(); }); // TODO!
}

