/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.data;

import java.util.List;
import org.tensorflow.DataType;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.Tensor;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TInt64;

/**
 * Creates a dataset with a range of values. Corresponds to python's xrange.
 */
@Operator(group = "data")
public final class RangeDataset extends RawOp implements Operand<Tensor> {
  
  /**
   * Factory method to create a class wrapping a new RangeDataset operation.
   * 
   * @param scope current scope
   * @param start corresponds to start in python's xrange().
   * @param stop corresponds to stop in python's xrange().
   * @param step corresponds to step in python's xrange().
   * @param outputTypes 
   * @param outputShapes 
   * @return a new instance of RangeDataset
   */
  @Endpoint(describeByClass = true)
  public static RangeDataset create(Scope scope, Operand<TInt64> start, Operand<TInt64> stop, Operand<TInt64> step, List<DataType<?>> outputTypes, List<Shape> outputShapes) {
    OperationBuilder opBuilder = scope.env().opBuilder("RangeDataset", scope.makeOpName("RangeDataset"));
    opBuilder.addInput(start.asOutput());
    opBuilder.addInput(stop.asOutput());
    opBuilder.addInput(step.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    DataType[] outputTypesArray = new DataType[outputTypes.size()];
    for (int i = 0; i < outputTypesArray.length; ++i) {
      outputTypesArray[i] = outputTypes.get(i);
    }
    opBuilder.setAttr("output_types", outputTypesArray);
    Shape[] outputShapesArray = new Shape[outputShapes.size()];
    for (int i = 0; i < outputShapesArray.length; ++i) {
      outputShapesArray[i] = outputShapes.get(i);
    }
    opBuilder.setAttr("output_shapes", outputShapesArray);
    return new RangeDataset(opBuilder.build());
  }
  
  /**
   */
  public Output<?> handle() {
    return handle;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public Output<Tensor> asOutput() {
    return (Output<Tensor>) handle;
  }
  
  /** The name of this op, as known by TensorFlow core engine */
  public static final String OP_NAME = "RangeDataset";
  
  private Output<?> handle;
  
  private RangeDataset(Operation operation) {
    super(operation);
    int outputIdx = 0;
    handle = operation.output(outputIdx++);
  }
}
