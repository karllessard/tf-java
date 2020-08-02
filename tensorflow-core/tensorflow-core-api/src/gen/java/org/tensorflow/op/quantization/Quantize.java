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

package org.tensorflow.op.quantization;

import org.tensorflow.DataType;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.Tensor;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TFloat32;

/**
 * Quantize the 'input' tensor of type float to 'output' tensor of type 'T'.
 * <p>
 * [min_range, max_range] are scalar floats that specify the range for
 * the 'input' data. The 'mode' attribute controls exactly which calculations are
 * used to convert the float values to their quantized equivalents.  The
 * 'round_mode' attribute controls which rounding tie-breaking algorithm is used
 * when rounding float values to their quantized equivalents.
 * <p>
 * In 'MIN_COMBINED' mode, each value of the tensor will undergo the following:
 * <pre>{@code
 * out[i] = (in[i] - min_range) * range(T) / (max_range - min_range)
 * if T == qint8: out[i] -= (range(T) + 1) / 2.0
 * }</pre>
 * here `range(T) = numeric_limits<T>::max() - numeric_limits<T>::min()`
 * <p>
 * <i>MIN_COMBINED Mode Example</i>
 * <p>
 * Assume the input is type float and has a possible range of [0.0, 6.0] and the
 * output type is quint8 ([0, 255]). The min_range and max_range values should be
 * specified as 0.0 and 6.0. Quantizing from float to quint8 will multiply each
 * value of the input by 255/6 and cast to quint8.
 * <p>
 * If the output type was qint8 ([-128, 127]), the operation will additionally
 * subtract each value by 128 prior to casting, so that the range of values aligns
 * with the range of qint8.
 * <p>
 * If the mode is 'MIN_FIRST', then this approach is used:
 * <pre>{@code
 * num_discrete_values = 1 << (# of bits in T)
 * range_adjust = num_discrete_values / (num_discrete_values - 1)
 * range = (range_max - range_min) * range_adjust
 * range_scale = num_discrete_values / range
 * quantized = round(input * range_scale) - round(range_min * range_scale) +
 *   numeric_limits<T>::min()
 * quantized = max(quantized, numeric_limits<T>::min())
 * quantized = min(quantized, numeric_limits<T>::max())
 * }</pre>
 * The biggest difference between this and MIN_COMBINED is that the minimum range
 * is rounded first, before it's subtracted from the rounded value. With
 * MIN_COMBINED, a small bias is introduced where repeated iterations of quantizing
 * and dequantizing will introduce a larger and larger error.
 * <p>
 * <i>SCALED mode Example</i>
 * <p>
 * `SCALED` mode matches the quantization approach used in
 * `QuantizeAndDequantize{V2|V3}`.
 * <p>
 * If the mode is `SCALED`, the quantization is performed by multiplying each
 * input value by a scaling_factor.
 * The scaling_factor is determined from `min_range` and `max_range` to be as large
 * as possible such that the range from `min_range` to `max_range` is representable
 * within values of type T.
 * <pre>{@code
 *   const int min_T = std::numeric_limits<T>::min();
 *   const int max_T = std::numeric_limits<T>::max();
 *   const float max_float = std::numeric_limits<float>::max();
 * 
 *   const float scale_factor_from_min_side =
 *       (min_T * min_range > 0) ? min_T / min_range : max_float;
 *   const float scale_factor_from_max_side =
 *       (max_T * max_range > 0) ? max_T / max_range : max_float;
 * 
 *   const float scale_factor = std::min(scale_factor_from_min_side,
 *                                       scale_factor_from_max_side);
 * }</pre>
 * We next use the scale_factor to adjust min_range and max_range as follows:
 * <pre>{@code
 *       min_range = min_T / scale_factor;
 *       max_range = max_T / scale_factor;
 * }</pre>
 * e.g. if T = qint8, and initially min_range = -10, and max_range = 9, we would
 * compare -128/-10.0 = 12.8 to 127/9.0 = 14.11, and set scaling_factor = 12.8
 * In this case, min_range would remain -10, but max_range would be adjusted to
 * 127 / 12.8 = 9.921875
 * <p>
 * So we will quantize input values in the range (-10, 9.921875) to (-128, 127).
 * <p>
 * The input tensor can now be quantized by clipping values to the range
 * `min_range` to `max_range`, then multiplying by scale_factor as follows:
 * <pre>{@code
 * result = round(min(max_range, max(min_range, input)) * scale_factor)
 * }</pre>
 * The adjusted `min_range` and `max_range` are returned as outputs 2 and 3 of
 * this operation. These outputs should be used as the range for any further
 * calculations.
 * <p>
 * <i>narrow_range (bool) attribute</i>
 * <p>
 * If true, we do not use the minimum quantized value.
 * i.e. for int8 the quantized output, it would be restricted to the range
 * -127..127 instead of the full -128..127 range.
 * This is provided for compatibility with certain inference backends.
 * (Only applies to SCALED mode)
 * <p>
 * <i>axis (int) attribute</i>
 * <p>
 * An optional `axis` attribute can specify a dimension index of the input tensor,
 * such that quantization ranges will be calculated and applied separately for each
 * slice of the tensor along that dimension. This is useful for per-channel
 * quantization.
 * <p>
 * If axis is specified, min_range and max_range
 * <p>
 * if `axis`=None, per-tensor quantization is performed as normal.
 * <p>
 * <i>ensure_minimum_range (float) attribute</i>
 * <p>
 * Ensures the minimum quantization range is at least this value.
 * The legacy default value for this is 0.01, but it is strongly suggested to
 * set it to 0 for new uses.
 * 
 * 
 * @param <T> data type for {@code output()} output
 */
