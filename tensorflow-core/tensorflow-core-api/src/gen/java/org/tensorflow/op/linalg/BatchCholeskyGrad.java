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

package org.tensorflow.op.linalg;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.Tensor;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TNumber;

/**
 * @param <T> data type for {@code output()} output
 */
@Operator(group = "linalg")
public final class BatchCholeskyGrad<T extends Tensor & TNumber> extends RawOp implements Operand<T> {
  
  /**
   * Factory method to create a class wrapping a new BatchCholeskyGrad operation.
   * 
   * @param scope current scope
   * @param l 
   * @param grad 
   * @return a new instance of BatchCholeskyGrad
   */
  @Endpoint(describeByClass = true)
  public static <T extends Tensor & TNumber> BatchCholeskyGrad<T> create(Scope scope, Operand<T> l, Operand<T> grad) {
    OperationBuilder opBuilder = scope.env().opBuilder("BatchCholeskyGrad", scope.makeOpName("BatchCholeskyGrad"));
    opBuilder.addInput(l.asOutput());
    opBuilder.addInput(grad.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    return new BatchCholeskyGrad<T>(opBuilder.build());
  }
  
  /**
   */
  public Output<T> output() {
    return output;
  }
  
  @Override
  public Output<T> asOutput() {
    return output;
  }
  
  /** The name of this op, as known by TensorFlow core engine */
  public static final String OP_NAME = "BatchCholeskyGrad";
  
  private Output<T> output;
  
  private BatchCholeskyGrad(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }
}
