package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.nd.DoubleNdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.DoubleDenseNdArray;
import org.tensorflow.types.family.TDecimal;

public interface TDouble extends DoubleNdArray, TDecimal {
  DataType<TDouble> DTYPE = new DataType<>(2, 8, TDoubleImpl::new);
}

class TDoubleImpl extends DoubleDenseNdArray implements TDouble {
  TDoubleImpl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toDoubleDataBuffer(tensorBuffers), shape);
  }
}
