// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tsl/protobuf/test_log.proto

package org.tensorflow.proto;

/**
 * Protobuf type {@code tensorflow.BuildConfiguration}
 */
public final class BuildConfiguration extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.BuildConfiguration)
    BuildConfigurationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BuildConfiguration.newBuilder() to construct.
  private BuildConfiguration(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BuildConfiguration() {
    mode_ = "";
    ccFlags_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    opts_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BuildConfiguration();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BuildConfiguration_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BuildConfiguration_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.proto.BuildConfiguration.class, org.tensorflow.proto.BuildConfiguration.Builder.class);
  }

  public static final int MODE_FIELD_NUMBER = 1;
  private volatile java.lang.Object mode_;
  /**
   * <pre>
   * opt, dbg, etc
   * </pre>
   *
   * <code>string mode = 1;</code>
   * @return The mode.
   */
  @java.lang.Override
  public java.lang.String getMode() {
    java.lang.Object ref = mode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      mode_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * opt, dbg, etc
   * </pre>
   *
   * <code>string mode = 1;</code>
   * @return The bytes for mode.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getModeBytes() {
    java.lang.Object ref = mode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      mode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CC_FLAGS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList ccFlags_;
  /**
   * <pre>
   * CC compiler flags, if known
   * </pre>
   *
   * <code>repeated string cc_flags = 2;</code>
   * @return A list containing the ccFlags.
   */
  public com.google.protobuf.ProtocolStringList
      getCcFlagsList() {
    return ccFlags_;
  }
  /**
   * <pre>
   * CC compiler flags, if known
   * </pre>
   *
   * <code>repeated string cc_flags = 2;</code>
   * @return The count of ccFlags.
   */
  public int getCcFlagsCount() {
    return ccFlags_.size();
  }
  /**
   * <pre>
   * CC compiler flags, if known
   * </pre>
   *
   * <code>repeated string cc_flags = 2;</code>
   * @param index The index of the element to return.
   * @return The ccFlags at the given index.
   */
  public java.lang.String getCcFlags(int index) {
    return ccFlags_.get(index);
  }
  /**
   * <pre>
   * CC compiler flags, if known
   * </pre>
   *
   * <code>repeated string cc_flags = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the ccFlags at the given index.
   */
  public com.google.protobuf.ByteString
      getCcFlagsBytes(int index) {
    return ccFlags_.getByteString(index);
  }

  public static final int OPTS_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList opts_;
  /**
   * <pre>
   * Bazel compilation options, if known
   * </pre>
   *
   * <code>repeated string opts = 3;</code>
   * @return A list containing the opts.
   */
  public com.google.protobuf.ProtocolStringList
      getOptsList() {
    return opts_;
  }
  /**
   * <pre>
   * Bazel compilation options, if known
   * </pre>
   *
   * <code>repeated string opts = 3;</code>
   * @return The count of opts.
   */
  public int getOptsCount() {
    return opts_.size();
  }
  /**
   * <pre>
   * Bazel compilation options, if known
   * </pre>
   *
   * <code>repeated string opts = 3;</code>
   * @param index The index of the element to return.
   * @return The opts at the given index.
   */
  public java.lang.String getOpts(int index) {
    return opts_.get(index);
  }
  /**
   * <pre>
   * Bazel compilation options, if known
   * </pre>
   *
   * <code>repeated string opts = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the opts at the given index.
   */
  public com.google.protobuf.ByteString
      getOptsBytes(int index) {
    return opts_.getByteString(index);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(mode_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mode_);
    }
    for (int i = 0; i < ccFlags_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ccFlags_.getRaw(i));
    }
    for (int i = 0; i < opts_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, opts_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(mode_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, mode_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < ccFlags_.size(); i++) {
        dataSize += computeStringSizeNoTag(ccFlags_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getCcFlagsList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < opts_.size(); i++) {
        dataSize += computeStringSizeNoTag(opts_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getOptsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.tensorflow.proto.BuildConfiguration)) {
      return super.equals(obj);
    }
    org.tensorflow.proto.BuildConfiguration other = (org.tensorflow.proto.BuildConfiguration) obj;

    if (!getMode()
        .equals(other.getMode())) return false;
    if (!getCcFlagsList()
        .equals(other.getCcFlagsList())) return false;
    if (!getOptsList()
        .equals(other.getOptsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MODE_FIELD_NUMBER;
    hash = (53 * hash) + getMode().hashCode();
    if (getCcFlagsCount() > 0) {
      hash = (37 * hash) + CC_FLAGS_FIELD_NUMBER;
      hash = (53 * hash) + getCcFlagsList().hashCode();
    }
    if (getOptsCount() > 0) {
      hash = (37 * hash) + OPTS_FIELD_NUMBER;
      hash = (53 * hash) + getOptsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.BuildConfiguration parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BuildConfiguration parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BuildConfiguration parseFrom(
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
  public static Builder newBuilder(org.tensorflow.proto.BuildConfiguration prototype) {
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
   * Protobuf type {@code tensorflow.BuildConfiguration}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.BuildConfiguration)
      org.tensorflow.proto.BuildConfigurationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BuildConfiguration_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BuildConfiguration_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.proto.BuildConfiguration.class, org.tensorflow.proto.BuildConfiguration.Builder.class);
    }

    // Construct using org.tensorflow.proto.BuildConfiguration.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      mode_ = "";

      ccFlags_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      opts_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BuildConfiguration_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.proto.BuildConfiguration getDefaultInstanceForType() {
      return org.tensorflow.proto.BuildConfiguration.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.proto.BuildConfiguration build() {
      org.tensorflow.proto.BuildConfiguration result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.proto.BuildConfiguration buildPartial() {
      org.tensorflow.proto.BuildConfiguration result = new org.tensorflow.proto.BuildConfiguration(this);
      int from_bitField0_ = bitField0_;
      result.mode_ = mode_;
      if (((bitField0_ & 0x00000001) != 0)) {
        ccFlags_ = ccFlags_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.ccFlags_ = ccFlags_;
      if (((bitField0_ & 0x00000002) != 0)) {
        opts_ = opts_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.opts_ = opts_;
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
      if (other instanceof org.tensorflow.proto.BuildConfiguration) {
        return mergeFrom((org.tensorflow.proto.BuildConfiguration)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.proto.BuildConfiguration other) {
      if (other == org.tensorflow.proto.BuildConfiguration.getDefaultInstance()) return this;
      if (!other.getMode().isEmpty()) {
        mode_ = other.mode_;
        onChanged();
      }
      if (!other.ccFlags_.isEmpty()) {
        if (ccFlags_.isEmpty()) {
          ccFlags_ = other.ccFlags_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureCcFlagsIsMutable();
          ccFlags_.addAll(other.ccFlags_);
        }
        onChanged();
      }
      if (!other.opts_.isEmpty()) {
        if (opts_.isEmpty()) {
          opts_ = other.opts_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureOptsIsMutable();
          opts_.addAll(other.opts_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              mode_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureCcFlagsIsMutable();
              ccFlags_.add(s);
              break;
            } // case 18
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureOptsIsMutable();
              opts_.add(s);
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object mode_ = "";
    /**
     * <pre>
     * opt, dbg, etc
     * </pre>
     *
     * <code>string mode = 1;</code>
     * @return The mode.
     */
    public java.lang.String getMode() {
      java.lang.Object ref = mode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * opt, dbg, etc
     * </pre>
     *
     * <code>string mode = 1;</code>
     * @return The bytes for mode.
     */
    public com.google.protobuf.ByteString
        getModeBytes() {
      java.lang.Object ref = mode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * opt, dbg, etc
     * </pre>
     *
     * <code>string mode = 1;</code>
     * @param value The mode to set.
     * @return This builder for chaining.
     */
    public Builder setMode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      mode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * opt, dbg, etc
     * </pre>
     *
     * <code>string mode = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMode() {
      
      mode_ = getDefaultInstance().getMode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * opt, dbg, etc
     * </pre>
     *
     * <code>string mode = 1;</code>
     * @param value The bytes for mode to set.
     * @return This builder for chaining.
     */
    public Builder setModeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      mode_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList ccFlags_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureCcFlagsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        ccFlags_ = new com.google.protobuf.LazyStringArrayList(ccFlags_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @return A list containing the ccFlags.
     */
    public com.google.protobuf.ProtocolStringList
        getCcFlagsList() {
      return ccFlags_.getUnmodifiableView();
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @return The count of ccFlags.
     */
    public int getCcFlagsCount() {
      return ccFlags_.size();
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param index The index of the element to return.
     * @return The ccFlags at the given index.
     */
    public java.lang.String getCcFlags(int index) {
      return ccFlags_.get(index);
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the ccFlags at the given index.
     */
    public com.google.protobuf.ByteString
        getCcFlagsBytes(int index) {
      return ccFlags_.getByteString(index);
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param index The index to set the value at.
     * @param value The ccFlags to set.
     * @return This builder for chaining.
     */
    public Builder setCcFlags(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureCcFlagsIsMutable();
      ccFlags_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param value The ccFlags to add.
     * @return This builder for chaining.
     */
    public Builder addCcFlags(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureCcFlagsIsMutable();
      ccFlags_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param values The ccFlags to add.
     * @return This builder for chaining.
     */
    public Builder addAllCcFlags(
        java.lang.Iterable<java.lang.String> values) {
      ensureCcFlagsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, ccFlags_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCcFlags() {
      ccFlags_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * CC compiler flags, if known
     * </pre>
     *
     * <code>repeated string cc_flags = 2;</code>
     * @param value The bytes of the ccFlags to add.
     * @return This builder for chaining.
     */
    public Builder addCcFlagsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureCcFlagsIsMutable();
      ccFlags_.add(value);
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList opts_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureOptsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        opts_ = new com.google.protobuf.LazyStringArrayList(opts_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @return A list containing the opts.
     */
    public com.google.protobuf.ProtocolStringList
        getOptsList() {
      return opts_.getUnmodifiableView();
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @return The count of opts.
     */
    public int getOptsCount() {
      return opts_.size();
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param index The index of the element to return.
     * @return The opts at the given index.
     */
    public java.lang.String getOpts(int index) {
      return opts_.get(index);
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the opts at the given index.
     */
    public com.google.protobuf.ByteString
        getOptsBytes(int index) {
      return opts_.getByteString(index);
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param index The index to set the value at.
     * @param value The opts to set.
     * @return This builder for chaining.
     */
    public Builder setOpts(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureOptsIsMutable();
      opts_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param value The opts to add.
     * @return This builder for chaining.
     */
    public Builder addOpts(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureOptsIsMutable();
      opts_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param values The opts to add.
     * @return This builder for chaining.
     */
    public Builder addAllOpts(
        java.lang.Iterable<java.lang.String> values) {
      ensureOptsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, opts_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOpts() {
      opts_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Bazel compilation options, if known
     * </pre>
     *
     * <code>repeated string opts = 3;</code>
     * @param value The bytes of the opts to add.
     * @return This builder for chaining.
     */
    public Builder addOptsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureOptsIsMutable();
      opts_.add(value);
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


    // @@protoc_insertion_point(builder_scope:tensorflow.BuildConfiguration)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.BuildConfiguration)
  private static final org.tensorflow.proto.BuildConfiguration DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.proto.BuildConfiguration();
  }

  public static org.tensorflow.proto.BuildConfiguration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BuildConfiguration>
      PARSER = new com.google.protobuf.AbstractParser<BuildConfiguration>() {
    @java.lang.Override
    public BuildConfiguration parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<BuildConfiguration> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BuildConfiguration> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.proto.BuildConfiguration getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

