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

import org.tensorflow.nio.buffer.ShortDataBuffer;

/**
 * A mutable implementation of a {@link ShortDataBuffer}
 */
public class ShortMutableDataBuffer extends
    MutableDataBuffer<Short, ShortDataBuffer>
    implements ShortDataBuffer {

    /**
     * Creates a mutable view of a buffer of shorts
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static ShortDataBuffer create(ShortDataBuffer buffer) {
        return new ShortMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public short getShort(long index) {
        return original().getShort(adjust(index));
    }

    @Override
    public ShortDataBuffer setShort(short value, long index) {
        original().setShort(value, adjust(index));
        return this;
    }

    @Override
    public ShortDataBuffer write(short[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public ShortDataBuffer read(short[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private ShortMutableDataBuffer(ShortDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
