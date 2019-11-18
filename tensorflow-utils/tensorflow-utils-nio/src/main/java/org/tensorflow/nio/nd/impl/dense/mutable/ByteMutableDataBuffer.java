/*
 Copyright 2019 The TensorFlow Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 =======================================================================
 */
package org.tensorflow.nio.nd.impl.dense.mutable;

import org.tensorflow.nio.buffer.ByteDataBuffer;

/**
 * A mutable implementation of a {@link ByteDataBuffer}
 */
public class ByteMutableDataBuffer extends
    MutableDataBuffer<Byte, ByteDataBuffer>
    implements ByteDataBuffer {

    /**
     * Creates a mutable view of a buffer of bytes
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static ByteDataBuffer create(ByteDataBuffer buffer) {
        return new ByteMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public byte getByte(long index) {
        return original().getByte(adjust(index));
    }

    @Override
    public ByteDataBuffer setByte(byte value, long index) {
        original().setByte(value, adjust(index));
        return this;
    }

    @Override
    public ByteDataBuffer write(byte[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public ByteDataBuffer read(byte[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private ByteMutableDataBuffer(ByteDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
