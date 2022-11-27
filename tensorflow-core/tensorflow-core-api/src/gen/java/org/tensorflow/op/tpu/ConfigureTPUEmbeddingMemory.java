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

package org.tensorflow.op.tpu;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TString;

/**
 * An op that configures the TPUEmbedding software on a host.
 */
@OpMetadata(
    opType = ConfigureTPUEmbeddingMemory.OP_NAME,
    inputsClass = ConfigureTPUEmbeddingMemory.Inputs.class
)
@Operator(
    group = "tpu"
)
public final class ConfigureTPUEmbeddingMemory extends RawOp implements Operand<TString> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "ConfigureTPUEmbeddingMemory";

  private Output<TString> memoryConfig;

  public ConfigureTPUEmbeddingMemory(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    memoryConfig = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new ConfigureTPUEmbeddingMemory operation.
   *
   * @param scope current scope
   * @param commonConfig A string-encoded CommonConfiguration proto containing metadata
   * about the TPUEmbedding partitioner output and the HBM size (in bytes) required
   * for operation.
   * @return a new instance of ConfigureTPUEmbeddingMemory
   */
  @Endpoint(
      describeByClass = true
  )
  public static ConfigureTPUEmbeddingMemory create(Scope scope, Operand<TString> commonConfig) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ConfigureTPUEmbeddingMemory");
    opBuilder.addInput(commonConfig.asOutput());
    return new ConfigureTPUEmbeddingMemory(opBuilder.build());
  }

  /**
   * Gets memoryConfig.
   * A string-encoded HbmBuffersConfig proto containing metadata about
   * the memory allocations reserved for TPUEmbedding.
   * @return memoryConfig.
   */
  public Output<TString> memoryConfig() {
    return memoryConfig;
  }

  @Override
  public Output<TString> asOutput() {
    return memoryConfig;
  }

  @OpInputsMetadata(
      outputsClass = ConfigureTPUEmbeddingMemory.class
  )
  public static class Inputs extends RawOpInputs<ConfigureTPUEmbeddingMemory> {
    /**
     * A string-encoded CommonConfiguration proto containing metadata
     * about the TPUEmbedding partitioner output and the HBM size (in bytes) required
     * for operation.
     */
    public final Operand<TString> commonConfig;

    public Inputs(GraphOperation op) {
      super(new ConfigureTPUEmbeddingMemory(op), op, Arrays.asList());
      int inputIndex = 0;
      commonConfig = (Operand<TString>) op.input(inputIndex++);
    }
  }
}
