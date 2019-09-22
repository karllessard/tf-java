package org.tensorflow.types;

import java.nio.ByteBuffer;
import org.tensorflow.DataType;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer.ValueMapper;
import org.tensorflow.nio.nd.NdArray;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.impl.dense.DenseNdArray;
import org.tensorflow.types.family.TType;

public interface TBool extends NdArray<Boolean>, TType {
  DataType<TBool> DTYPE = new DataType<>(10, 1, TBoolImpl::new);
}

class TBoolImpl extends DenseNdArray<Boolean> implements TBool {

  private static class BooleanMapper implements ValueMapper<Boolean> {

    @Override
    public void writeValue(ByteDataBuffer physicalBuffer, Boolean value) {
      physicalBuffer.put((byte)(value ? 1 : 0));
    }

    @Override
    public Boolean readValue(ByteDataBuffer physicalBuffer) {
      return physicalBuffer.get() > 0;
    }

    @Override
    public int sizeInBytes() {
      return TBool.DTYPE.byteSize();
    }
  }

  TBoolImpl(ByteBuffer[] tensorBuffers, Shape shape) {
    super(BufferUtils.toDataBuffer(tensorBuffers, new BooleanMapper()), shape);
  }
}
