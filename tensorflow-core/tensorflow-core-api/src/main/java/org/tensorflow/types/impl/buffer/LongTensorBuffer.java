package org.tensorflow.types.impl.buffer;

import java.util.stream.LongStream;
import org.tensorflow.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class LongTensorBuffer extends AbstractUnsafeBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

  public static LongDataBuffer map(TF_Tensor nativeTensor) {
    return new LongTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public LongStream longStream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public long getLong() {
    Validator.get(this);
    return unsafe.getLong(nextAddress());
  }

  @Override
  public long getLong(long index) {
    Validator.getArgs(this, index);
    return unsafe.getLong(addressAt(index));
  }

  @Override
  public LongDataBuffer get(long[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, remaining());
    unsafe.copyMemory(null, currentAddress(), dst, arrayOffset(offset), effectiveLength);
    movePosition(effectiveLength);
    return this;
  }

  @Override
  public LongDataBuffer putLong(long value) {
    Validator.put(this);
    unsafe.putLong(nextAddress(), value);
    return this;
  }

  @Override
  public LongDataBuffer putLong(long index, long value) {
    Validator.putArgs(this, index);
    unsafe.putLong(addressAt(index), value);
    return this;
  }

  @Override
  public LongDataBuffer put(long[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, currentAddress(), length);
    movePosition(length);
    return this;
  }

  @Override
  public LongDataBuffer duplicate() {
    return new LongTensorBuffer(memory, isReadOnly(), position(), limit());
  }

  LongTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(LONG_INFO, memory, readOnly);
  }

  private LongTensorBuffer(TensorMemory memory, boolean readOnly, long position, long limit) {
    super(LONG_INFO, memory, readOnly, position, limit);
  }

  private static final TypeInfo LONG_INFO = new TypeInfo(
    Long.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
