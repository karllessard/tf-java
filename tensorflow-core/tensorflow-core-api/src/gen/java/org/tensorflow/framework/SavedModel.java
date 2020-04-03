// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/saved_model.proto

package org.tensorflow.framework;

/**
 * <pre>
 * SavedModel is the high level serialization format for TensorFlow Models.
 * See [todo: doc links, similar to session_bundle] for more information.
 * </pre>
 *
 * Protobuf type {@code tensorflow.SavedModel}
 */
public  final class SavedModel extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.SavedModel)
    SavedModelOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SavedModel.newBuilder() to construct.
  private SavedModel(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SavedModel() {
    metaGraphs_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SavedModel();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SavedModel(
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
          case 8: {

            savedModelSchemaVersion_ = input.readInt64();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              metaGraphs_ = new java.util.ArrayList<org.tensorflow.framework.MetaGraphDef>();
              mutable_bitField0_ |= 0x00000001;
            }
            metaGraphs_.add(
                input.readMessage(org.tensorflow.framework.MetaGraphDef.parser(), extensionRegistry));
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
        metaGraphs_ = java.util.Collections.unmodifiableList(metaGraphs_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.framework.SavedModelProtos.internal_static_tensorflow_SavedModel_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.framework.SavedModelProtos.internal_static_tensorflow_SavedModel_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.framework.SavedModel.class, org.tensorflow.framework.SavedModel.Builder.class);
  }

  public static final int SAVED_MODEL_SCHEMA_VERSION_FIELD_NUMBER = 1;
  private long savedModelSchemaVersion_;
  /**
   * <pre>
   * The schema version of the SavedModel instance. Used for versioning when
   * making future changes to the specification/implementation. Initial value
   * at release will be 1.
   * </pre>
   *
   * <code>int64 saved_model_schema_version = 1;</code>
   */
  public long getSavedModelSchemaVersion() {
    return savedModelSchemaVersion_;
  }

  public static final int META_GRAPHS_FIELD_NUMBER = 2;
  private java.util.List<org.tensorflow.framework.MetaGraphDef> metaGraphs_;
  /**
   * <pre>
   * One or more MetaGraphs.
   * </pre>
   *
   * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
   */
  public java.util.List<org.tensorflow.framework.MetaGraphDef> getMetaGraphsList() {
    return metaGraphs_;
  }
  /**
   * <pre>
   * One or more MetaGraphs.
   * </pre>
   *
   * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
   */
  public java.util.List<? extends org.tensorflow.framework.MetaGraphDefOrBuilder> 
      getMetaGraphsOrBuilderList() {
    return metaGraphs_;
  }
  /**
   * <pre>
   * One or more MetaGraphs.
   * </pre>
   *
   * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
   */
  public int getMetaGraphsCount() {
    return metaGraphs_.size();
  }
  /**
   * <pre>
   * One or more MetaGraphs.
   * </pre>
   *
   * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
   */
  public org.tensorflow.framework.MetaGraphDef getMetaGraphs(int index) {
    return metaGraphs_.get(index);
  }
  /**
   * <pre>
   * One or more MetaGraphs.
   * </pre>
   *
   * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
   */
  public org.tensorflow.framework.MetaGraphDefOrBuilder getMetaGraphsOrBuilder(
      int index) {
    return metaGraphs_.get(index);
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
    if (savedModelSchemaVersion_ != 0L) {
      output.writeInt64(1, savedModelSchemaVersion_);
    }
    for (int i = 0; i < metaGraphs_.size(); i++) {
      output.writeMessage(2, metaGraphs_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (savedModelSchemaVersion_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, savedModelSchemaVersion_);
    }
    for (int i = 0; i < metaGraphs_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, metaGraphs_.get(i));
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
    if (!(obj instanceof org.tensorflow.framework.SavedModel)) {
      return super.equals(obj);
    }
    org.tensorflow.framework.SavedModel other = (org.tensorflow.framework.SavedModel) obj;

    if (getSavedModelSchemaVersion()
        != other.getSavedModelSchemaVersion()) return false;
    if (!getMetaGraphsList()
        .equals(other.getMetaGraphsList())) return false;
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
    hash = (37 * hash) + SAVED_MODEL_SCHEMA_VERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSavedModelSchemaVersion());
    if (getMetaGraphsCount() > 0) {
      hash = (37 * hash) + META_GRAPHS_FIELD_NUMBER;
      hash = (53 * hash) + getMetaGraphsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.framework.SavedModel parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.SavedModel parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.SavedModel parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.SavedModel parseFrom(
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
  public static Builder newBuilder(org.tensorflow.framework.SavedModel prototype) {
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
   * SavedModel is the high level serialization format for TensorFlow Models.
   * See [todo: doc links, similar to session_bundle] for more information.
   * </pre>
   *
   * Protobuf type {@code tensorflow.SavedModel}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.SavedModel)
      org.tensorflow.framework.SavedModelOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.framework.SavedModelProtos.internal_static_tensorflow_SavedModel_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.framework.SavedModelProtos.internal_static_tensorflow_SavedModel_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.framework.SavedModel.class, org.tensorflow.framework.SavedModel.Builder.class);
    }

    // Construct using org.tensorflow.framework.SavedModel.newBuilder()
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
        getMetaGraphsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      savedModelSchemaVersion_ = 0L;

      if (metaGraphsBuilder_ == null) {
        metaGraphs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        metaGraphsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.framework.SavedModelProtos.internal_static_tensorflow_SavedModel_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.framework.SavedModel getDefaultInstanceForType() {
      return org.tensorflow.framework.SavedModel.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.framework.SavedModel build() {
      org.tensorflow.framework.SavedModel result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.framework.SavedModel buildPartial() {
      org.tensorflow.framework.SavedModel result = new org.tensorflow.framework.SavedModel(this);
      int from_bitField0_ = bitField0_;
      result.savedModelSchemaVersion_ = savedModelSchemaVersion_;
      if (metaGraphsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          metaGraphs_ = java.util.Collections.unmodifiableList(metaGraphs_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.metaGraphs_ = metaGraphs_;
      } else {
        result.metaGraphs_ = metaGraphsBuilder_.build();
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
      if (other instanceof org.tensorflow.framework.SavedModel) {
        return mergeFrom((org.tensorflow.framework.SavedModel)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.framework.SavedModel other) {
      if (other == org.tensorflow.framework.SavedModel.getDefaultInstance()) return this;
      if (other.getSavedModelSchemaVersion() != 0L) {
        setSavedModelSchemaVersion(other.getSavedModelSchemaVersion());
      }
      if (metaGraphsBuilder_ == null) {
        if (!other.metaGraphs_.isEmpty()) {
          if (metaGraphs_.isEmpty()) {
            metaGraphs_ = other.metaGraphs_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMetaGraphsIsMutable();
            metaGraphs_.addAll(other.metaGraphs_);
          }
          onChanged();
        }
      } else {
        if (!other.metaGraphs_.isEmpty()) {
          if (metaGraphsBuilder_.isEmpty()) {
            metaGraphsBuilder_.dispose();
            metaGraphsBuilder_ = null;
            metaGraphs_ = other.metaGraphs_;
            bitField0_ = (bitField0_ & ~0x00000001);
            metaGraphsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMetaGraphsFieldBuilder() : null;
          } else {
            metaGraphsBuilder_.addAllMessages(other.metaGraphs_);
          }
        }
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
      org.tensorflow.framework.SavedModel parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.framework.SavedModel) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long savedModelSchemaVersion_ ;
    /**
     * <pre>
     * The schema version of the SavedModel instance. Used for versioning when
     * making future changes to the specification/implementation. Initial value
     * at release will be 1.
     * </pre>
     *
     * <code>int64 saved_model_schema_version = 1;</code>
     */
    public long getSavedModelSchemaVersion() {
      return savedModelSchemaVersion_;
    }
    /**
     * <pre>
     * The schema version of the SavedModel instance. Used for versioning when
     * making future changes to the specification/implementation. Initial value
     * at release will be 1.
     * </pre>
     *
     * <code>int64 saved_model_schema_version = 1;</code>
     */
    public Builder setSavedModelSchemaVersion(long value) {
      
      savedModelSchemaVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The schema version of the SavedModel instance. Used for versioning when
     * making future changes to the specification/implementation. Initial value
     * at release will be 1.
     * </pre>
     *
     * <code>int64 saved_model_schema_version = 1;</code>
     */
    public Builder clearSavedModelSchemaVersion() {
      
      savedModelSchemaVersion_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<org.tensorflow.framework.MetaGraphDef> metaGraphs_ =
      java.util.Collections.emptyList();
    private void ensureMetaGraphsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        metaGraphs_ = new java.util.ArrayList<org.tensorflow.framework.MetaGraphDef>(metaGraphs_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.framework.MetaGraphDef, org.tensorflow.framework.MetaGraphDef.Builder, org.tensorflow.framework.MetaGraphDefOrBuilder> metaGraphsBuilder_;

    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public java.util.List<org.tensorflow.framework.MetaGraphDef> getMetaGraphsList() {
      if (metaGraphsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(metaGraphs_);
      } else {
        return metaGraphsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public int getMetaGraphsCount() {
      if (metaGraphsBuilder_ == null) {
        return metaGraphs_.size();
      } else {
        return metaGraphsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public org.tensorflow.framework.MetaGraphDef getMetaGraphs(int index) {
      if (metaGraphsBuilder_ == null) {
        return metaGraphs_.get(index);
      } else {
        return metaGraphsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder setMetaGraphs(
        int index, org.tensorflow.framework.MetaGraphDef value) {
      if (metaGraphsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetaGraphsIsMutable();
        metaGraphs_.set(index, value);
        onChanged();
      } else {
        metaGraphsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder setMetaGraphs(
        int index, org.tensorflow.framework.MetaGraphDef.Builder builderForValue) {
      if (metaGraphsBuilder_ == null) {
        ensureMetaGraphsIsMutable();
        metaGraphs_.set(index, builderForValue.build());
        onChanged();
      } else {
        metaGraphsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder addMetaGraphs(org.tensorflow.framework.MetaGraphDef value) {
      if (metaGraphsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetaGraphsIsMutable();
        metaGraphs_.add(value);
        onChanged();
      } else {
        metaGraphsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder addMetaGraphs(
        int index, org.tensorflow.framework.MetaGraphDef value) {
      if (metaGraphsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetaGraphsIsMutable();
        metaGraphs_.add(index, value);
        onChanged();
      } else {
        metaGraphsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder addMetaGraphs(
        org.tensorflow.framework.MetaGraphDef.Builder builderForValue) {
      if (metaGraphsBuilder_ == null) {
        ensureMetaGraphsIsMutable();
        metaGraphs_.add(builderForValue.build());
        onChanged();
      } else {
        metaGraphsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder addMetaGraphs(
        int index, org.tensorflow.framework.MetaGraphDef.Builder builderForValue) {
      if (metaGraphsBuilder_ == null) {
        ensureMetaGraphsIsMutable();
        metaGraphs_.add(index, builderForValue.build());
        onChanged();
      } else {
        metaGraphsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder addAllMetaGraphs(
        java.lang.Iterable<? extends org.tensorflow.framework.MetaGraphDef> values) {
      if (metaGraphsBuilder_ == null) {
        ensureMetaGraphsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, metaGraphs_);
        onChanged();
      } else {
        metaGraphsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder clearMetaGraphs() {
      if (metaGraphsBuilder_ == null) {
        metaGraphs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        metaGraphsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public Builder removeMetaGraphs(int index) {
      if (metaGraphsBuilder_ == null) {
        ensureMetaGraphsIsMutable();
        metaGraphs_.remove(index);
        onChanged();
      } else {
        metaGraphsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public org.tensorflow.framework.MetaGraphDef.Builder getMetaGraphsBuilder(
        int index) {
      return getMetaGraphsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public org.tensorflow.framework.MetaGraphDefOrBuilder getMetaGraphsOrBuilder(
        int index) {
      if (metaGraphsBuilder_ == null) {
        return metaGraphs_.get(index);  } else {
        return metaGraphsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public java.util.List<? extends org.tensorflow.framework.MetaGraphDefOrBuilder> 
         getMetaGraphsOrBuilderList() {
      if (metaGraphsBuilder_ != null) {
        return metaGraphsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(metaGraphs_);
      }
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public org.tensorflow.framework.MetaGraphDef.Builder addMetaGraphsBuilder() {
      return getMetaGraphsFieldBuilder().addBuilder(
          org.tensorflow.framework.MetaGraphDef.getDefaultInstance());
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public org.tensorflow.framework.MetaGraphDef.Builder addMetaGraphsBuilder(
        int index) {
      return getMetaGraphsFieldBuilder().addBuilder(
          index, org.tensorflow.framework.MetaGraphDef.getDefaultInstance());
    }
    /**
     * <pre>
     * One or more MetaGraphs.
     * </pre>
     *
     * <code>repeated .tensorflow.MetaGraphDef meta_graphs = 2;</code>
     */
    public java.util.List<org.tensorflow.framework.MetaGraphDef.Builder> 
         getMetaGraphsBuilderList() {
      return getMetaGraphsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.framework.MetaGraphDef, org.tensorflow.framework.MetaGraphDef.Builder, org.tensorflow.framework.MetaGraphDefOrBuilder> 
        getMetaGraphsFieldBuilder() {
      if (metaGraphsBuilder_ == null) {
        metaGraphsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.tensorflow.framework.MetaGraphDef, org.tensorflow.framework.MetaGraphDef.Builder, org.tensorflow.framework.MetaGraphDefOrBuilder>(
                metaGraphs_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        metaGraphs_ = null;
      }
      return metaGraphsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tensorflow.SavedModel)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.SavedModel)
  private static final org.tensorflow.framework.SavedModel DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.framework.SavedModel();
  }

  public static org.tensorflow.framework.SavedModel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SavedModel>
      PARSER = new com.google.protobuf.AbstractParser<SavedModel>() {
    @java.lang.Override
    public SavedModel parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SavedModel(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SavedModel> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SavedModel> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.framework.SavedModel getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

