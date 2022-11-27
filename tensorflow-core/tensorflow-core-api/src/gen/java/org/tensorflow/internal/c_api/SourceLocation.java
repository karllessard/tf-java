// Targeted by JavaCPP version 1.5.8: DO NOT EDIT THIS FILE

package org.tensorflow.internal.c_api;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.tensorflow.internal.c_api.global.tensorflow.*;

// #endif

@Namespace("tensorflow") @Properties(inherit = org.tensorflow.internal.c_api.presets.tensorflow.class)
public class SourceLocation extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SourceLocation() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SourceLocation(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SourceLocation(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SourceLocation position(long position) {
        return (SourceLocation)super.position(position);
    }
    @Override public SourceLocation getPointer(long i) {
        return new SourceLocation((Pointer)this).offsetAddress(i);
    }

  public native @Cast("uint32_t") int line(); public native SourceLocation line(int setter);
  public native @Cast("const char*") BytePointer file_name(); public native SourceLocation file_name(BytePointer setter);

// #ifdef TF_INTERNAL_HAVE_BUILTIN_LINE_FILE
  public static native @ByVal SourceLocation current(@Cast("uint32_t") int line/*=__builtin_LINE()*/,
                                  @Cast("const char*") BytePointer file_name/*=__builtin_FILE()*/);
  public static native @ByVal SourceLocation current();
  public static native @ByVal SourceLocation current(@Cast("uint32_t") int line/*=__builtin_LINE()*/,
                                  String file_name/*=__builtin_FILE()*/);
// #else
// #endif
}
