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
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  @Override
  public int getInt() {
    Validator.get(this);
    return unsafe.getInt(nextAddress());
  }

  @Override
  public int getInt(long index) {
    Validator.getArgs(this, index);
    return unsafe.getInt(addressAt(index));
  }

  @Override
  public IntDataBuffer get(int[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, remaining());
    unsafe.copyMemory(null, currentAddress(), dst, arrayOffset(offset), effectiveLength);
    movePosition(effectiveLength);
    return this;
  }

  @Override
  public IntDataBuffer putInt(int value) {
    Validator.put(this);
    unsafe.putInt(nextAddress(), value);
    return this;
  }

  @Override
  public IntDataBuffer putInt(long index, int value) {
    Validator.putArgs(this, index);
    unsafe.putInt(addressAt(index), value);
    return this;
  }

  @Override
  public IntDataBuffer put(int[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, currentAddress(), length);
    movePosition(length);
    return this;
  }

  @Override
  public IntDataBuffer duplicate() {
    return new IntTensorBuffer(memory, isReadOnly(), position(), limit());
  }

  private IntTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(INT_INFO, memory, readOnly);
  }

  private IntTensorBuffer(TensorMemory memory, boolean readOnly, long position, long limit) {
    super(INT_INFO, memory, readOnly, position, limit);
  }

  private static final TypeInfo INT_INFO = new TypeInfo(
    Integer.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
