// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/util/memmapped_file_system.proto

package org.tensorflow.util;

public interface MemmappedFileSystemDirectoryElementOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.MemmappedFileSystemDirectoryElement)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 offset = 1;</code>
   */
  long getOffset();

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>uint64 length = 3;</code>
   */
  long getLength();
}
