package com.example.zbf.demo_jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 *
 * Created by zbf on 2018/2/2.
 */
public interface JNAEcg extends Library {
    JNAEcg INSTANCE = Native.loadLibrary("add", JNAEcg.class);

}
