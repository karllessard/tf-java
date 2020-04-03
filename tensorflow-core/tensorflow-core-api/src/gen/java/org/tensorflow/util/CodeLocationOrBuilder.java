// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/debug_event.proto

package org.tensorflow.util;

public interface CodeLocationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.CodeLocation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Host name on which the source files are located.
   * </pre>
   *
   * <code>string host_name = 1;</code>
   */
  java.lang.String getHostName();
  /**
   * <pre>
   * Host name on which the source files are located.
   * </pre>
   *
   * <code>string host_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getHostNameBytes();

  /**
   * <pre>
   * ID to a stack frame, each of which is pointed to
   * by a unique ID. The ordering of the frames is consistent with Python's
   * `traceback.extract_tb()`.
   * </pre>
   *
   * <code>repeated string stack_frame_ids = 2;</code>
   */
  java.util.List<java.lang.String>
      getStackFrameIdsList();
  /**
   * <pre>
   * ID to a stack frame, each of which is pointed to
   * by a unique ID. The ordering of the frames is consistent with Python's
   * `traceback.extract_tb()`.
   * </pre>
   *
   * <code>repeated string stack_frame_ids = 2;</code>
   */
  int getStackFrameIdsCount();
  /**
   * <pre>
   * ID to a stack frame, each of which is pointed to
   * by a unique ID. The ordering of the frames is consistent with Python's
   * `traceback.extract_tb()`.
   * </pre>
   *
   * <code>repeated string stack_frame_ids = 2;</code>
   */
  java.lang.String getStackFrameIds(int index);
  /**
   * <pre>
   * ID to a stack frame, each of which is pointed to
   * by a unique ID. The ordering of the frames is consistent with Python's
   * `traceback.extract_tb()`.
   * </pre>
   *
   * <code>repeated string stack_frame_ids = 2;</code>
   */
  com.google.protobuf.ByteString
      getStackFrameIdsBytes(int index);
}
