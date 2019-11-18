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

import java.util.stream.LongStream;
import org.tensorflow.nio.buffer.LongDataBuffer;

/**
 * A mutable implementation of a {@link LongDataBuffer}
 */
public class LongMutableDataBuffer extends MutableDataBuffer<Long, LongDataBuffer>
    implements LongDataBuffer {

    /**
     * Creates a mutable view of a buffer of longs
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static LongDataBuffer create(LongDataBuffer buffer) {
        return new LongMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public LongStream longStream() {
        return slice().longStream();
    }

    @Override
    public long getLong(long index) {
        return original().getLong(adjust(index));
    }

    @Override
    public LongDataBuffer setLong(long value, long index) {
        original().setLong(value, adjust(index));
        return this;
    }

    @Override
    public LongDataBuffer write(long[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public LongDataBuffer read(long[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private LongMutableDataBuffer(LongDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
