package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.nd.FloatNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.FloatDenseNdArray;
import org.tensorflow.types.family.TDecimal;

public interface TFloat extends FloatNdArray, TDecimal {
  DataType<TFloat> DTYPE = new DataType<>(1, 4, TFloatImpl::new);
}

class TFloatImpl extends FloatDenseNdArray implements TFloat {
  TFloatImpl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toFloatDataBuffer(tensorBuffers), shape);
  }
}

