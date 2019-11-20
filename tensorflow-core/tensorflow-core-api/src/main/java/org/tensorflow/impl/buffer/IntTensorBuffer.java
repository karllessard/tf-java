package org.tensorflow.impl.buffer;

import java.util.stream.IntStream;
import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.IntDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class IntTensorBuffer extends AbstractUnsafeBuffer<Integer, IntDataBuffer>
    implements IntDataBuffer {

  public static IntDataBuffer map(TF_Tensor nativeTensor) {
    return new IntTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public IntStream intStream() {
    return null; // TODO!
  }

  @Override
  public int getInt(long index) {
    Validator.getArgs(this, index);
    return unsafe.getInt(addressAt(index));
  }

  @Override
  public IntDataBuffer setInt(int value, long index) {
    Validator.putArgs(this, index);
    unsafe.putInt(addressAt(index), value);
    return this;
  }

  @Override
  public IntDataBuffer read(int[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, size());
    unsafe.copyMemory(null, 0, dst, arrayOffset(offset), effectiveLength);
    return this;
  }

  @Override
  public IntDataBuffer write(int[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, 0, length);
    return this;
  }

  @Override
  public IntDataBuffer offset(long index) {
    return new IntTensorBuffer(memory.segment(index, size() - index), isReadOnly());
  }

  @Override
  public IntDataBuffer narrow(long size) {
    return new IntTensorBuffer(memory.segment(0, size), isReadOnly());
  }

  IntTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(TYPE_INFO, memory, readOnly);
  }

  private static final TypeInfo TYPE_INFO = new TypeInfo(
      Integer.BYTES,
      unsafe.arrayBaseOffset(int[].class),
      unsafe.arrayIndexScale(int[].class)
  );
}
