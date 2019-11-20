package org.tensorflow.impl.buffer;

import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.FloatDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class FloatTensorBuffer extends AbstractUnsafeBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

  public static FloatDataBuffer map(TF_Tensor nativeTensor) {
    return new FloatTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public float getFloat(long index) {
    Validator.getArgs(this, index);
    return unsafe.getFloat(addressAt(index));
  }

  @Override
  public FloatDataBuffer setFloat(float value, long index) {
    Validator.putArgs(this, index);
    unsafe.putFloat(addressAt(index), value);
    return this;
  }

  @Override
  public FloatDataBuffer read(float[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, size());
    unsafe.copyMemory(null, 0, dst, arrayOffset(offset), effectiveLength);
    return this;
  }

  @Override
  public FloatDataBuffer write(float[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, 0, length);
    return this;
  }

  @Override
  public FloatDataBuffer offset(long index) {
    return new FloatTensorBuffer(memory.segment(index, size() - index), isReadOnly());
  }

  @Override
  public FloatDataBuffer narrow(long size) {
    return new FloatTensorBuffer(memory.segment(0, size), isReadOnly());
  }

  FloatTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(TYPE_INFO, memory, readOnly);
  }

  private static final TypeInfo TYPE_INFO = new TypeInfo(
      Float.BYTES,
      unsafe.arrayBaseOffset(int[].class),
      unsafe.arrayIndexScale(int[].class)
  );
}
