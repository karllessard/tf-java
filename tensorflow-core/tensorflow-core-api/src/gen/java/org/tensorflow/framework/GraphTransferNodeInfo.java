// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/framework/graph_transfer_info.proto

package org.tensorflow.framework;

/**
 * Protobuf type {@code tensorflow.GraphTransferNodeInfo}
 */
public  final class GraphTransferNodeInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.GraphTransferNodeInfo)
    GraphTransferNodeInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GraphTransferNodeInfo.newBuilder() to construct.
  private GraphTransferNodeInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GraphTransferNodeInfo() {
    name_ = "";
    typeName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GraphTransferNodeInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GraphTransferNodeInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 16: {

            nodeId_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            typeName_ = s;
            break;
          }
          case 32: {

            socOpId_ = input.readInt32();
            break;
          }
          case 40: {

            paddingId_ = input.readInt32();
            break;
          }
          case 48: {

            inputCount_ = input.readInt32();
            break;
          }
          case 56: {

            outputCount_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.framework.GraphTransferInfoProto.internal_static_tensorflow_GraphTransferNodeInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.framework.GraphTransferInfoProto.internal_static_tensorflow_GraphTransferNodeInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.framework.GraphTransferNodeInfo.class, org.tensorflow.framework.GraphTransferNodeInfo.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NODE_ID_FIELD_NUMBER = 2;
  private int nodeId_;
  /**
   * <code>int32 node_id = 2;</code>
   */
  public int getNodeId() {
    return nodeId_;
  }

  public static final int TYPE_NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object typeName_;
  /**
   * <code>string type_name = 3;</code>
   */
  public java.lang.String getTypeName() {
    java.lang.Object ref = typeName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      typeName_ = s;
      return s;
    }
  }
  /**
   * <code>string type_name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTypeNameBytes() {
    java.lang.Object ref = typeName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      typeName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SOC_OP_ID_FIELD_NUMBER = 4;
  private int socOpId_;
  /**
   * <code>int32 soc_op_id = 4;</code>
   */
  public int getSocOpId() {
    return socOpId_;
  }

  public static final int PADDING_ID_FIELD_NUMBER = 5;
  private int paddingId_;
  /**
   * <code>int32 padding_id = 5;</code>
   */
  public int getPaddingId() {
    return paddingId_;
  }

  public static final int INPUT_COUNT_FIELD_NUMBER = 6;
  private int inputCount_;
  /**
   * <code>int32 input_count = 6;</code>
   */
  public int getInputCount() {
    return inputCount_;
  }

  public static final int OUTPUT_COUNT_FIELD_NUMBER = 7;
  private int outputCount_;
  /**
   * <code>int32 output_count = 7;</code>
   */
  public int getOutputCount() {
    return outputCount_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (nodeId_ != 0) {
      output.writeInt32(2, nodeId_);
    }
    if (!getTypeNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, typeName_);
    }
    if (socOpId_ != 0) {
      output.writeInt32(4, socOpId_);
    }
    if (paddingId_ != 0) {
      output.writeInt32(5, paddingId_);
    }
    if (inputCount_ != 0) {
      output.writeInt32(6, inputCount_);
    }
    if (outputCount_ != 0) {
      output.writeInt32(7, outputCount_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (nodeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, nodeId_);
    }
    if (!getTypeNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, typeName_);
    }
    if (socOpId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, socOpId_);
    }
    if (paddingId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, paddingId_);
    }
    if (inputCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, inputCount_);
    }
    if (outputCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, outputCount_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.tensorflow.framework.GraphTransferNodeInfo)) {
      return super.equals(obj);
    }
    org.tensorflow.framework.GraphTransferNodeInfo other = (org.tensorflow.framework.GraphTransferNodeInfo) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (getNodeId()
        != other.getNodeId()) return false;
    if (!getTypeName()
        .equals(other.getTypeName())) return false;
    if (getSocOpId()
        != other.getSocOpId()) return false;
    if (getPaddingId()
        != other.getPaddingId()) return false;
    if (getInputCount()
        != other.getInputCount()) return false;
    if (getOutputCount()
        != other.getOutputCount()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + NODE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getNodeId();
    hash = (37 * hash) + TYPE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getTypeName().hashCode();
    hash = (37 * hash) + SOC_OP_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSocOpId();
    hash = (37 * hash) + PADDING_ID_FIELD_NUMBER;
    hash = (53 * hash) + getPaddingId();
    hash = (37 * hash) + INPUT_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getInputCount();
    hash = (37 * hash) + OUTPUT_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getOutputCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.GraphTransferNodeInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.tensorflow.framework.GraphTransferNodeInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code tensorflow.GraphTransferNodeInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.GraphTransferNodeInfo)
      org.tensorflow.framework.GraphTransferNodeInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.framework.GraphTransferInfoProto.internal_static_tensorflow_GraphTransferNodeInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.framework.GraphTransferInfoProto.internal_static_tensorflow_GraphTransferNodeInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.framework.GraphTransferNodeInfo.class, org.tensorflow.framework.GraphTransferNodeInfo.Builder.class);
    }

    // Construct using org.tensorflow.framework.GraphTransferNodeInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      name_ = "";

      nodeId_ = 0;

      typeName_ = "";

      socOpId_ = 0;

      paddingId_ = 0;

      inputCount_ = 0;

      outputCount_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.framework.GraphTransferInfoProto.internal_static_tensorflow_GraphTransferNodeInfo_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.framework.GraphTransferNodeInfo getDefaultInstanceForType() {
      return org.tensorflow.framework.GraphTransferNodeInfo.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.framework.GraphTransferNodeInfo build() {
      org.tensorflow.framework.GraphTransferNodeInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.framework.GraphTransferNodeInfo buildPartial() {
      org.tensorflow.framework.GraphTransferNodeInfo result = new org.tensorflow.framework.GraphTransferNodeInfo(this);
      result.name_ = name_;
      result.nodeId_ = nodeId_;
      result.typeName_ = typeName_;
      result.socOpId_ = socOpId_;
      result.paddingId_ = paddingId_;
      result.inputCount_ = inputCount_;
      result.outputCount_ = outputCount_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.tensorflow.framework.GraphTransferNodeInfo) {
        return mergeFrom((org.tensorflow.framework.GraphTransferNodeInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.framework.GraphTransferNodeInfo other) {
      if (other == org.tensorflow.framework.GraphTransferNodeInfo.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getNodeId() != 0) {
        setNodeId(other.getNodeId());
      }
      if (!other.getTypeName().isEmpty()) {
        typeName_ = other.typeName_;
        onChanged();
      }
      if (other.getSocOpId() != 0) {
        setSocOpId(other.getSocOpId());
      }
      if (other.getPaddingId() != 0) {
        setPaddingId(other.getPaddingId());
      }
      if (other.getInputCount() != 0) {
        setInputCount(other.getInputCount());
      }
      if (other.getOutputCount() != 0) {
        setOutputCount(other.getOutputCount());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.tensorflow.framework.GraphTransferNodeInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.framework.GraphTransferNodeInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private int nodeId_ ;
    /**
     * <code>int32 node_id = 2;</code>
     */
    public int getNodeId() {
      return nodeId_;
    }
    /**
     * <code>int32 node_id = 2;</code>
     */
    public Builder setNodeId(int value) {
      
      nodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 node_id = 2;</code>
     */
    public Builder clearNodeId() {
      
      nodeId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object typeName_ = "";
    /**
     * <code>string type_name = 3;</code>
     */
    public java.lang.String getTypeName() {
      java.lang.Object ref = typeName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        typeName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type_name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTypeNameBytes() {
      java.lang.Object ref = typeName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        typeName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type_name = 3;</code>
     */
    public Builder setTypeName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      typeName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type_name = 3;</code>
     */
    public Builder clearTypeName() {
      
      typeName_ = getDefaultInstance().getTypeName();
      onChanged();
      return this;
    }
    /**
     * <code>string type_name = 3;</code>
     */
    public Builder setTypeNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      typeName_ = value;
      onChanged();
      return this;
    }

    private int socOpId_ ;
    /**
     * <code>int32 soc_op_id = 4;</code>
     */
    public int getSocOpId() {
      return socOpId_;
    }
    /**
     * <code>int32 soc_op_id = 4;</code>
     */
    public Builder setSocOpId(int value) {
      
      socOpId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 soc_op_id = 4;</code>
     */
    public Builder clearSocOpId() {
      
      socOpId_ = 0;
      onChanged();
      return this;
    }

    private int paddingId_ ;
    /**
     * <code>int32 padding_id = 5;</code>
     */
    public int getPaddingId() {
      return paddingId_;
    }
    /**
     * <code>int32 padding_id = 5;</code>
     */
    public Builder setPaddingId(int value) {
      
      paddingId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 padding_id = 5;</code>
     */
    public Builder clearPaddingId() {
      
      paddingId_ = 0;
      onChanged();
      return this;
    }

    private int inputCount_ ;
    /**
     * <code>int32 input_count = 6;</code>
     */
    public int getInputCount() {
      return inputCount_;
    }
    /**
     * <code>int32 input_count = 6;</code>
     */
    public Builder setInputCount(int value) {
      
      inputCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 input_count = 6;</code>
     */
    public Builder clearInputCount() {
      
      inputCount_ = 0;
      onChanged();
      return this;
    }

    private int outputCount_ ;
    /**
     * <code>int32 output_count = 7;</code>
     */
    public int getOutputCount() {
      return outputCount_;
    }
    /**
     * <code>int32 output_count = 7;</code>
     */
    public Builder setOutputCount(int value) {
      
      outputCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 output_count = 7;</code>
     */
    public Builder clearOutputCount() {
      
      outputCount_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:tensorflow.GraphTransferNodeInfo)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.GraphTransferNodeInfo)
  private static final org.tensorflow.framework.GraphTransferNodeInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.framework.GraphTransferNodeInfo();
  }

  public static org.tensorflow.framework.GraphTransferNodeInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GraphTransferNodeInfo>
      PARSER = new com.google.protobuf.AbstractParser<GraphTransferNodeInfo>() {
    @java.lang.Override
    public GraphTransferNodeInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GraphTransferNodeInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GraphTransferNodeInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GraphTransferNodeInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.framework.GraphTransferNodeInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

