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
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.family.TType;

/**
 * Creates a dataset that skips `count` elements from the `input_dataset`.
 */
@Operator(group = "data")
public final class SkipDataset extends RawOp implements Operand<TType> {
  
  /**
   * Factory method to create a class wrapping a new SkipDataset operation.
   * 
   * @param scope current scope
   * @param inputDataset 
   * @param count A scalar representing the number of elements from the `input_dataset`
   * that should be skipped.  If count is -1, skips everything.
   * @param outputTypes 
   * @param outputShapes 
   * @return a new instance of SkipDataset
   */
  @Endpoint(describeByClass = true)
  public static SkipDataset create(Scope scope, Operand<?> inputDataset, Operand<TInt64> count, List<Class<? extends TType>> outputTypes, List<Shape> outputShapes) {
    OperationBuilder opBuilder = scope.env().opBuilder("SkipDataset", scope.makeOpName("SkipDataset"));
    opBuilder.addInput(inputDataset.asOutput());
    opBuilder.addInput(count.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    Class[] outputTypesArray = new Class[outputTypes.size()];
    for (int i = 0; i < outputTypesArray.length; ++i) {
      outputTypesArray[i] = outputTypes.get(i);
    }
    opBuilder.setAttr("output_types", outputTypesArray);
    Shape[] outputShapesArray = new Shape[outputShapes.size()];
    for (int i = 0; i < outputShapesArray.length; ++i) {
      outputShapesArray[i] = outputShapes.get(i);
    }
    opBuilder.setAttr("output_shapes", outputShapesArray);
    return new SkipDataset(opBuilder.build());
  }
  
  /**
   */
  public Output<?> handle() {
    return handle;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public Output<TType> asOutput() {
    return (Output<TType>) handle;
  }
  
  /** The name of this op, as known by TensorFlow core engine */
  public static final String OP_NAME = "SkipDataset";
  
  private Output<?> handle;
  
  private SkipDataset(Operation operation) {
    super(operation);
    int outputIdx = 0;
    handle = operation.output(outputIdx++);
  }
}
