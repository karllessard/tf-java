package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.internal.buffer.BooleanTensorBuffer;
import org.tensorflow.internal.buffer.ByteTensorBuffer;
import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.BooleanDataBuffer;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffers;
import org.tensorflow.nio.buffer.adapter.BooleanDataAdapter;
import org.tensorflow.nio.nd.BooleanNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.BooleanDenseNdArray;
import org.tensorflow.types.family.TType;

public interface TBool extends BooleanNdArray, TType {

  DataType<TBool> DTYPE = DataType.create("BOOL", 10, 1, TBoolImpl::mapTensor);

  static Tensor<TBool> scalar(boolean value) {
    Tensor<TBool> t = tensorOfShape();
    t.data().setBoolean(value);
    return t;
  }

  static Tensor<TBool> vector(boolean... values) {
    Tensor<TBool> t = tensorOfShape(values.length);
    t.data().write(values);
    return t;
  }

  static Tensor<TBool> tensor(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }

  static Tensor<TBool> tensorOfShape(long... dimensionSizes) {
    return Tensor.allocate(DTYPE, Shape.make(dimensionSizes));
  }
}

class TBoolImpl extends BooleanDenseNdArray implements TBool {

  static TBool mapTensor(TF_Tensor nativeTensor, Shape shape) {
    return new TBoolImpl(BooleanTensorBuffer.map(nativeTensor), shape);
  }

  private TBoolImpl(BooleanDataBuffer buffer, Shape shape) {
    super(buffer, shape);
  }
}
