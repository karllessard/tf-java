package org.tensorflow.impl.buffer;

import java.util.stream.LongStream;
import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class LongTensorBuffer extends AbstractUnsafeBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

  public static LongDataBuffer map(TF_Tensor nativeTensor) {
    return new LongTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public LongStream longStream() {
    return null; // TODO!
  }

  @Override
  public long getLong(long index) {
    Validator.getArgs(this, index);
    return unsafe.getLong(addressAt(index));
  }

  @Override
  public LongDataBuffer setLong(long value, long index) {
    Validator.putArgs(this, index);
    unsafe.putLong(addressAt(index), value);
    return this;
  }

  @Override
  public LongDataBuffer read(long[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, size());
    unsafe.copyMemory(null, 0, dst, arrayOffset(offset), effectiveLength);
    return this;
  }

  @Override
  public LongDataBuffer write(long[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, 0, length);
    return this;
  }

  @Override
  public LongDataBuffer offset(long index) {
    return new LongTensorBuffer(memory.segment(index, size() - index), isReadOnly());
  }

  @Override
  public LongDataBuffer narrow(long size) {
    return new LongTensorBuffer(memory.segment(0, size), isReadOnly());
  }

  LongTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(TYPE_INFO, memory, readOnly);
  }

  private static final TypeInfo TYPE_INFO = new TypeInfo(
      Long.BYTES,
      unsafe.arrayBaseOffset(int[].class),
      unsafe.arrayIndexScale(int[].class)
  );
}
