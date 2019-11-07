/*
 Copyright 2019 The TensorFlow Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 =======================================================================
 */
package org.tensorflow.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.tensorflow.nio.buffer.adapter.BooleanDataAdapter;
import org.tensorflow.nio.buffer.adapter.DataAdapter;
import org.tensorflow.nio.buffer.adapter.DoubleDataAdapter;
import org.tensorflow.nio.buffer.adapter.FloatDataAdapter;
import org.tensorflow.nio.buffer.adapter.IntDataAdapter;
import org.tensorflow.nio.buffer.adapter.LongDataAdapter;
import org.tensorflow.nio.buffer.adapter.ShortDataAdapter;
import org.tensorflow.nio.buffer.impl.jdk.ByteJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.DoubleJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.FloatJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.IntJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.LongJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.jdk.ShortJdkDataBuffer;
import org.tensorflow.nio.buffer.impl.join.BooleanJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.ByteJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.DoubleJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.FloatJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.IntJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.JoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.LongJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.join.ShortJoinDataBuffer;
import org.tensorflow.nio.buffer.impl.misc.ArrayDataBuffer;
import org.tensorflow.nio.buffer.impl.misc.BitSetDataBuffer;
import org.tensorflow.nio.buffer.impl.misc.BooleanArrayDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.BooleanVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.DoubleVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.FloatVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.IntVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.LongVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.ShortVirtualDataBuffer;
import org.tensorflow.nio.buffer.impl.virtual.VirtualDataBuffer;

/**
 * Helper class for creating {@code DataBuffer} instances.
 */
public final class DataBuffers {

