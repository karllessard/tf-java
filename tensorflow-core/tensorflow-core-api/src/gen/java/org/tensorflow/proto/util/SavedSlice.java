// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/util/saved_tensor_slice.proto

package org.tensorflow.proto.util;

/**
 * <pre>
 * Saved tensor slice: it stores the name of the tensors, the slice, and the
 * raw data.
 * </pre>
 *
 * Protobuf type {@code tensorflow.SavedSlice}
 */
public  final class SavedSlice extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.SavedSlice)
    SavedSliceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SavedSlice.newBuilder() to construct.
  private SavedSlice(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SavedSlice() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SavedSlice();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SavedSlice(
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
            org.tensorflow.proto.framework.TensorSliceProto.Builder subBuilder = null;
            if (slice_ != null) {
              subBuilder = slice_.toBuilder();
            }
            slice_ = input.readMessage(org.tensorflow.proto.framework.TensorSliceProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(slice_);
              slice_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            org.tensorflow.proto.framework.TensorProto.Builder subBuilder = null;
            if (data_ != null) {
              subBuilder = data_.toBuilder();
            }
            data_ = input.readMessage(org.tensorflow.proto.framework.TensorProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(data_);
              data_ = subBuilder.buildPartial();
            }

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
    return org.tensorflow.proto.util.SavedTensorSliceProtos.internal_static_tensorflow_SavedSlice_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.proto.util.SavedTensorSliceProtos.internal_static_tensorflow_SavedSlice_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.proto.util.SavedSlice.class, org.tensorflow.proto.util.SavedSlice.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <pre>
   * Name of the tensor that this slice belongs to. This must be identical to
   * the name used to encode the key for this record.
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
   * Name of the tensor that this slice belongs to. This must be identical to
   * the name used to encode the key for this record.
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

  public static final int SLICE_FIELD_NUMBER = 2;
  private org.tensorflow.proto.framework.TensorSliceProto slice_;
  /**
   * <pre>
   * Extent of the slice.  Must have one entry for each of the dimension of the
   * tensor that this slice belongs to.
   * </pre>
   *
   * <code>.tensorflow.TensorSliceProto slice = 2;</code>
   */
  public boolean hasSlice() {
    return slice_ != null;
  }
  /**
   * <pre>
   * Extent of the slice.  Must have one entry for each of the dimension of the
   * tensor that this slice belongs to.
   * </pre>
   *
   * <code>.tensorflow.TensorSliceProto slice = 2;</code>
   */
  public org.tensorflow.proto.framework.TensorSliceProto getSlice() {
    return slice_ == null ? org.tensorflow.proto.framework.TensorSliceProto.getDefaultInstance() : slice_;
  }
  /**
   * <pre>
   * Extent of the slice.  Must have one entry for each of the dimension of the
   * tensor that this slice belongs to.
   * </pre>
   *
   * <code>.tensorflow.TensorSliceProto slice = 2;</code>
   */
  public org.tensorflow.proto.framework.TensorSliceProtoOrBuilder getSliceOrBuilder() {
    return getSlice();
  }

  public static final int DATA_FIELD_NUMBER = 3;
  private org.tensorflow.proto.framework.TensorProto data_;
  /**
   * <pre>
   * The raw data of the slice is stored as a TensorProto. Only raw data are
   * stored (we don't fill in fields such as dtype or tensor_shape).
   * </pre>
   *
   * <code>.tensorflow.TensorProto data = 3;</code>
   */
  public boolean hasData() {
    return data_ != null;
  }
  /**
   * <pre>
   * The raw data of the slice is stored as a TensorProto. Only raw data are
   * stored (we don't fill in fields such as dtype or tensor_shape).
   * </pre>
   *
   * <code>.tensorflow.TensorProto data = 3;</code>
   */
  public org.tensorflow.proto.framework.TensorProto getData() {
    return data_ == null ? org.tensorflow.proto.framework.TensorProto.getDefaultInstance() : data_;
  }
  /**
   * <pre>
   * The raw data of the slice is stored as a TensorProto. Only raw data are
   * stored (we don't fill in fields such as dtype or tensor_shape).
   * </pre>
   *
   * <code>.tensorflow.TensorProto data = 3;</code>
   */
  public org.tensorflow.proto.framework.TensorProtoOrBuilder getDataOrBuilder() {
    return getData();
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
    if (slice_ != null) {
      output.writeMessage(2, getSlice());
    }
    if (data_ != null) {
      output.writeMessage(3, getData());
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
    if (slice_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSlice());
    }
    if (data_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getData());
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
    if (!(obj instanceof org.tensorflow.proto.util.SavedSlice)) {
      return super.equals(obj);
    }
    org.tensorflow.proto.util.SavedSlice other = (org.tensorflow.proto.util.SavedSlice) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (hasSlice() != other.hasSlice()) return false;
    if (hasSlice()) {
      if (!getSlice()
          .equals(other.getSlice())) return false;
    }
    if (hasData() != other.hasData()) return false;
    if (hasData()) {
      if (!getData()
          .equals(other.getData())) return false;
    }
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
    if (hasSlice()) {
      hash = (37 * hash) + SLICE_FIELD_NUMBER;
      hash = (53 * hash) + getSlice().hashCode();
    }
    if (hasData()) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.util.SavedSlice parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.util.SavedSlice parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.util.SavedSlice parseFrom(
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
  public static Builder newBuilder(org.tensorflow.proto.util.SavedSlice prototype) {
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
   * Saved tensor slice: it stores the name of the tensors, the slice, and the
   * raw data.
   * </pre>
   *
   * Protobuf type {@code tensorflow.SavedSlice}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.SavedSlice)
      org.tensorflow.proto.util.SavedSliceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.proto.util.SavedTensorSliceProtos.internal_static_tensorflow_SavedSlice_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.proto.util.SavedTensorSliceProtos.internal_static_tensorflow_SavedSlice_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.proto.util.SavedSlice.class, org.tensorflow.proto.util.SavedSlice.Builder.class);
    }

    // Construct using org.tensorflow.proto.util.SavedSlice.newBuilder()
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

      if (sliceBuilder_ == null) {
        slice_ = null;
      } else {
        slice_ = null;
        sliceBuilder_ = null;
      }
      if (dataBuilder_ == null) {
        data_ = null;
      } else {
        data_ = null;
        dataBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.proto.util.SavedTensorSliceProtos.internal_static_tensorflow_SavedSlice_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.proto.util.SavedSlice getDefaultInstanceForType() {
      return org.tensorflow.proto.util.SavedSlice.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.proto.util.SavedSlice build() {
      org.tensorflow.proto.util.SavedSlice result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.proto.util.SavedSlice buildPartial() {
      org.tensorflow.proto.util.SavedSlice result = new org.tensorflow.proto.util.SavedSlice(this);
      result.name_ = name_;
      if (sliceBuilder_ == null) {
        result.slice_ = slice_;
      } else {
        result.slice_ = sliceBuilder_.build();
      }
      if (dataBuilder_ == null) {
        result.data_ = data_;
      } else {
        result.data_ = dataBuilder_.build();
      }
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
      if (other instanceof org.tensorflow.proto.util.SavedSlice) {
        return mergeFrom((org.tensorflow.proto.util.SavedSlice)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.proto.util.SavedSlice other) {
      if (other == org.tensorflow.proto.util.SavedSlice.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.hasSlice()) {
        mergeSlice(other.getSlice());
      }
      if (other.hasData()) {
        mergeData(other.getData());
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
      org.tensorflow.proto.util.SavedSlice parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.proto.util.SavedSlice) e.getUnfinishedMessage();
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
     * Name of the tensor that this slice belongs to. This must be identical to
     * the name used to encode the key for this record.
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
     * Name of the tensor that this slice belongs to. This must be identical to
     * the name used to encode the key for this record.
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
     * Name of the tensor that this slice belongs to. This must be identical to
     * the name used to encode the key for this record.
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
     * Name of the tensor that this slice belongs to. This must be identical to
     * the name used to encode the key for this record.
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
     * Name of the tensor that this slice belongs to. This must be identical to
     * the name used to encode the key for this record.
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

    private org.tensorflow.proto.framework.TensorSliceProto slice_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.proto.framework.TensorSliceProto, org.tensorflow.proto.framework.TensorSliceProto.Builder, org.tensorflow.proto.framework.TensorSliceProtoOrBuilder> sliceBuilder_;
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public boolean hasSlice() {
      return sliceBuilder_ != null || slice_ != null;
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public org.tensorflow.proto.framework.TensorSliceProto getSlice() {
      if (sliceBuilder_ == null) {
        return slice_ == null ? org.tensorflow.proto.framework.TensorSliceProto.getDefaultInstance() : slice_;
      } else {
        return sliceBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public Builder setSlice(org.tensorflow.proto.framework.TensorSliceProto value) {
      if (sliceBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        slice_ = value;
        onChanged();
      } else {
        sliceBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public Builder setSlice(
        org.tensorflow.proto.framework.TensorSliceProto.Builder builderForValue) {
      if (sliceBuilder_ == null) {
        slice_ = builderForValue.build();
        onChanged();
      } else {
        sliceBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public Builder mergeSlice(org.tensorflow.proto.framework.TensorSliceProto value) {
      if (sliceBuilder_ == null) {
        if (slice_ != null) {
          slice_ =
            org.tensorflow.proto.framework.TensorSliceProto.newBuilder(slice_).mergeFrom(value).buildPartial();
        } else {
          slice_ = value;
        }
        onChanged();
      } else {
        sliceBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public Builder clearSlice() {
      if (sliceBuilder_ == null) {
        slice_ = null;
        onChanged();
      } else {
        slice_ = null;
        sliceBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public org.tensorflow.proto.framework.TensorSliceProto.Builder getSliceBuilder() {
      
      onChanged();
      return getSliceFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    public org.tensorflow.proto.framework.TensorSliceProtoOrBuilder getSliceOrBuilder() {
      if (sliceBuilder_ != null) {
        return sliceBuilder_.getMessageOrBuilder();
      } else {
        return slice_ == null ?
            org.tensorflow.proto.framework.TensorSliceProto.getDefaultInstance() : slice_;
      }
    }
    /**
     * <pre>
     * Extent of the slice.  Must have one entry for each of the dimension of the
     * tensor that this slice belongs to.
     * </pre>
     *
     * <code>.tensorflow.TensorSliceProto slice = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.proto.framework.TensorSliceProto, org.tensorflow.proto.framework.TensorSliceProto.Builder, org.tensorflow.proto.framework.TensorSliceProtoOrBuilder> 
        getSliceFieldBuilder() {
      if (sliceBuilder_ == null) {
        sliceBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.tensorflow.proto.framework.TensorSliceProto, org.tensorflow.proto.framework.TensorSliceProto.Builder, org.tensorflow.proto.framework.TensorSliceProtoOrBuilder>(
                getSlice(),
                getParentForChildren(),
                isClean());
        slice_ = null;
      }
      return sliceBuilder_;
    }

    private org.tensorflow.proto.framework.TensorProto data_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.proto.framework.TensorProto, org.tensorflow.proto.framework.TensorProto.Builder, org.tensorflow.proto.framework.TensorProtoOrBuilder> dataBuilder_;
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public boolean hasData() {
      return dataBuilder_ != null || data_ != null;
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public org.tensorflow.proto.framework.TensorProto getData() {
      if (dataBuilder_ == null) {
        return data_ == null ? org.tensorflow.proto.framework.TensorProto.getDefaultInstance() : data_;
      } else {
        return dataBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public Builder setData(org.tensorflow.proto.framework.TensorProto value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        data_ = value;
        onChanged();
      } else {
        dataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public Builder setData(
        org.tensorflow.proto.framework.TensorProto.Builder builderForValue) {
      if (dataBuilder_ == null) {
        data_ = builderForValue.build();
        onChanged();
      } else {
        dataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public Builder mergeData(org.tensorflow.proto.framework.TensorProto value) {
      if (dataBuilder_ == null) {
        if (data_ != null) {
          data_ =
            org.tensorflow.proto.framework.TensorProto.newBuilder(data_).mergeFrom(value).buildPartial();
        } else {
          data_ = value;
        }
        onChanged();
      } else {
        dataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public Builder clearData() {
      if (dataBuilder_ == null) {
        data_ = null;
        onChanged();
      } else {
        data_ = null;
        dataBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public org.tensorflow.proto.framework.TensorProto.Builder getDataBuilder() {
      
      onChanged();
      return getDataFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    public org.tensorflow.proto.framework.TensorProtoOrBuilder getDataOrBuilder() {
      if (dataBuilder_ != null) {
        return dataBuilder_.getMessageOrBuilder();
      } else {
        return data_ == null ?
            org.tensorflow.proto.framework.TensorProto.getDefaultInstance() : data_;
      }
    }
    /**
     * <pre>
     * The raw data of the slice is stored as a TensorProto. Only raw data are
     * stored (we don't fill in fields such as dtype or tensor_shape).
     * </pre>
     *
     * <code>.tensorflow.TensorProto data = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.proto.framework.TensorProto, org.tensorflow.proto.framework.TensorProto.Builder, org.tensorflow.proto.framework.TensorProtoOrBuilder> 
        getDataFieldBuilder() {
      if (dataBuilder_ == null) {
        dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.tensorflow.proto.framework.TensorProto, org.tensorflow.proto.framework.TensorProto.Builder, org.tensorflow.proto.framework.TensorProtoOrBuilder>(
                getData(),
                getParentForChildren(),
                isClean());
        data_ = null;
      }
      return dataBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tensorflow.SavedSlice)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.SavedSlice)
  private static final org.tensorflow.proto.util.SavedSlice DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.proto.util.SavedSlice();
  }

  public static org.tensorflow.proto.util.SavedSlice getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SavedSlice>
      PARSER = new com.google.protobuf.AbstractParser<SavedSlice>() {
    @java.lang.Override
    public SavedSlice parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SavedSlice(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SavedSlice> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SavedSlice> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.proto.util.SavedSlice getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

