package org.tensorflow.types.impl.buffer;

import org.tensorflow.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class FloatTensorBuffer extends AbstractUnsafeBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

  public static FloatDataBuffer map(TF_Tensor nativeTensor) {
    return new FloatTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public float getFloat() {
    Validator.get(this);
    return unsafe.getFloat(nextAddress());
  }

  @Override
  public float getFloat(long index) {
    Validator.getArgs(this, index);
    return unsafe.getFloat(addressAt(index));
  }

  @Override
  public FloatDataBuffer get(float[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, remaining());
    unsafe.copyMemory(null, currentAddress(), dst, arrayOffset(offset), effectiveLength);
    movePosition(effectiveLength);
    return this;
  }

  @Override
  public FloatDataBuffer putFloat(float value) {
    Validator.put(this);
    unsafe.putFloat(nextAddress(), value);
    return this;
  }

  @Override
  public FloatDataBuffer putFloat(long index, float value) {
    Validator.putArgs(this, index);
    unsafe.putFloat(addressAt(index), value);
    return this;
  }

  @Override
  public FloatDataBuffer put(float[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, currentAddress(), length);
    movePosition(length);
    return this;
  }

  @Override
  public FloatDataBuffer duplicate() {
    return new FloatTensorBuffer(memory, isReadOnly(), position(), limit());
  }

  FloatTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(FLOAT_INFO, memory, readOnly);
  }

  private FloatTensorBuffer(TensorMemory memory, boolean readOnly, long position, long limit) {
    super(FLOAT_INFO, memory, readOnly, position, limit);
  }

  private static final TypeInfo FLOAT_INFO = new TypeInfo(
    Float.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
