// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/meta_graph.proto

package org.tensorflow.proto.framework;

public interface AssetFileDefOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.AssetFileDef)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The tensor to bind the asset filename to.
   * </pre>
   *
   * <code>.tensorflow.TensorInfo tensor_info = 1;</code>
   */
  boolean hasTensorInfo();
  /**
   * <pre>
   * The tensor to bind the asset filename to.
   * </pre>
   *
   * <code>.tensorflow.TensorInfo tensor_info = 1;</code>
   */
  org.tensorflow.proto.framework.TensorInfo getTensorInfo();
  /**
   * <pre>
   * The tensor to bind the asset filename to.
   * </pre>
   *
   * <code>.tensorflow.TensorInfo tensor_info = 1;</code>
   */
  org.tensorflow.proto.framework.TensorInfoOrBuilder getTensorInfoOrBuilder();

  /**
   * <pre>
   * The filename within an assets directory. Note: does not include the path
   * prefix, i.e. directories. For an asset at /tmp/path/vocab.txt, the filename
   * would be "vocab.txt".
   * </pre>
   *
   * <code>string filename = 2;</code>
   */
  java.lang.String getFilename();
  /**
   * <pre>
   * The filename within an assets directory. Note: does not include the path
   * prefix, i.e. directories. For an asset at /tmp/path/vocab.txt, the filename
   * would be "vocab.txt".
   * </pre>
   *
   * <code>string filename = 2;</code>
   */
  com.google.protobuf.ByteString
      getFilenameBytes();
}
