package org.tensorflow.impl.buffer;

import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class ByteTensorBuffer extends AbstractUnsafeBuffer<Byte, ByteDataBuffer>
    implements ByteDataBuffer {

  public static ByteDataBuffer map(TF_Tensor nativeTensor) {
    return new ByteTensorBuffer(TensorMemory.of(nativeTensor), false);
  }

  @Override
  public byte getByte(long index) {
    Validator.getArgs(this, index);
    return unsafe.getByte(addressAt(index));
  }

  @Override
  public ByteDataBuffer setByte(byte value, long index) {
    Validator.putArgs(this, index);
    unsafe.putByte(addressAt(index), value);
    return this;
  }

  @Override
  public ByteDataBuffer read(byte[] dst, int offset, int length) {
    Validator.readArgs(this, dst.length, offset, length);
    long effectiveLength = Math.min(length, size());
    unsafe.copyMemory(null, 0, dst, arrayOffset(offset), effectiveLength);
    return this;
  }

  @Override
  public ByteDataBuffer write(byte[] src, int offset, int length) {
    Validator.writeArgs(this, src.length, offset, length);
    unsafe.copyMemory(src, arrayOffset(offset), null, 0, length);
    return this;
  }

  @Override
  public ByteDataBuffer offset(long index) {
    return new ByteTensorBuffer(memory.segment(index, size() - index), isReadOnly());
  }

  @Override
  public ByteDataBuffer narrow(long size) {
    return new ByteTensorBuffer(memory.segment(0, size), isReadOnly());
  }

  ByteTensorBuffer(TensorMemory memory, boolean readOnly) {
    super(BYTE_INFO, memory, readOnly);
  }

  private static final TypeInfo BYTE_INFO = new TypeInfo(
    Byte.BYTES,
    unsafe.arrayBaseOffset(int[].class),
    unsafe.arrayIndexScale(int[].class)
  );
}
