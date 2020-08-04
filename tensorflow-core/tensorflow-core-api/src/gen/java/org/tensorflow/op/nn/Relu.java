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

package org.tensorflow.op.nn;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TType;

/**
 * Computes rectified linear: `max(features, 0)`.
 * <p>
 * See: https://en.wikipedia.org/wiki/Rectifier_(neural_networks)
 * Example usage:
 * >>> tf.nn.relu([-2., 0., -0., 3.]).numpy()
 * array([ 0.,  0., -0.,  3.], dtype=float32)
 * 
 * @param <T> data type for {@code activations()} output
 */
@Operator(group = "nn")
public final class Relu<T extends TType> extends RawOp implements Operand<T> {
  
  /**
   * Factory method to create a class wrapping a new Relu operation.
   * 
   * @param scope current scope
   * @param features 
   * @return a new instance of Relu
   */
  @Endpoint(describeByClass = true)
  public static <T extends TType> Relu<T> create(Scope scope, Operand<T> features) {
    OperationBuilder opBuilder = scope.env().opBuilder("Relu", scope.makeOpName("Relu"));
    opBuilder.addInput(features.asOutput(scope));
    opBuilder = scope.applyControlDependencies(opBuilder);
    return new Relu<T>(opBuilder.build());
  }
  
  /**
   */
  public Output<T> activations() {
    return activations;
  }
  
  @Override
  public Output<T> asOutput(Scope scope) {
    return activations;
  }
  
  private Output<T> activations;
  
  private Relu(Operation operation) {
    super(operation);
    int outputIdx = 0;
    activations = operation.output(outputIdx++);
  }
}
