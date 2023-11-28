// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tsl/protobuf/test_log.proto

package org.tensorflow.proto;

/**
 * Protobuf type {@code tensorflow.BenchmarkEntries}
 */
public final class BenchmarkEntries extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.BenchmarkEntries)
    BenchmarkEntriesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BenchmarkEntries.newBuilder() to construct.
  private BenchmarkEntries(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BenchmarkEntries() {
    entry_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BenchmarkEntries();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BenchmarkEntries_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BenchmarkEntries_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.proto.BenchmarkEntries.class, org.tensorflow.proto.BenchmarkEntries.Builder.class);
  }

  public static final int ENTRY_FIELD_NUMBER = 1;
  private java.util.List<org.tensorflow.proto.BenchmarkEntry> entry_;
  /**
   * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
   */
  @java.lang.Override
  public java.util.List<org.tensorflow.proto.BenchmarkEntry> getEntryList() {
    return entry_;
  }
  /**
   * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.tensorflow.proto.BenchmarkEntryOrBuilder> 
      getEntryOrBuilderList() {
    return entry_;
  }
  /**
   * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
   */
  @java.lang.Override
  public int getEntryCount() {
    return entry_.size();
  }
  /**
   * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
   */
  @java.lang.Override
  public org.tensorflow.proto.BenchmarkEntry getEntry(int index) {
    return entry_.get(index);
  }
  /**
   * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
   */
  @java.lang.Override
  public org.tensorflow.proto.BenchmarkEntryOrBuilder getEntryOrBuilder(
      int index) {
    return entry_.get(index);
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
    for (int i = 0; i < entry_.size(); i++) {
      output.writeMessage(1, entry_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < entry_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, entry_.get(i));
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
    if (!(obj instanceof org.tensorflow.proto.BenchmarkEntries)) {
      return super.equals(obj);
    }
    org.tensorflow.proto.BenchmarkEntries other = (org.tensorflow.proto.BenchmarkEntries) obj;

    if (!getEntryList()
        .equals(other.getEntryList())) return false;
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
    if (getEntryCount() > 0) {
      hash = (37 * hash) + ENTRY_FIELD_NUMBER;
      hash = (53 * hash) + getEntryList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.proto.BenchmarkEntries parseFrom(
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
  public static Builder newBuilder(org.tensorflow.proto.BenchmarkEntries prototype) {
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
   * Protobuf type {@code tensorflow.BenchmarkEntries}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.BenchmarkEntries)
      org.tensorflow.proto.BenchmarkEntriesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BenchmarkEntries_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BenchmarkEntries_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.proto.BenchmarkEntries.class, org.tensorflow.proto.BenchmarkEntries.Builder.class);
    }

    // Construct using org.tensorflow.proto.BenchmarkEntries.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (entryBuilder_ == null) {
        entry_ = java.util.Collections.emptyList();
      } else {
        entry_ = null;
        entryBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.proto.TestLogProtos.internal_static_tensorflow_BenchmarkEntries_descriptor;
    }

    @java.lang.Override
    public org.tensorflow.proto.BenchmarkEntries getDefaultInstanceForType() {
      return org.tensorflow.proto.BenchmarkEntries.getDefaultInstance();
    }

    @java.lang.Override
    public org.tensorflow.proto.BenchmarkEntries build() {
      org.tensorflow.proto.BenchmarkEntries result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.tensorflow.proto.BenchmarkEntries buildPartial() {
      org.tensorflow.proto.BenchmarkEntries result = new org.tensorflow.proto.BenchmarkEntries(this);
      int from_bitField0_ = bitField0_;
      if (entryBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          entry_ = java.util.Collections.unmodifiableList(entry_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.entry_ = entry_;
      } else {
        result.entry_ = entryBuilder_.build();
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
      if (other instanceof org.tensorflow.proto.BenchmarkEntries) {
        return mergeFrom((org.tensorflow.proto.BenchmarkEntries)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.proto.BenchmarkEntries other) {
      if (other == org.tensorflow.proto.BenchmarkEntries.getDefaultInstance()) return this;
      if (entryBuilder_ == null) {
        if (!other.entry_.isEmpty()) {
          if (entry_.isEmpty()) {
            entry_ = other.entry_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureEntryIsMutable();
            entry_.addAll(other.entry_);
          }
          onChanged();
        }
      } else {
        if (!other.entry_.isEmpty()) {
          if (entryBuilder_.isEmpty()) {
            entryBuilder_.dispose();
            entryBuilder_ = null;
            entry_ = other.entry_;
            bitField0_ = (bitField0_ & ~0x00000001);
            entryBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getEntryFieldBuilder() : null;
          } else {
            entryBuilder_.addAllMessages(other.entry_);
          }
        }
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
              org.tensorflow.proto.BenchmarkEntry m =
                  input.readMessage(
                      org.tensorflow.proto.BenchmarkEntry.parser(),
                      extensionRegistry);
              if (entryBuilder_ == null) {
                ensureEntryIsMutable();
                entry_.add(m);
              } else {
                entryBuilder_.addMessage(m);
              }
              break;
            } // case 10
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

    private java.util.List<org.tensorflow.proto.BenchmarkEntry> entry_ =
      java.util.Collections.emptyList();
    private void ensureEntryIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        entry_ = new java.util.ArrayList<org.tensorflow.proto.BenchmarkEntry>(entry_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.proto.BenchmarkEntry, org.tensorflow.proto.BenchmarkEntry.Builder, org.tensorflow.proto.BenchmarkEntryOrBuilder> entryBuilder_;

    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public java.util.List<org.tensorflow.proto.BenchmarkEntry> getEntryList() {
      if (entryBuilder_ == null) {
        return java.util.Collections.unmodifiableList(entry_);
      } else {
        return entryBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public int getEntryCount() {
      if (entryBuilder_ == null) {
        return entry_.size();
      } else {
        return entryBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public org.tensorflow.proto.BenchmarkEntry getEntry(int index) {
      if (entryBuilder_ == null) {
        return entry_.get(index);
      } else {
        return entryBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder setEntry(
        int index, org.tensorflow.proto.BenchmarkEntry value) {
      if (entryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEntryIsMutable();
        entry_.set(index, value);
        onChanged();
      } else {
        entryBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder setEntry(
        int index, org.tensorflow.proto.BenchmarkEntry.Builder builderForValue) {
      if (entryBuilder_ == null) {
        ensureEntryIsMutable();
        entry_.set(index, builderForValue.build());
        onChanged();
      } else {
        entryBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder addEntry(org.tensorflow.proto.BenchmarkEntry value) {
      if (entryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEntryIsMutable();
        entry_.add(value);
        onChanged();
      } else {
        entryBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder addEntry(
        int index, org.tensorflow.proto.BenchmarkEntry value) {
      if (entryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEntryIsMutable();
        entry_.add(index, value);
        onChanged();
      } else {
        entryBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder addEntry(
        org.tensorflow.proto.BenchmarkEntry.Builder builderForValue) {
      if (entryBuilder_ == null) {
        ensureEntryIsMutable();
        entry_.add(builderForValue.build());
        onChanged();
      } else {
        entryBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder addEntry(
        int index, org.tensorflow.proto.BenchmarkEntry.Builder builderForValue) {
      if (entryBuilder_ == null) {
        ensureEntryIsMutable();
        entry_.add(index, builderForValue.build());
        onChanged();
      } else {
        entryBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder addAllEntry(
        java.lang.Iterable<? extends org.tensorflow.proto.BenchmarkEntry> values) {
      if (entryBuilder_ == null) {
        ensureEntryIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, entry_);
        onChanged();
      } else {
        entryBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder clearEntry() {
      if (entryBuilder_ == null) {
        entry_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        entryBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public Builder removeEntry(int index) {
      if (entryBuilder_ == null) {
        ensureEntryIsMutable();
        entry_.remove(index);
        onChanged();
      } else {
        entryBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public org.tensorflow.proto.BenchmarkEntry.Builder getEntryBuilder(
        int index) {
      return getEntryFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public org.tensorflow.proto.BenchmarkEntryOrBuilder getEntryOrBuilder(
        int index) {
      if (entryBuilder_ == null) {
        return entry_.get(index);  } else {
        return entryBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public java.util.List<? extends org.tensorflow.proto.BenchmarkEntryOrBuilder> 
         getEntryOrBuilderList() {
      if (entryBuilder_ != null) {
        return entryBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(entry_);
      }
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public org.tensorflow.proto.BenchmarkEntry.Builder addEntryBuilder() {
      return getEntryFieldBuilder().addBuilder(
          org.tensorflow.proto.BenchmarkEntry.getDefaultInstance());
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public org.tensorflow.proto.BenchmarkEntry.Builder addEntryBuilder(
        int index) {
      return getEntryFieldBuilder().addBuilder(
          index, org.tensorflow.proto.BenchmarkEntry.getDefaultInstance());
    }
    /**
     * <code>repeated .tensorflow.BenchmarkEntry entry = 1;</code>
     */
    public java.util.List<org.tensorflow.proto.BenchmarkEntry.Builder> 
         getEntryBuilderList() {
      return getEntryFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.proto.BenchmarkEntry, org.tensorflow.proto.BenchmarkEntry.Builder, org.tensorflow.proto.BenchmarkEntryOrBuilder> 
        getEntryFieldBuilder() {
      if (entryBuilder_ == null) {
        entryBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.tensorflow.proto.BenchmarkEntry, org.tensorflow.proto.BenchmarkEntry.Builder, org.tensorflow.proto.BenchmarkEntryOrBuilder>(
                entry_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        entry_ = null;
      }
      return entryBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tensorflow.BenchmarkEntries)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.BenchmarkEntries)
  private static final org.tensorflow.proto.BenchmarkEntries DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.proto.BenchmarkEntries();
  }

  public static org.tensorflow.proto.BenchmarkEntries getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BenchmarkEntries>
      PARSER = new com.google.protobuf.AbstractParser<BenchmarkEntries>() {
    @java.lang.Override
    public BenchmarkEntries parsePartialFrom(
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

  public static com.google.protobuf.Parser<BenchmarkEntries> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BenchmarkEntries> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.tensorflow.proto.BenchmarkEntries getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

