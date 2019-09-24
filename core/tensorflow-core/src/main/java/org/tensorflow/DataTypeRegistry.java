package org.tensorflow;

import java.util.HashMap;
import java.util.Map;
import org.tensorflow.types.TBool;
import org.tensorflow.types.TDouble;
import org.tensorflow.types.TFloat;
import org.tensorflow.types.TInt32;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.TString;
import org.tensorflow.types.TUInt8;

public class DataTypeRegistry {

  public static final DataTypeRegistry INSTANCE = new DataTypeRegistry();

  public DataTypeRegistry register(DataType<?> dataType) {
    dataTypeCMap.put(dataType.c(), dataType);
    return this;
  }

  public DataTypeRegistry register(DataType<?>... dataTypes) {
    if (dataTypes != null) {
      for (int i = 0; i < dataTypes.length; ++i) {
        register(dataTypes[i]);
      }
    }
    return this;
  }

  private Map<Integer, DataType<?>> dataTypeCMap = new HashMap<>();

  private DataTypeRegistry() {
    registerDefaultDataTypes();
  }

  private void registerDefaultDataTypes() {
    register(TBool.DTYPE,
        TDouble.DTYPE,
        TFloat.DTYPE,
        TInt32.DTYPE,
        TInt64.DTYPE,
        TString.DTYPE,
        TUInt8.DTYPE);
  }

  DataType<?> fromC(int c) {
    DataType<?> dataType = dataTypeCMap.get(c);
    if (dataType == null) {
      throw new IllegalArgumentException(
          "DataType " + c + " is not recognized in Java (version " + TensorFlow.version() + ")");
    }
    return dataType;
  }
}
