package com.example.zbf.demo_jna;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.ShortByReference;

/**
 * Created by root on 17-3-29.
 */
public interface JNAEcgAnal extends Library {
    JNAEcgAnal JNAEcgAnalInstance = (JNAEcgAnal) Native.loadLibrary("hsrg_hr", JNAEcgAnal.class);

    public int InitEcgAnalHR(int deviceId);

    public short eaGetHr_Analysis(int deviceId, short wv1, short wv2);

    public void EndEcgAnalHR(int deviceId);

    String Test(String text);
}
