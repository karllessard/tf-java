// Targeted by JavaCPP version 1.5.8: DO NOT EDIT THIS FILE

package org.tensorflow.internal.c_api;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.tensorflow.internal.c_api.global.tensorflow.*;


@Properties(inherit = org.tensorflow.internal.c_api.presets.tensorflow.class)
public class TF_TString_Union extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public TF_TString_Union() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TF_TString_Union(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TF_TString_Union(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TF_TString_Union position(long position) {
        return (TF_TString_Union)super.position(position);
    }
    @Override public TF_TString_Union getPointer(long i) {
        return new TF_TString_Union((Pointer)this).offsetAddress(i);
    }
  // NOLINT
  public native @ByRef TF_TString_Large large(); public native TF_TString_Union large(TF_TString_Large setter);
  public native @ByRef TF_TString_Offset offset(); public native TF_TString_Union offset(TF_TString_Offset setter);
  public native @ByRef TF_TString_View view(); public native TF_TString_Union view(TF_TString_View setter);
  public native @ByRef TF_TString_Raw raw(); public native TF_TString_Union raw(TF_TString_Raw setter);
}
