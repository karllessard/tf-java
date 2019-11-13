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
package org.tensorflow.nio.nd.impl.dense;

import java.util.concurrent.atomic.AtomicLong;
import org.tensorflow.nio.buffer.DataBuffer;
import org.tensorflow.nio.nd.NdArray;

final class BulkDataTransfer {

  static <T> boolean execute(AbstractDenseNdArray<T, ?> src, DataBuffer<T> dst) {
    if (src.dimensions().isSegmented()) {
      return executeBySegment(src, (b, c, off) -> b.copyTo(dst.offset(off)));
    }
    src.buffer().copyTo(dst);
    return true;
  }

  static <T> boolean execute(DataBuffer<T> src, NdArray<T> d) {
    if (!(d instanceof AbstractDenseNdArray)) {
      return false;
    }
    AbstractDenseNdArray<T, ?> dst = (AbstractDenseNdArray<T, ?>)d;
    if (dst.dimensions().isSegmented()) {
      return executeBySegment(dst, (b, c, off) -> src.offset(off).copyTo(b));
    }
    src.copyTo(dst.buffer());
    return true;
}

  static <T> boolean execute(AbstractDenseNdArray<T, ?> src, NdArray<T> d) {
    if (!(d instanceof AbstractDenseNdArray)) {
      return false;
    }
    AbstractDenseNdArray<T, ?> dst = (AbstractDenseNdArray<T, ?>)d;
    if (src.dimensions().isSegmented() || dst.dimensions().isSegmented()) {
      // Execute bulk copy on the smallest continuous segment available in any of the arrays
      if (src.dimensions().getLastSegmentedDimensionIdx() > dst.dimensions().getLastSegmentedDimensionIdx()) {
        return executeBySegment(src, (b, c, off) -> b.copyTo(((AbstractDenseNdArray<T, ?>)dst.get(c)).buffer()));
      }
      return executeBySegment(dst, (b, c, off) -> ((AbstractDenseNdArray<T, ?>)src.get(c)).buffer().copyTo(b));
    }
    src.buffer().copyTo(dst.buffer());
    return true;
  }

  @FunctionalInterface
  private interface BulkCopy<T> {
    void accept(DataBuffer<T> elementBuffer, long[] elementCoords, long valuesCopied);
  }

  private static <T> boolean executeBySegment(AbstractDenseNdArray<T, ?> array, BulkCopy<T> bulkCopy) {
    int dimensionIdx = array.dimensions().getLastSegmentedDimensionIdx() + 1;
    if (dimensionIdx == array.dimensions().size()) {
      return false;  // bulk copy not possible, last dimension is segmented
    }
    long bulkCopySize = array.dimensions().get(dimensionIdx).stride();
    AtomicLong copyCounter = new AtomicLong();
    array.elements(dimensionIdx).forEachIdx((coords, e) ->
      bulkCopy.accept(((AbstractDenseNdArray<T, ?>)e).buffer(), coords, copyCounter.getAndIncrement() * bulkCopySize)
    );
    return true;
  }
}
