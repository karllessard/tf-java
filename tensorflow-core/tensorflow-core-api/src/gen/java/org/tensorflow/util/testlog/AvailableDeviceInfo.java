// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/util/test_log.proto

package org.tensorflow.util.testlog;

/**
 * <pre>
 * Matches DeviceAttributes
 * </pre>
 *
 * Protobuf type {@code tensorflow.AvailableDeviceInfo}
 */
public  final class AvailableDeviceInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.AvailableDeviceInfo)
    AvailableDeviceInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AvailableDeviceInfo.newBuilder() to construct.
  private AvailableDeviceInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AvailableDeviceInfo() {
    name_ = "";
    type_ = "";
    physicalDescription_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AvailableDeviceInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AvailableDeviceInfo(
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
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 24: {

            memoryLimit_ = input.readInt64();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            physicalDescription_ = s;
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
    return org.tensorflow.util.testlog.TestLogProtos.internal_static_tensorflow_AvailableDeviceInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.util.testlog.TestLogProtos.internal_static_tensorflow_AvailableDeviceInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.util.testlog.AvailableDeviceInfo.class, org.tensorflow.util.testlog.AvailableDeviceInfo.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <pre>
   * Device name.
   * </pre>
   *
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
   * <pre>
   * Device name.
   * </pre>
   *
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

  public static final int TYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object type_;
  /**
   * <pre>
   * Device type, e.g. 'CPU' or 'GPU'.
   * </pre>
   *
   * <code>string type = 2;</code>
   */
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Device type, e.g. 'CPU' or 'GPU'.
   * </pre>
   *
   * <code>string type = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MEMORY_LIMIT_FIELD_NUMBER = 3;
  private long memoryLimit_;
  /**
   * <pre>
   * Memory capacity in bytes.
   * </pre>
   *
   * <code>int64 memory_limit = 3;</code>
   */
  public long getMemoryLimit() {
    return memoryLimit_;
  }

  public static final int PHYSICAL_DESCRIPTION_FIELD_NUMBER = 4;
  private volatile java.lang.Object physicalDescription_;
  /**
   * <pre>
   * The physical description of this device.
   * </pre>
   *
   * <code>string physical_description = 4;</code>
   */
  public java.lang.String getPhysicalDescription() {
    java.lang.Object ref = physicalDescription_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      physicalDescription_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The physical description of this device.
   * </pre>
   *
   * <code>string physical_description = 4;</code>
   */
  public com.google.protobuf.ByteString
      getPhysicalDescriptionBytes() {
    java.lang.Object ref = physicalDescription_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      physicalDescription_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, type_);
    }
    if (memoryLimit_ != 0L) {
      output.writeInt64(3, memoryLimit_);
    }
    if (!getPhysicalDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, physicalDescription_);
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
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, type_);
    }
    if (memoryLimit_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, memoryLimit_);
    }
    if (!getPhysicalDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, physicalDescription_);
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
    if (!(obj instanceof org.tensorflow.util.testlog.AvailableDeviceInfo)) {
      return super.equals(obj);
    }
    org.tensorflow.util.testlog.AvailableDeviceInfo other = (org.tensorflow.util.testlog.AvailableDeviceInfo) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (!getType()
        .equals(other.getType())) return false;
    if (getMemoryLimit()
        != other.getMemoryLimit()) return false;
    if (!getPhysicalDescription()
        .equals(other.getPhysicalDescription())) return false;
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
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + MEMORY_LIMIT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMemoryLimit());
    hash = (37 * hash) + PHYSICAL_DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getPhysicalDescription().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.util.testlog.AvailableDeviceInfo parseFrom(
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
  public static Builder newBuilder(org.tensorflow.util.testlog.AvailableDeviceInfo prototype) {
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
   * <pre>
   * Matches DeviceAttributes
   * </pre>
   *
   * Protobuf type {@code tensorflow.AvailableDeviceInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.AvailableDeviceInfo)
      org.tensorflow.util.testlog.AvailableDeviceInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.util.testlog.TestLogProtos.internal_static_tensorflow_AvailableDeviceInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.util.testlog.TestLogProtos.internal_static_tensorflow_AvailableDeviceInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.util.testlog.AvailableDeviceInfo.class, org.tensorflow.util.testlog.AvailableDeviceInfo.Builder.class);
    }

    // Construct using org.tensorflow.util.testlog.AvailableDeviceInfo.newBuilder()
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

      type_ = "";

      memoryLimit_ = 0L;

      physicalDescription_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.util.testlog.TestLogProtos.internal_static_tensorflow_AvailableDeviceInfo_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.util.testlog.AvailableDeviceInfo getDefaultInstanceForType() {
      return org.tensorflow.util.testlog.AvailableDeviceInfo.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.util.testlog.AvailableDeviceInfo build() {
      org.tensorflow.util.testlog.AvailableDeviceInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.util.testlog.AvailableDeviceInfo buildPartial() {
      org.tensorflow.util.testlog.AvailableDeviceInfo result = new org.tensorflow.util.testlog.AvailableDeviceInfo(this);
      result.name_ = name_;
      result.type_ = type_;
      result.memoryLimit_ = memoryLimit_;
      result.physicalDescription_ = physicalDescription_;
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
      if (other instanceof org.tensorflow.util.testlog.AvailableDeviceInfo) {
        return mergeFrom((org.tensorflow.util.testlog.AvailableDeviceInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.util.testlog.AvailableDeviceInfo other) {
      if (other == org.tensorflow.util.testlog.AvailableDeviceInfo.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (other.getMemoryLimit() != 0L) {
        setMemoryLimit(other.getMemoryLimit());
      }
      if (!other.getPhysicalDescription().isEmpty()) {
        physicalDescription_ = other.physicalDescription_;
        onChanged();
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
      org.tensorflow.util.testlog.AvailableDeviceInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.util.testlog.AvailableDeviceInfo) e.getUnfinishedMessage();
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
     * <pre>
     * Device name.
     * </pre>
     *
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
     * <pre>
     * Device name.
     * </pre>
     *
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
     * <pre>
     * Device name.
     * </pre>
     *
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
     * <pre>
     * Device name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Device name.
     * </pre>
     *
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

    private java.lang.Object type_ = "";
    /**
     * <pre>
     * Device type, e.g. 'CPU' or 'GPU'.
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Device type, e.g. 'CPU' or 'GPU'.
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Device type, e.g. 'CPU' or 'GPU'.
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Device type, e.g. 'CPU' or 'GPU'.
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Device type, e.g. 'CPU' or 'GPU'.
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private long memoryLimit_ ;
    /**
     * <pre>
     * Memory capacity in bytes.
     * </pre>
     *
     * <code>int64 memory_limit = 3;</code>
     */
    public long getMemoryLimit() {
      return memoryLimit_;
    }
    /**
     * <pre>
     * Memory capacity in bytes.
     * </pre>
     *
     * <code>int64 memory_limit = 3;</code>
     */
    public Builder setMemoryLimit(long value) {
      
      memoryLimit_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Memory capacity in bytes.
     * </pre>
     *
     * <code>int64 memory_limit = 3;</code>
     */
    public Builder clearMemoryLimit() {
      
      memoryLimit_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object physicalDescription_ = "";
    /**
     * <pre>
     * The physical description of this device.
     * </pre>
     *
     * <code>string physical_description = 4;</code>
     */
    public java.lang.String getPhysicalDescription() {
      java.lang.Object ref = physicalDescription_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        physicalDescription_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The physical description of this device.
     * </pre>
     *
     * <code>string physical_description = 4;</code>
     */
    public com.google.protobuf.ByteString
        getPhysicalDescriptionBytes() {
      java.lang.Object ref = physicalDescription_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        physicalDescription_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The physical description of this device.
     * </pre>
     *
     * <code>string physical_description = 4;</code>
     */
    public Builder setPhysicalDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      physicalDescription_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The physical description of this device.
     * </pre>
     *
     * <code>string physical_description = 4;</code>
     */
    public Builder clearPhysicalDescription() {
      
      physicalDescription_ = getDefaultInstance().getPhysicalDescription();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The physical description of this device.
     * </pre>
     *
     * <code>string physical_description = 4;</code>
     */
    public Builder setPhysicalDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      physicalDescription_ = value;
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


    // @@protoc_insertion_point(builder_scope:tensorflow.AvailableDeviceInfo)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.AvailableDeviceInfo)
  private static final org.tensorflow.util.testlog.AvailableDeviceInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.util.testlog.AvailableDeviceInfo();
  }

  public static org.tensorflow.util.testlog.AvailableDeviceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AvailableDeviceInfo>
      PARSER = new com.google.protobuf.AbstractParser<AvailableDeviceInfo>() {
    @java.lang.Override
    public AvailableDeviceInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AvailableDeviceInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AvailableDeviceInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AvailableDeviceInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.util.testlog.AvailableDeviceInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

