package org.tensorflow.tools.buffer.impl.raw;

import org.tensorflow.tools.buffer.DataBuffer;
import org.tensorflow.tools.buffer.DataBufferWindow;

public class RawDataBufferWindow<B extends DataBuffer<?>, R extends AbstractRawDataBuffer<?, B>> implements DataBufferWindow<B> {

  @Override
  public void slideTo(long index) {
    windowMemory.relocate(index);
  }

  @Override
  public B windowBuffer() {
    return (B)windowBuffer;
  }

  RawDataBufferWindow(R windowBuffer) {
    this.windowBuffer = windowBuffer;
    this.windowMemory = windowBuffer.memory;
  }

  private final R windowBuffer;
  private final UnsafeMemoryHandle windowMemory;
}
