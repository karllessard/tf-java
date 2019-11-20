package org.tensorflow.impl.buffer;

import com.google.common.base.Charsets;
import java.util.stream.Stream;
import org.tensorflow.impl.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;

public class StringTensorBuffer extends AbstractDataBuffer<String> {

  public static StringTensorBuffer map(TF_Tensor nativeTensor, long numElements) {
    TensorMemory memory = TensorMemory.of(nativeTensor);
    // Keep offset and data buffers as writeable, in case we need to set the initial data of the
    // tensor, but force read-only at this string buffer level (call duplicateForInit() to get
    // a writeable copy of it)
    LongTensorBuffer offsets = new LongTensorBuffer(memory.segment(0, numElements), false);
    ByteTensorBuffer data = new ByteTensorBuffer(memory.segment(numElements, memory.length), false);
    return new StringTensorBuffer(offsets, data, true);
  }

  @Override
  public long size() {
    return capacity;
  }

  @Override
  public String get(long index) {
    Validator.getArgs(this, index);
    long offset = offsets.get(index);
    int length = decodeVarint(data);
    byte[] bytes = new byte[length];
    data.offset(offset).read(bytes);
    return new String(bytes, Charsets.UTF_8);
  }

  @Override
  public Stream<String> stream() {
    throw new UnsupportedOperationException("Tensors of strings does not support data streaming");
  }

  @Override
  public DataBuffer<String> set(String value, long index) {
    // FIXME Only possible during the first initialization of this tensor data, must be read-only after
    /*Validator.putArgs(this, index);
    long offset = data.position();
    offsets.put(offset);
    encodeVarint(data, value.length());
    data.put(value.getBytes(Charsets.UTF_8));*/
    return this;
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  public DataBuffer<String> copyTo(DataBuffer<String> dst, long size) {
    return null;
  }

  @Override
  public DataBuffer<String> offset(long index) {
    return null;
  }

  @Override
  public DataBuffer<String> narrow(long size) {
    return null;
  }

  public StringTensorBuffer duplicateForInit() {
    return new StringTensorBuffer(offsets, data, false);
  }

  private final LongDataBuffer offsets;
  private final ByteDataBuffer data;
  private final long capacity;

  private StringTensorBuffer(LongDataBuffer offsets, ByteDataBuffer data, boolean readOnly) {
    this(offsets, data, readOnly, 0, offsets.size());
  }

  private StringTensorBuffer(LongDataBuffer offsets, ByteDataBuffer data, boolean readOnly, long position, long limit) {
    this.offsets = offsets;
    this.data = data;
    this.capacity = offsets.size();
  }

  private static void encodeVarint(ByteDataBuffer buffer, int value) {
    int v = value;
    /*while (v >= 0x80) {
      buffer.put((byte)((v & 0x7F) | 0x80));
      v >>= 7;
    }
    buffer.put((byte)v);*/
  }

  private static int decodeVarint(ByteDataBuffer buffer) {
    byte b;
    int pos = 0;
    int v = 0;
    /*do {
      b = buffer.get();
      v |= (b & 0x7F) << pos++;
    } while ((b & 0x80) != 0);*/
    return v;
  }
}
