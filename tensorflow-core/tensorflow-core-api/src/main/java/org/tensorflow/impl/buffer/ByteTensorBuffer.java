package org.tensorflow.impl.buffer;

import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class ByteTensorBuffer extends AbstractUnsafeBuffer<Byte, ByteDataBuffer>
    implements ByteDataBuffer {

  public static ByteDataBuffer map(TF_Tensor nativeTensor) {
    return new ByteTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public byte getByte() {
    Validator.get(this);
    return unsafe.getByte(nextAddress());
  }

  @Override
  public byte getByte(long index) {
    Validator.getArgs(this, index);
    return unsafe.getByte(addressAt(index));
  }

  @Override
  public ByteDataBuffer get(byte[] dst, int offset, int length) {
    Validator.getArrayArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, remaining());
    unsafe.copyMemory(null, currentAddress(), dst, arrayOffset(offset), effectiveLength);
    movePosition(effectiveLength);
    return this;
  }

  @Override
  public ByteDataBuffer putByte(byte value) {
    Validator.put(this);
    unsafe.putByte(nextAddress(), value);
    return this;
  }

  @Override
  public ByteDataBuffer putByte(long index, byte value) {
    Validator.putArgs(this, index);
    unsafe.putByte(addressAt(index), value);
    return this;
  }

  @Override
  public ByteDataBuffer put(byte[] src, int offset, int length) {
    Validator.putArrayArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, currentAddress(), length);
    movePosition(length);
    return this;
  }

  @Override
  public ByteDataBuffer duplicate() {
    return new ByteTensorBuffer(memory, isReadOnly(), position(), limit());
  }

  ByteTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(BYTE_INFO, memory, readOnly);
  }

  private ByteTensorBuffer(TensorMemory memory, boolean readOnly, long position, long limit) {
    super(BYTE_INFO, memory, readOnly, position, limit);
  }

  private static final TypeInfo BYTE_INFO = new TypeInfo(
    Byte.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
