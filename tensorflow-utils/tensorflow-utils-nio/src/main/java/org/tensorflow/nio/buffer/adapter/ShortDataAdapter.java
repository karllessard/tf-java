package org.tensorflow.nio.buffer.adapter;

import org.tensorflow.nio.buffer.ByteDataBuffer;

/**
 * Converts a boolean to/from bytes
 */
public interface ShortDataAdapter extends DataAdapter<Short> {

  /**
   * Writes a short as bytes to the given buffer at its current position.
   *
   * @param buffer buffer that receives the value as bytes
   * @param value value
   */
  void writeShort(ByteDataBuffer buffer, short value);

  /**
   * Reads a short as bytes from the given buffer at its current position.
   *
   * @param buffer buffer that supplies the value as bytes
   * @return value
   */
  short readShort(ByteDataBuffer buffer);

  @Override
  default void writeValue(ByteDataBuffer buffer, Short value) {
    writeShort(buffer, value);
  }

  @Override
  default Short readValue(ByteDataBuffer buffer) {
    return readShort(buffer);
  }
}
