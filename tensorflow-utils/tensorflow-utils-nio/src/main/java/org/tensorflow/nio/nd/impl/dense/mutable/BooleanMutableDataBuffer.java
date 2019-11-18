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

import org.tensorflow.nio.buffer.BooleanDataBuffer;

/**
 * A mutable implementation of a {@link BooleanDataBuffer}
 */
public class BooleanMutableDataBuffer extends MutableDataBuffer<Boolean, BooleanDataBuffer>
    implements BooleanDataBuffer {

    /**
     * Creates a mutable view of a buffer of booleans
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static BooleanDataBuffer create(BooleanDataBuffer buffer) {
        return new BooleanMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public boolean getBoolean(long index) {
        return original().getBoolean(adjust(index));
    }

    @Override
    public BooleanDataBuffer setBoolean(boolean value, long index) {
        original().setBoolean(value, adjust(index));
        return this;
    }

    @Override
    public BooleanDataBuffer write(boolean[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public BooleanDataBuffer read(boolean[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private BooleanMutableDataBuffer(BooleanDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