  /**
   * Creates a buffer of bytes that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static ByteDataBuffer ofBytes(long capacity) {
    if (capacity > ByteJdkDataBuffer.MAX_CAPACITY) {
      return ByteJoinDataBuffer.allocate(capacity);
    }
    return ByteJdkDataBuffer.allocate(capacity);
  }

  /**
   * Wraps an array of bytes into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static ByteDataBuffer wrap(byte[] array, boolean readOnly) {
    ByteBuffer buf = ByteBuffer.wrap(array);
    return ByteJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK byte buffers into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static ByteDataBuffer wrap(ByteBuffer buf) {
    return ByteJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple byte buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static ByteDataBuffer join(ByteDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : ByteJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of longs that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static LongDataBuffer ofLongs(long capacity) {
    if (capacity > LongJdkDataBuffer.MAX_CAPACITY) {
      return LongJoinDataBuffer.allocate(capacity);
    }
    return LongJdkDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of longs that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the long values to/from bytes, allowing custom
   * representation of a long.
   *
   * @param capacity capacity of the buffer to allocate
   * @param adapter an object converting buffer data to longs
   * @return a new buffer
   */
  public static LongDataBuffer ofLongs(long capacity, LongDataAdapter adapter) {
    return toLongs(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of longs.
   *
   * <p>The provided adapter is used to create the long values to/from bytes, allowing custom
   * representation of a long integer.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to integers
   * @return a new buffer
   */
  public static LongDataBuffer toLongs(ByteDataBuffer buffer, LongDataAdapter adapter) {
    return LongVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of longs into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static LongDataBuffer wrap(long[] array, boolean readOnly) {
    LongBuffer buf = LongBuffer.wrap(array);
    return LongJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK long buffer into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static LongDataBuffer wrap(LongBuffer buf) {
    return LongJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple long buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static LongDataBuffer join(LongDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : LongJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of integers that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static IntDataBuffer ofInts(long capacity) {
    if (capacity > IntJdkDataBuffer.MAX_CAPACITY) {
      return IntJoinDataBuffer.allocate(capacity);
    }
    return IntJdkDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of integers that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the integer values to/from bytes, allowing custom
   * representation of an integer.
   *
   * @param capacity capacity of the buffer to allocate
   * @param adapter an object converting buffer data to integers
   * @return a new buffer
   */
  public static IntDataBuffer ofInts(long capacity, IntDataAdapter adapter) {
    return toInts(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of integers.
   *
   * <p>The provided adapter is used to create the integer values to/from bytes, allowing custom
   * representation of a integer.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to integers
   * @return a new buffer
   */
  public static IntDataBuffer toInts(ByteDataBuffer buffer, IntDataAdapter adapter) {
    return IntVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of integers into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static IntDataBuffer wrap(int[] array, boolean readOnly) {
    IntBuffer buf = IntBuffer.wrap(array);
    return IntJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK integer buffer into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static IntDataBuffer wrap(IntBuffer buf) {
    return IntJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple integer buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static IntDataBuffer join(IntDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : IntJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of shorts that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static ShortDataBuffer ofShorts(long capacity) {
    if (capacity > ShortJdkDataBuffer.MAX_CAPACITY) {
      return ShortJoinDataBuffer.allocate(capacity);
    }
    return ShortJdkDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of shorts that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the short values to/from bytes, allowing custom
   * representation of a short.
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static ShortDataBuffer ofShorts(long capacity, ShortDataAdapter adapter) {
    return toShorts(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of shorts.
   *
   * <p>The provided adapter is used to create the short values to/from bytes, allowing custom
   * representation of a short.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to shorts
   * @return a new buffer
   */
  public static ShortDataBuffer toShorts(ByteDataBuffer buffer, ShortDataAdapter adapter) {
    return ShortVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of shorts into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static ShortDataBuffer wrap(short[] array, boolean readOnly) {
    ShortBuffer buf = ShortBuffer.wrap(array);
    return ShortJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK short buffer into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static ShortDataBuffer wrap(ShortBuffer buf) {
    return ShortJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple short buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static ShortDataBuffer join(ShortDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : ShortJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of doubles that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static DoubleDataBuffer ofDoubles(long capacity) {
    if (capacity > DoubleJdkDataBuffer.MAX_CAPACITY) {
      return DoubleJoinDataBuffer.allocate(capacity);
    }
    return DoubleJdkDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of doubles that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the double values to/from bytes, allowing custom
   * representation of a double.
   *
   * @param capacity capacity of the buffer to allocate
   * @param adapter an object converting buffer data to doubles
   * @return a new buffer
   */
  public static DoubleDataBuffer ofDoubles(long capacity, DoubleDataAdapter adapter) {
    return toDoubles(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of doubles.
   *
   * <p>The provided adapter is used to create the double values to/from bytes, allowing custom
   * representation of a double.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to doubles
   * @return a new buffer
   */
  public static DoubleDataBuffer toDoubles(ByteDataBuffer buffer, DoubleDataAdapter adapter) {
    return DoubleVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of doubles into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static DoubleDataBuffer wrap(double[] array, boolean readOnly) {
    DoubleBuffer buf = DoubleBuffer.wrap(array);
    return DoubleJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK double buffer into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static DoubleDataBuffer wrap(DoubleBuffer buf) {
    return DoubleJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple double buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */

  public static DoubleDataBuffer join(DoubleDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : DoubleJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of floats that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static FloatDataBuffer ofFloats(long capacity) {
    if (capacity > FloatJdkDataBuffer.MAX_CAPACITY) {
      return FloatJoinDataBuffer.allocate(capacity);
    }
    return FloatJdkDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of floats that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the float values to/from bytes, allowing custom
   * representation of a float.
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static FloatDataBuffer ofFloats(long capacity, FloatDataAdapter adapter) {
    return toFloats(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of floats.
   *
   * <p>The provided adapter is used to create the float values to/from bytes, allowing custom
   * representation of a float.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to floats
   * @return a new buffer
   */
  public static FloatDataBuffer toFloats(ByteDataBuffer buffer, FloatDataAdapter adapter) {
    return FloatVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of floats into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static FloatDataBuffer wrap(float[] array, boolean readOnly) {
    FloatBuffer buf = FloatBuffer.wrap(array);
    return FloatJdkDataBuffer.wrap(readOnly ? buf.asReadOnlyBuffer() : buf);
  }

  /**
   * Wraps a JDK float buffer into a data buffer.
   *
   * @param buf buffer to wrap
   * @return a new buffer
   */
  public static FloatDataBuffer wrap(FloatBuffer buf) {
    return FloatJdkDataBuffer.wrap(buf);
  }

  /**
   * Join multiple float buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static FloatDataBuffer join(FloatDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : FloatJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of booleans that can store up to {@code capacity} values
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static BooleanDataBuffer ofBooleans(long capacity) {
    if (capacity > BitSetDataBuffer.MAX_CAPACITY) {
      return BooleanJoinDataBuffer.allocate(capacity);
    }
    return BitSetDataBuffer.allocate(capacity);
  }

  /**
   * Creates a virtual buffer of booleans that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the boolean values to/from bytes, allowing custom
   * representation of a boolean.
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static BooleanDataBuffer ofBooleans(long capacity, BooleanDataAdapter adapter) {
    return toBooleans(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer of booleans.
   *
   * <p>The provided adapter is used to create the boolean values to/from bytes, allowing custom
   * representation of a boolean.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to booleans
   * @return a new buffer
   */
  public static BooleanDataBuffer toBooleans(ByteDataBuffer buffer, BooleanDataAdapter adapter) {
    return BooleanVirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of booleans into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static BooleanDataBuffer wrap(boolean[] array, boolean readOnly) {
    return BooleanArrayDataBuffer.wrap(array, readOnly);
  }

  /**
   * Join multiple boolean buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  public static BooleanDataBuffer join(BooleanDataBuffer... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : BooleanJoinDataBuffer.join(buffers);
  }

  /**
   * Creates a buffer of objects of type {@code clazz` that can store up to `capacity} values
   *
   * @param clazz the type of object stored in this buffer
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static <T> DataBuffer<T> of(Class<T> clazz, long capacity) {
    if (capacity > ArrayDataBuffer.MAX_CAPACITY) {
      return JoinDataBuffer.allocate(clazz, capacity);
    }
    return ArrayDataBuffer.allocate(clazz, capacity);
  }

  /**
   * Creates a virtual buffer that can store up to {@code capacity} values.
   *
   * <p>The provided adapter is used to create the values to/from bytes, allowing custom
   * representation of this buffer type.
   *
   * @param capacity capacity of the buffer to allocate
   * @return a new buffer
   */
  public static <T> DataBuffer<T> of(long capacity, DataAdapter<T> adapter) {
    return to(ofBytes(capacity * adapter.sizeInBytes()), adapter);
  }

  /**
   * Adapt a physical buffer to a virtual buffer.
   *
   * <p>The provided adapter is used to create the values to/from bytes, allowing custom
   * representation of this buffer type.
   *
   * @param buffer the buffer to adapt
   * @param adapter an object converting buffer data to booleans
   * @return a new buffer
   */
  public static <T> DataBuffer<T> to(ByteDataBuffer buffer, DataAdapter<T> adapter) {
    return VirtualDataBuffer.create(buffer, adapter);
  }

  /**
   * Wraps an array of objects into a data buffer.
   *
   * @param array array to wrap
   * @param readOnly true if the buffer created must be read-only
   * @return a new buffer
   */
  public static <T> DataBuffer<T> wrap(T[] array, boolean readOnly) {
    return ArrayDataBuffer.wrap(array, readOnly);
  }

  /**
   * Join multiple buffers together to create a large buffer indexable with 64-bits values.
   *
   * @param buffers buffers to join
   * @return a potentially large buffer
   */
  @SafeVarargs
  public static <T> DataBuffer<T> join(DataBuffer<T>... buffers) {
    if (buffers == null) {
      return null;
    }
    return (buffers.length == 1) ? buffers[0] : JoinDataBuffer.join(buffers);
  }
}
