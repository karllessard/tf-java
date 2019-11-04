package org.tensorflow.types.impl.buffer;

import com.google.common.base.Charsets;
import java.nio.ReadOnlyBufferException;
import java.util.stream.Stream;
import org.tensorflow.c_api.TF_Tensor;
import org.tensorflow.nio.buffer.ByteDataBuffer;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.LongDataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractBoundDataBuffer;
import org.tensorflow.nio.buffer.impl.Validator;
import org.tensorflow.nio.nd.NdArray;

public class StringTensorBuffer extends AbstractBoundDataBuffer<String, DataBuffer<String>> implements DataBuffer<String> {

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
  public long capacity() {
    return capacity;
  }

  @Override
  public String get() {
    return get(nextPosition());
  }

  @Override
  public String get(long index) {
    Validator.getArgs(this, index);
    long offset = offsets.get(index);
    data.position(offset);
    int length = decodeVarint(data);
    byte[] bytes = new byte[length];
    data.get(bytes);
    return new String(bytes, Charsets.UTF_8);
  }

  @Override
  public Stream<String> stream() {
    throw new UnsupportedOperationException("Tensors of strings does not support data streaming");
  }

  @Override
  public DataBuffer<String> put(String value) {
    // Only possible during the first initialization of this tensor data, must be read-only after
    Validator.put(this);
    long offset = data.position();
    offsets.put(offset);
    encodeVarint(data, value.length());
    data.put(value.getBytes(Charsets.UTF_8));
    return this;
  }

  @Override
  public DataBuffer<String> put(long index, String value) {
    throw new ReadOnlyBufferException();
  }

  @Override
  public DataBuffer<String> duplicate() {
    return new StringTensorBuffer(offsets, data, isReadOnly(), position(), limit());
  }

  public StringTensorBuffer duplicateForInit() {
    return new StringTensorBuffer(offsets, data, false);
  }

  private final LongDataBuffer offsets;
  private final ByteDataBuffer data;
  private final long capacity;

  private StringTensorBuffer(LongDataBuffer offsets, ByteDataBuffer data, boolean readOnly) {
    this(offsets, data, readOnly, 0, offsets.capacity());
  }

  private StringTensorBuffer(LongDataBuffer offsets, ByteDataBuffer data, boolean readOnly, long position, long limit) {
    super(readOnly, position, limit);
    this.offsets = offsets;
    this.data = data;
    this.capacity = offsets.capacity();
  }

  private static void encodeVarint(ByteDataBuffer buffer, int value) {
    int v = value;
    while (v >= 0x80) {
      buffer.put((byte)((v & 0x7F) | 0x80));
      v >>= 7;
    }
    buffer.put((byte)v);
  }

  private static int decodeVarint(ByteDataBuffer buffer) {
    byte b;
    int pos = 0;
    int v = 0;
    do {
      b = buffer.get();
      v |= (b & 0x7F) << pos++;
    } while ((b & 0x80) != 0);
    return v;
  }
}
