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

package org.tensorflow.op.signal;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.Tensor;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;

/**
 */
@Operator(group = "signal")
public final class BatchIfft extends RawOp implements Operand<Tensor> {
  
  /**
   * Factory method to create a class wrapping a new BatchIfft operation.
   * 
   * @param scope current scope
   * @param input 
   * @return a new instance of BatchIfft
   */
  @Endpoint(describeByClass = true)
  public static BatchIfft create(Scope scope, Operand<?> input) {
    OperationBuilder opBuilder = scope.env().opBuilder("BatchIFFT", scope.makeOpName("BatchIfft"));
    opBuilder.addInput(input.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    return new BatchIfft(opBuilder.build());
  }
  
  /**
   */
  public Output<?> output() {
    return output;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public Output<Tensor> asOutput() {
    return (Output<Tensor>) output;
  }
  
  /** The name of this op, as known by TensorFlow core engine */
  public static final String OP_NAME = "BatchIFFT";
  
  private Output<?> output;
  
  private BatchIfft(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }
}
