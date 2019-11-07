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
package org.tensorflow.nio.buffer.slice;

import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.buffer.ShortDataBuffer;

/**
 * A slice of a short buffer that could be repositioned.
 */
public class ShortDataBufferSlice extends DataBufferSlice<Short> implements ShortDataBuffer {

    /**
     * Creates a new slice of a short buffer, starting at {@code buffer.position()} and ending
     * at {@code buffer.limit()}.
     *
     * @param buffer buffer to slice
     * @return buffer slice
     */
    public static ShortDataBufferSlice create(ShortDataBuffer buffer) {
        return new ShortDataBufferSlice(buffer, buffer.position(), buffer.limit());
    }

    @Override
    public short getShort() {
        return delegate().getShort();
    }

    @Override
    public short getShort(long index) {
        return delegate().getShort(offset(index));
    }

    @Override
    public ShortDataBufferSlice get(short[] dst, int offset, int length) {
        delegate().get(dst, offset, length);
        return this;
    }

    @Override
    public ShortDataBufferSlice putShort(short value) {
        delegate().putShort(value);
        return this;
    }

    @Override
    public ShortDataBufferSlice putShort(long index, short value) {
        delegate().putShort(offset(index), value);
        return this;
    }

    @Override
    public ShortDataBufferSlice put(short[] src, int offset, int length) {
        delegate().put(src, offset, length);
        return this;
    }

    @Override
    public ShortDataBufferSlice duplicate() {
        return new ShortDataBufferSlice(delegate(), start(), end());
    }

    @Override
    public ShortDataBufferSlice limit(long newLimit) {
        return (ShortDataBufferSlice)super.limit(newLimit);
    }

    @Override
    public ShortDataBufferSlice withLimit(long limit) {
        return (ShortDataBufferSlice)super.withLimit(limit);
    }

    @Override
    public ShortDataBufferSlice position(long newPosition) {
        return (ShortDataBufferSlice)super.position(newPosition);
    }

    @Override
    public ShortDataBufferSlice withPosition(long position) {
        return (ShortDataBufferSlice)super.withPosition(position);
    }

    @Override
    public ShortDataBufferSlice rewind() {
        return (ShortDataBufferSlice)super.rewind();
    }

    @Override
    public ShortDataBufferSlice put(Short value) {
        return (ShortDataBufferSlice)super.put(value);
    }

    @Override
    public ShortDataBufferSlice put(long index, Short value) {
        return (ShortDataBufferSlice)super.put(index, value);
    }

    @Override
    public ShortDataBufferSlice put(DataBuffer<Short> src) {
        return (ShortDataBufferSlice)super.put(src);
    }

    @Override
    protected ShortDataBuffer delegate() {
        return (ShortDataBuffer)super.delegate();
    }

    private ShortDataBufferSlice(ShortDataBuffer buffer, long start, long end) {
        super(buffer, start, end);
    }
}
