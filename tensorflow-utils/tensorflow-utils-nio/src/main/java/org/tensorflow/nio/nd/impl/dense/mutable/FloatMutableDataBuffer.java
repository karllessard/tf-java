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

import org.tensorflow.nio.buffer.FloatDataBuffer;

/**
 * A mutable implementation of a {@link FloatDataBuffer}
 */
public class FloatMutableDataBuffer extends
    MutableDataBuffer<Float, FloatDataBuffer>
    implements FloatDataBuffer {

    /**
     * Creates a mutable view of a buffer of floats
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static FloatDataBuffer create(FloatDataBuffer buffer) {
        return new FloatMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public float getFloat(long index) {
        return original().getFloat(adjust(index));
    }

    @Override
    public FloatDataBuffer setFloat(float value, long index) {
        original().setFloat(value, adjust(index));
        return this;
    }

    @Override
    public FloatDataBuffer write(float[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public FloatDataBuffer read(float[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    private FloatMutableDataBuffer(FloatDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
