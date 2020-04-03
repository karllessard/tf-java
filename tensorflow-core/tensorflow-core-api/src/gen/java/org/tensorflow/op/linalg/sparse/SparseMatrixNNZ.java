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

package org.tensorflow.op.linalg.sparse;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TInt32;

/**
 * Returns the number of nonzeroes of `sparse_matrix`.
 */
public final class SparseMatrixNNZ extends RawOp implements Operand<TInt32> {
  
  /**
   * Factory method to create a class wrapping a new SparseMatrixNNZ operation.
   * 
   * @param scope current scope
   * @param sparseMatrix A CSRSparseMatrix.
   * @return a new instance of SparseMatrixNNZ
   */
  @Endpoint(describeByClass = true)
  public static SparseMatrixNNZ create(Scope scope, Operand<?> sparseMatrix) {
    OperationBuilder opBuilder = scope.env().opBuilder("SparseMatrixNNZ", scope.makeOpName("SparseMatrixNNZ"));
    opBuilder.addInput(sparseMatrix.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    return new SparseMatrixNNZ(opBuilder.build());
  }
  
  /**
   * The number of nonzeroes of `sparse_matrix`.
   */
  public Output<TInt32> nnz() {
    return nnz;
  }
  
  @Override
  public Output<TInt32> asOutput() {
    return nnz;
  }
  
  private Output<TInt32> nnz;
  
  private SparseMatrixNNZ(Operation operation) {
    super(operation);
    int outputIdx = 0;
    nnz = operation.output(outputIdx++);
  }
}
