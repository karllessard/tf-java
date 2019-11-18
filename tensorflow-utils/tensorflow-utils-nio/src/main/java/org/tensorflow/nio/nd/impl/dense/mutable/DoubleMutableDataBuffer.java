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

import java.util.stream.DoubleStream;
import org.tensorflow.nio.buffer.DoubleDataBuffer;

/**
 * A mutable implementation of a {@link DoubleDataBuffer}
 */
public class DoubleMutableDataBuffer extends MutableDataBuffer<Double, DoubleDataBuffer>
    implements DoubleDataBuffer {

    /**
     * Creates a mutable view of a buffer of doubles
     *
     * @param buffer original buffer
     * @return mutable buffer
     */
    public static DoubleDataBuffer create(DoubleDataBuffer buffer) {
        return new DoubleMutableDataBuffer(buffer, 0, buffer.size());
    }

    @Override
    public DoubleStream doubleStream() {
        return slice().doubleStream();
    }

    @Override
    public double getDouble(long index) {
        return original().getDouble(adjust(index));
    }

    @Override
    public DoubleDataBuffer setDouble(double value, long index) {
        original().setDouble(value, adjust(index));
        return this;
    }

    @Override
    public DoubleDataBuffer write(double[] src, int offset, int length) {
        slice().write(src, offset, length);
        return this;
    }

    @Override
    public DoubleDataBuffer read(double[] dst, int offset, int length) {
        slice().read(dst, offset, length);
        return this;
    }

    public DoubleMutableDataBuffer(DoubleDataBuffer buffer, long startIndex, long size) {
        super(buffer, startIndex, size);
    }
}
