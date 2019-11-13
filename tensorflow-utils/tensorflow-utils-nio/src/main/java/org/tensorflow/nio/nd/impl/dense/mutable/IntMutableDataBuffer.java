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

import java.util.stream.IntStream;
import org.tensorflow.nio.buffer.IntDataBuffer;

/**
 * A mutable implementation of a {@link IntDataBuffer}
 */
public class IntMutableDataBuffer extends MutableDataBuffer<Integer, IntDataBuffer>
    implements IntDataBuffer {

    /**
     * Creates a mutable view of a buffer of ints
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static IntDataBuffer create(IntDataBuffer buffer) {
        return new IntMutableDataBuffer(buffer, 0, buffer.capacity());
    }

    @Override
    public IntStream intStream() {
        return slice().intStream();
    }

    @Override
    public int getInt(long index) {
        return original().getInt(adjust(index));
    }

    @Override
    public IntDataBuffer putInt(long index, int value) {
        original().putInt(adjust(index), value);
        return this;
    }

    @Override
    public IntDataBuffer write(int[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public IntDataBuffer read(int[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private IntMutableDataBuffer(IntDataBuffer buffer, long startIndex, long capacity) {
        super(buffer, startIndex, capacity);
    }
}
