package com.example.zbf.demo_jna;

import com.sun.jna.Native;

/**
 *
 * Created by zbf on 2018/2/1.
 */
public interface JNATest {

    JNATest JNAEcgAnalInstance = (JNATest) Native.loadLibrary("native-lib", JNATest.class);
    String stringFromJNI();



}
