package org.tensorflow.impl.buffer;

import java.lang.reflect.Field;
import java.util.stream.Stream;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.impl.AbstractBoundDataBuffer;
import sun.misc.Unsafe;

abstract class AbstractUnsafeBuffer<T, B extends DataBuffer<T>> extends AbstractBoundDataBuffer<T, B> {

  @Override
  public long capacity() {
    return memory.length / typeInfo.sizeInBytes;
  }

  @Override
  public Stream<T> stream() {
    throw new UnsupportedOperationException(); // TODO (karllessard)
  }

  static class TypeInfo {

    TypeInfo(long sizeInBytes, long arrayBaseOffset, long arrayIndexScale) {
      this.sizeInBytes = sizeInBytes;
      this.arrayBaseOffset = arrayBaseOffset;
      this.arrayIndexScale = arrayIndexScale;
    }

    final long sizeInBytes;
    final long arrayBaseOffset;
    final long arrayIndexScale;
  }

  // Important: Keep this package-private, do not expose publicly!
  static final Unsafe unsafe;

  static {
    try {
      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafe.setAccessible(true);
      unsafe = (Unsafe) theUnsafe.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  final TypeInfo typeInfo;
  final TensorMemory memory;

  long nextAddress() {
    return memory.address + nextPosition() * typeInfo.sizeInBytes;
  }

  long currentAddress() {
    return memory.address + position() * typeInfo.sizeInBytes;
  }

  long addressAt(long index) {
    return memory.address + index * typeInfo.sizeInBytes;
  }

  long arrayOffset(long offset) {
    return typeInfo.arrayBaseOffset + offset * typeInfo.arrayIndexScale;
  }

  AbstractUnsafeBuffer(TypeInfo typeInfo, TensorMemory memory, boolean readOnly) {
    this(typeInfo, memory, readOnly, 0, memory.length / typeInfo.sizeInBytes);
  }

  AbstractUnsafeBuffer(TypeInfo typeInfo, TensorMemory memory, boolean readOnly, long position, long limit) {
    super(readOnly, position, limit);
    this.typeInfo = typeInfo;
    this.memory = memory;
  }
}