@Operator(group = "quantization")
public final class Quantize<T extends Tensor> extends RawOp {
  
  /**
   * Optional attributes for {@link org.tensorflow.op.quantization.Quantize}
   */
  public static class Options {
    
    /**
     * @param mode 
     */
    public Options mode(String mode) {
      this.mode = mode;
      return this;
    }
    
    /**
     * @param roundMode 
     */
    public Options roundMode(String roundMode) {
      this.roundMode = roundMode;
      return this;
    }
    
    /**
     * @param narrowRange 
     */
    public Options narrowRange(Boolean narrowRange) {
      this.narrowRange = narrowRange;
      return this;
    }
    
    /**
     * @param axis 
     */
    public Options axis(Long axis) {
      this.axis = axis;
      return this;
    }
    
    /**
     * @param ensureMinimumRange 
     */
    public Options ensureMinimumRange(Float ensureMinimumRange) {
      this.ensureMinimumRange = ensureMinimumRange;
      return this;
    }
    
    private String mode;
    private String roundMode;
    private Boolean narrowRange;
    private Long axis;
    private Float ensureMinimumRange;
    
    private Options() {
    }
  }
  
  /**
   * Factory method to create a class wrapping a new Quantize operation.
   * 
   * @param scope current scope
   * @param input 
   * @param minRange The minimum value of the quantization range. This value may be adjusted by the
   * op depending on other parameters. The adjusted value is written to `output_min`.
   * If the `axis` attribute is specified, this must be a 1-D tensor whose size
   * matches the `axis` dimension of the input and output tensors.
   * @param maxRange The maximum value of the quantization range. This value may be adjusted by the
   * op depending on other parameters. The adjusted value is written to `output_max`.
   * If the `axis` attribute is specified, this must be a 1-D tensor whose size
   * matches the `axis` dimension of the input and output tensors.
   * @param T 
   * @param options carries optional attributes values
   * @return a new instance of Quantize
   */
  @Endpoint(describeByClass = true)
  public static <T extends Tensor> Quantize<T> create(Scope scope, Operand<TFloat32> input, Operand<TFloat32> minRange, Operand<TFloat32> maxRange, DataType<T> T, Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("QuantizeV2", scope.makeOpName("Quantize"));
    opBuilder.addInput(input.asOutput());
    opBuilder.addInput(minRange.asOutput());
    opBuilder.addInput(maxRange.asOutput());
    opBuilder = scope.applyControlDependencies(opBuilder);
    opBuilder.setAttr("T", T);
    if (options != null) {
      for (Options opts : options) {
        if (opts.mode != null) {
          opBuilder.setAttr("mode", opts.mode);
        }
        if (opts.roundMode != null) {
          opBuilder.setAttr("round_mode", opts.roundMode);
        }
        if (opts.narrowRange != null) {
          opBuilder.setAttr("narrow_range", opts.narrowRange);
        }
        if (opts.axis != null) {
          opBuilder.setAttr("axis", opts.axis);
        }
        if (opts.ensureMinimumRange != null) {
          opBuilder.setAttr("ensure_minimum_range", opts.ensureMinimumRange);
        }
      }
    }
    return new Quantize<T>(opBuilder.build());
  }
  
  /**
   * @param mode 
   */
  public static Options mode(String mode) {
    return new Options().mode(mode);
  }
  
  /**
   * @param roundMode 
   */
  public static Options roundMode(String roundMode) {
    return new Options().roundMode(roundMode);
  }
  
  /**
   * @param narrowRange 
   */
  public static Options narrowRange(Boolean narrowRange) {
    return new Options().narrowRange(narrowRange);
  }
  
  /**
   * @param axis 
   */
  public static Options axis(Long axis) {
    return new Options().axis(axis);
  }
  
  /**
   * @param ensureMinimumRange 
   */
  public static Options ensureMinimumRange(Float ensureMinimumRange) {
    return new Options().ensureMinimumRange(ensureMinimumRange);
  }
  
  /**
   * The quantized data produced from the float input.
   */
  public Output<T> output() {
    return output;
  }
  
  /**
   * The final quantization range minimum, used to clip input values before scaling
   * and rounding them to quantized values.
   * If the `axis` attribute is specified, this will be a 1-D tensor whose size
   * matches the `axis` dimension of the input and output tensors.
   */
  public Output<TFloat32> outputMin() {
    return outputMin;
  }
  
  /**
   * The final quantization range maximum, used to clip input values before scaling
   * and rounding them to quantized values.
   * If the `axis` attribute is specified, this will be a 1-D tensor whose size
   * matches the `axis` dimension of the input and output tensors.
   */
  public Output<TFloat32> outputMax() {
    return outputMax;
  }
  
  /** The name of this op, as known by TensorFlow core engine */
  public static final String OP_NAME = "QuantizeV2";
  
  private Output<T> output;
  private Output<TFloat32> outputMin;
  private Output<TFloat32> outputMax;
  
  private Quantize(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
    outputMin = operation.output(outputIdx++);
    outputMax = operation.output(outputIdx++);
  }
}
