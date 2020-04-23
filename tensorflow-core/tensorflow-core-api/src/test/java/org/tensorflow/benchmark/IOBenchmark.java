package org.tensorflow.benchmark;

import static org.tensorflow.tools.ndarray.NdArrays.vectorOf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.indexer.FloatIndexer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;
import org.tensorflow.TensorFlow;
import org.tensorflow.tools.Shape;
import org.tensorflow.tools.buffer.FloatDataBuffer;
import org.tensorflow.tools.buffer.impl.raw.RawDataBufferFactory;
import org.tensorflow.tools.ndarray.FloatNdArray;
import org.tensorflow.tools.ndarray.NdArrays;

@Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx5G"})//, "-XX:+PrintCompilation", "-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining"})
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@State(Scope.Benchmark)
public class IOBenchmark {

  public static void main(String[] args) throws IOException, RunnerException {
    org.openjdk.jmh.Main.main(args);
  }

  @Setup
  public void setup() {
    TensorFlow.version();
  }

/*
  @Benchmark
  public void javaCppIndexersTest2() {
    //long time = System.nanoTime();
    FloatPointer largePointer = new FloatPointer(1024 * 1024 * 1024);
    FloatIndexer largeIndexer = FloatIndexer.create(largePointer, 1024, 1024, 1024);
    for (int i = 0; i < 1024; i++) {
      for (int j = 0; j < 1024; j++) {
        for (int k = 0; k < 1024; k++) {
          largeIndexer.put(new long[] {i, j, k}, 2 * largeIndexer.get(new long[] {i, j, k}));
        }
      }
    }
    //System.out.println("Took " + (System.nanoTime() - time) / 1000000 + " ms");
  }
*/
  @Benchmark
  public void ndArrayIterationTest() {
    FloatDataBuffer largeBuffer = new JavaCppDataBufferFactory().createFloatBuffer(1024 * 1024 * 1024);
    FloatNdArray largeNdArray = NdArrays.wrap(Shape.of(1024, 1024, 1024), largeBuffer);
    for (int i = 0; i < 1024; ++i) {
      for (int j = 0; j < 1024; ++j) {
        for (int k = 0; k < 1024; ++k) {
          largeNdArray.setFloat(largeNdArray.getFloat(i, j, k), i, j, k);
        }
      }
    }
  }
 /*
  @Benchmark
  public void ndArraySequenceTest() {
    FloatDataBuffer largeBuffer = new JavaCppDataBufferFactory().createFloatBuffer(1024 * 1024 * 1024);
    FloatNdArray largeNdArray = NdArrays.wrap(Shape.of(1024, 1024, 1024), largeBuffer);
    largeNdArray.scalars().forEach(s -> {
      s.setFloat(s.getFloat() * 2);
    });
  }

  @Benchmark
  public void ndArrayIndexedSequenceTest() {
    FloatDataBuffer largeBuffer = new JavaCppDataBufferFactory().createFloatBuffer(1024 * 1024 * 1024);
    FloatNdArray largeNdArray = NdArrays.wrap(Shape.of(1024, 1024, 1024), largeBuffer);
    largeNdArray.scalars().forEachIndexed((ind, s) -> {
      s.setFloat(s.getFloat() * 2);
    });
  }


  @Benchmark
  public void javaCppIndexersTest() {
    FloatPointer largePointer = new FloatPointer(1024 * 1024 * 1024);
    FloatIndexer largeIndexer = FloatIndexer.create(largePointer, 1024, 1024, 1024);
    for (int i = 0; i < 1024; i++) {
      for (int j = 0; j < 1024; j++) {
        for (int k = 0; k < 1024; k++) {
          largeIndexer.put(i, j, k, 2 * largeIndexer.get(i, j, k));
        }
      }
    }
  }
*/
  private class JavaCppDataBufferFactory extends RawDataBufferFactory {

    // Keep reference to created pointers, only for this test
    private List<Pointer> allocatedPointers = new ArrayList<>();

    FloatDataBuffer createFloatBuffer(long size) {
      FloatPointer ptr = new FloatPointer(size);
      allocatedPointers.add(ptr);
      return mapNativeFloats(ptr.address(), ptr.capacity() * Float.BYTES, false);
    }
  }
}
