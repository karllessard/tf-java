package org.tensorflow.tools.buffer;

public interface DataBufferWindow<B extends DataBuffer<?>> {

  void slideTo(long index);

  B windowBuffer();
}
