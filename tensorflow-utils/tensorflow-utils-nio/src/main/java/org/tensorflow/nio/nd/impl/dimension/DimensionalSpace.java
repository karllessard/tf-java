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

package org.tensorflow.nio.nd.impl.dimension;

import java.util.ArrayList;
import java.util.Arrays;
import org.tensorflow.nio.nd.IllegalRankException;
import org.tensorflow.nio.nd.Shape;
import org.tensorflow.nio.nd.index.Index;

public class DimensionalSpace {

  public static DimensionalSpace create(Shape shape) {
    Dimension[] dimensions = new Dimension[shape.numDimensions()];

    // Start from the last dimension, where all elements are continuous
    for (int i = dimensions.length - 1, stride = 1; i >= 0; --i) {
      dimensions[i] = new Axis(shape.size(i), stride);
      stride *= dimensions[i].size();
    }
    return new DimensionalSpace(dimensions, shape);
  }

  public DimensionalSpaceWithOffset mapTo(Index[] indices) {
    if (dimensions == null || indices.length > dimensions.length) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int dimIdx = 0;
    int newDimIdx = 0;
    int segmentationIdx = -1;
    long initialOffset = 0;

    Dimension[] newDimensions = new Dimension[dimensions.length];
    while (dimIdx < indices.length) {
      if (indices[dimIdx].isPoint()) {
        long offset = 0;
        do {
          offset += indices[dimIdx].mapCoordinate(0, dimensions[dimIdx]);
        } while (++dimIdx < indices.length && indices[dimIdx].isPoint());
        if (newDimIdx == 0) {
          initialOffset = offset;
        } else {
          newDimensions[newDimIdx - 1] = new OffsetDimension(offset, newDimensions[newDimIdx - 1]);
          segmentationIdx = newDimIdx - 1;
        }
      } else {
        Dimension newDimension = indices[dimIdx].apply(dimensions[dimIdx++]);
        newDimensions[newDimIdx] = newDimension;
        if (newDimension.isSegmented()) {
          segmentationIdx = newDimIdx;
        }
        ++newDimIdx;
      }
    }
    for (; dimIdx < dimensions.length; ++dimIdx, ++newDimIdx) {
      Dimension dim = dimensions[dimIdx];
      newDimensions[newDimIdx] = dim;
      if (dim.isSegmented()) {
        segmentationIdx = newDimIdx;
      }
    }
    return new DimensionalSpaceWithOffset(Arrays.copyOf(newDimensions, newDimIdx), segmentationIdx, initialOffset);
  }

  public DimensionalSpace from(int dimensionStart) {
    if (dimensionStart > dimensions.length) {
      throw new IndexOutOfBoundsException();
    }
    Dimension[] newDimensions = Arrays.copyOfRange(dimensions, dimensionStart, dimensions.length);
    if (segmentationIdx > dimensionStart) {
      return new DimensionalSpace(newDimensions, segmentationIdx - dimensionStart);
    }
    return new DimensionalSpace(newDimensions);
  }

  public Shape shape() {
    if (shape == null) {
      shape = shape(dimensions);
    }
    return shape;
  }

  public int size() {
    return dimensions.length;
  }

  public Dimension get(int i) {
    return dimensions[i];
  }

  public int segmentationIdx() {
    return segmentationIdx;
  }

  public long positionOf(long[] coords, boolean isValue) {
    long position = 0L;
    int dimIdx = 0;
    for (long coord : coords) {
      position += dimensions[dimIdx++].positionOf(coord);
    }
    if (isValue && dimIdx < shape.numDimensions()) {
      throw new IllegalRankException("Not a scalar value");
    }
    return position;
  }

  /** Succinct description of the shape meant for debugging. */
  @Override
  public String toString() {
    return Arrays.toString(dimensions);
  }

  DimensionalSpace(Dimension[] dimensions, int segmentationIdx) {
    this.dimensions = dimensions;
    this.segmentationIdx = segmentationIdx;
  }

  private DimensionalSpace(Dimension[] dimensions) {
    this(dimensions, -1);
  }

  private DimensionalSpace(Dimension[] dimensions, Shape shape) {
    this(dimensions);
    this.shape = shape;
  }

  private final Dimension[] dimensions;
  private final int segmentationIdx;
  private Shape shape;

  private static Shape shape(Dimension[] dimensions) {
    long[] shapeDimSizes = new long[dimensions.length];
    int i = 0;
    for (Dimension dimension : dimensions) {
      shapeDimSizes[i++] = dimension.size();
    }
    return Shape.make(shapeDimSizes);
  }
}
