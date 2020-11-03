// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/saved_object_graph.proto

package org.tensorflow.proto.framework;

/**
 * Protobuf type {@code tensorflow.SavedBareConcreteFunction}
 */
public  final class SavedBareConcreteFunction extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.SavedBareConcreteFunction)
    SavedBareConcreteFunctionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SavedBareConcreteFunction.newBuilder() to construct.
  private SavedBareConcreteFunction(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SavedBareConcreteFunction() {
    concreteFunctionName_ = "";
    argumentKeywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SavedBareConcreteFunction();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SavedBareConcreteFunction(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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

            concreteFunctionName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              argumentKeywords_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            argumentKeywords_.add(s);
            break;
          }
          case 24: {

            allowedPositionalArguments_ = input.readInt64();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        argumentKeywords_ = argumentKeywords_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.proto.framework.SavedObjectGraphProtos.internal_static_tensorflow_SavedBareConcreteFunction_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.proto.framework.SavedObjectGraphProtos.internal_static_tensorflow_SavedBareConcreteFunction_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.proto.framework.SavedBareConcreteFunction.class, org.tensorflow.proto.framework.SavedBareConcreteFunction.Builder.class);
  }

  public static final int CONCRETE_FUNCTION_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object concreteFunctionName_;
  /**
   * <pre>
   * Identifies a SavedConcreteFunction.
   * </pre>
   *
   * <code>string concrete_function_name = 1;</code>
   */
  public java.lang.String getConcreteFunctionName() {
    java.lang.Object ref = concreteFunctionName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      concreteFunctionName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Identifies a SavedConcreteFunction.
   * </pre>
   *
   * <code>string concrete_function_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getConcreteFunctionNameBytes() {
    java.lang.Object ref = concreteFunctionName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      concreteFunctionName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ARGUMENT_KEYWORDS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList argumentKeywords_;
  /**
   * <pre>
   * A sequence of unique strings, one per Tensor argument.
   * </pre>
   *
   * <code>repeated string argument_keywords = 2;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getArgumentKeywordsList() {
    return argumentKeywords_;
  }
  /**
   * <pre>
   * A sequence of unique strings, one per Tensor argument.
   * </pre>
   *
   * <code>repeated string argument_keywords = 2;</code>
   */
  public int getArgumentKeywordsCount() {
    return argumentKeywords_.size();
  }
  /**
   * <pre>
   * A sequence of unique strings, one per Tensor argument.
   * </pre>
   *
   * <code>repeated string argument_keywords = 2;</code>
   */
  public java.lang.String getArgumentKeywords(int index) {
    return argumentKeywords_.get(index);
  }
  /**
   * <pre>
   * A sequence of unique strings, one per Tensor argument.
   * </pre>
   *
   * <code>repeated string argument_keywords = 2;</code>
   */
  public com.google.protobuf.ByteString
      getArgumentKeywordsBytes(int index) {
    return argumentKeywords_.getByteString(index);
  }

  public static final int ALLOWED_POSITIONAL_ARGUMENTS_FIELD_NUMBER = 3;
  private long allowedPositionalArguments_;
  /**
   * <pre>
   * The prefix of `argument_keywords` which may be identified by position.
   * </pre>
   *
   * <code>int64 allowed_positional_arguments = 3;</code>
   */
  public long getAllowedPositionalArguments() {
    return allowedPositionalArguments_;
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
    if (!getConcreteFunctionNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, concreteFunctionName_);
    }
    for (int i = 0; i < argumentKeywords_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, argumentKeywords_.getRaw(i));
    }
    if (allowedPositionalArguments_ != 0L) {
      output.writeInt64(3, allowedPositionalArguments_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getConcreteFunctionNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, concreteFunctionName_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < argumentKeywords_.size(); i++) {
        dataSize += computeStringSizeNoTag(argumentKeywords_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getArgumentKeywordsList().size();
    }
    if (allowedPositionalArguments_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, allowedPositionalArguments_);
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
    if (!(obj instanceof org.tensorflow.proto.framework.SavedBareConcreteFunction)) {
      return super.equals(obj);
    }
    org.tensorflow.proto.framework.SavedBareConcreteFunction other = (org.tensorflow.proto.framework.SavedBareConcreteFunction) obj;

    if (!getConcreteFunctionName()
        .equals(other.getConcreteFunctionName())) return false;
    if (!getArgumentKeywordsList()
        .equals(other.getArgumentKeywordsList())) return false;
    if (getAllowedPositionalArguments()
        != other.getAllowedPositionalArguments()) return false;
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
    hash = (37 * hash) + CONCRETE_FUNCTION_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getConcreteFunctionName().hashCode();
    if (getArgumentKeywordsCount() > 0) {
      hash = (37 * hash) + ARGUMENT_KEYWORDS_FIELD_NUMBER;
      hash = (53 * hash) + getArgumentKeywordsList().hashCode();
    }
    hash = (37 * hash) + ALLOWED_POSITIONAL_ARGUMENTS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAllowedPositionalArguments());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.framework.SavedBareConcreteFunction parseFrom(
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
  public static Builder newBuilder(org.tensorflow.proto.framework.SavedBareConcreteFunction prototype) {
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
   * Protobuf type {@code tensorflow.SavedBareConcreteFunction}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.SavedBareConcreteFunction)
      org.tensorflow.proto.framework.SavedBareConcreteFunctionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.proto.framework.SavedObjectGraphProtos.internal_static_tensorflow_SavedBareConcreteFunction_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.proto.framework.SavedObjectGraphProtos.internal_static_tensorflow_SavedBareConcreteFunction_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.proto.framework.SavedBareConcreteFunction.class, org.tensorflow.proto.framework.SavedBareConcreteFunction.Builder.class);
    }

    // Construct using org.tensorflow.proto.framework.SavedBareConcreteFunction.newBuilder()
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
      concreteFunctionName_ = "";

      argumentKeywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      allowedPositionalArguments_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.proto.framework.SavedObjectGraphProtos.internal_static_tensorflow_SavedBareConcreteFunction_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.proto.framework.SavedBareConcreteFunction getDefaultInstanceForType() {
      return org.tensorflow.proto.framework.SavedBareConcreteFunction.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.proto.framework.SavedBareConcreteFunction build() {
      org.tensorflow.proto.framework.SavedBareConcreteFunction result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.proto.framework.SavedBareConcreteFunction buildPartial() {
      org.tensorflow.proto.framework.SavedBareConcreteFunction result = new org.tensorflow.proto.framework.SavedBareConcreteFunction(this);
      int from_bitField0_ = bitField0_;
      result.concreteFunctionName_ = concreteFunctionName_;
      if (((bitField0_ & 0x00000001) != 0)) {
        argumentKeywords_ = argumentKeywords_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.argumentKeywords_ = argumentKeywords_;
      result.allowedPositionalArguments_ = allowedPositionalArguments_;
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
      if (other instanceof org.tensorflow.proto.framework.SavedBareConcreteFunction) {
        return mergeFrom((org.tensorflow.proto.framework.SavedBareConcreteFunction)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.proto.framework.SavedBareConcreteFunction other) {
      if (other == org.tensorflow.proto.framework.SavedBareConcreteFunction.getDefaultInstance()) return this;
      if (!other.getConcreteFunctionName().isEmpty()) {
        concreteFunctionName_ = other.concreteFunctionName_;
        onChanged();
      }
      if (!other.argumentKeywords_.isEmpty()) {
        if (argumentKeywords_.isEmpty()) {
          argumentKeywords_ = other.argumentKeywords_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureArgumentKeywordsIsMutable();
          argumentKeywords_.addAll(other.argumentKeywords_);
        }
        onChanged();
      }
      if (other.getAllowedPositionalArguments() != 0L) {
        setAllowedPositionalArguments(other.getAllowedPositionalArguments());
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
      org.tensorflow.proto.framework.SavedBareConcreteFunction parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.proto.framework.SavedBareConcreteFunction) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object concreteFunctionName_ = "";
    /**
     * <pre>
     * Identifies a SavedConcreteFunction.
     * </pre>
     *
     * <code>string concrete_function_name = 1;</code>
     */
    public java.lang.String getConcreteFunctionName() {
      java.lang.Object ref = concreteFunctionName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        concreteFunctionName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Identifies a SavedConcreteFunction.
     * </pre>
     *
     * <code>string concrete_function_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getConcreteFunctionNameBytes() {
      java.lang.Object ref = concreteFunctionName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        concreteFunctionName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Identifies a SavedConcreteFunction.
     * </pre>
     *
     * <code>string concrete_function_name = 1;</code>
     */
    public Builder setConcreteFunctionName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      concreteFunctionName_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Identifies a SavedConcreteFunction.
     * </pre>
     *
     * <code>string concrete_function_name = 1;</code>
     */
    public Builder clearConcreteFunctionName() {
      
      concreteFunctionName_ = getDefaultInstance().getConcreteFunctionName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Identifies a SavedConcreteFunction.
     * </pre>
     *
     * <code>string concrete_function_name = 1;</code>
     */
    public Builder setConcreteFunctionNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      concreteFunctionName_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList argumentKeywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureArgumentKeywordsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        argumentKeywords_ = new com.google.protobuf.LazyStringArrayList(argumentKeywords_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getArgumentKeywordsList() {
      return argumentKeywords_.getUnmodifiableView();
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public int getArgumentKeywordsCount() {
      return argumentKeywords_.size();
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public java.lang.String getArgumentKeywords(int index) {
      return argumentKeywords_.get(index);
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public com.google.protobuf.ByteString
        getArgumentKeywordsBytes(int index) {
      return argumentKeywords_.getByteString(index);
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public Builder setArgumentKeywords(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureArgumentKeywordsIsMutable();
      argumentKeywords_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public Builder addArgumentKeywords(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureArgumentKeywordsIsMutable();
      argumentKeywords_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public Builder addAllArgumentKeywords(
        java.lang.Iterable<java.lang.String> values) {
      ensureArgumentKeywordsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, argumentKeywords_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public Builder clearArgumentKeywords() {
      argumentKeywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A sequence of unique strings, one per Tensor argument.
     * </pre>
     *
     * <code>repeated string argument_keywords = 2;</code>
     */
    public Builder addArgumentKeywordsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureArgumentKeywordsIsMutable();
      argumentKeywords_.add(value);
      onChanged();
      return this;
    }

    private long allowedPositionalArguments_ ;
    /**
     * <pre>
     * The prefix of `argument_keywords` which may be identified by position.
     * </pre>
     *
     * <code>int64 allowed_positional_arguments = 3;</code>
     */
    public long getAllowedPositionalArguments() {
      return allowedPositionalArguments_;
    }
    /**
     * <pre>
     * The prefix of `argument_keywords` which may be identified by position.
     * </pre>
     *
     * <code>int64 allowed_positional_arguments = 3;</code>
     */
    public Builder setAllowedPositionalArguments(long value) {
      
      allowedPositionalArguments_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The prefix of `argument_keywords` which may be identified by position.
     * </pre>
     *
     * <code>int64 allowed_positional_arguments = 3;</code>
     */
    public Builder clearAllowedPositionalArguments() {
      
      allowedPositionalArguments_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:tensorflow.SavedBareConcreteFunction)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.SavedBareConcreteFunction)
  private static final org.tensorflow.proto.framework.SavedBareConcreteFunction DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.proto.framework.SavedBareConcreteFunction();
  }

  public static org.tensorflow.proto.framework.SavedBareConcreteFunction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SavedBareConcreteFunction>
      PARSER = new com.google.protobuf.AbstractParser<SavedBareConcreteFunction>() {
    @java.lang.Override
    public SavedBareConcreteFunction parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SavedBareConcreteFunction(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SavedBareConcreteFunction> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SavedBareConcreteFunction> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.proto.framework.SavedBareConcreteFunction getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

