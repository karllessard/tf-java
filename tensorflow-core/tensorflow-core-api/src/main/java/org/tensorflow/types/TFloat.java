package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.impl.buffer.FloatTensorBuffer;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.nd.FloatNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.FloatDenseNdArray;
import org.tensorflow.types.family.TDecimal;

public interface TFloat extends FloatNdArray, TDecimal {

  DataType<TFloat> DTYPE = DataType.create("FLOAT", 1, 4, TFloatImpl::mapTensor);

  static Tensor<TFloat> scalar(float value) {
    Tensor<TFloat> t = tensorOfShape();
    t.data().setFloat(value);
    return t;
  }

  static Tensor<TFloat> vector(float... values) {
    Tensor<TFloat> t = tensorOfShape(values.length);
    t.data().write(values);
    return t;
  }

  static Tensor<TFloat> tensor(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }

  static Tensor<TFloat> tensorOfShape(long... dimensionSizes) {
    return Tensor.allocate(DTYPE, Shape.make(dimensionSizes));
  }
}

class TFloatImpl extends FloatDenseNdArray implements TFloat {

  static TFloat mapTensor(TF_Tensor nativeTensor, Shape shape) {
    return new TFloatImpl(FloatTensorBuffer.map(nativeTensor), shape);
  }

  private TFloatImpl(FloatDataBuffer buffer, Shape shape) {
    super(buffer, shape);
  }
}

