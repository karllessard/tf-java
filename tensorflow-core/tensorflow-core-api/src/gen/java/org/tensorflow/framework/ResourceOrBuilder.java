// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/trace_events.proto

package org.tensorflow.framework;

public interface ResourceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.profiler.Resource)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The name of the resource.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * The name of the resource.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * The id of the resource. Unique within a device.
   * </pre>
   *
   * <code>uint32 resource_id = 2;</code>
   */
  int getResourceId();
}
