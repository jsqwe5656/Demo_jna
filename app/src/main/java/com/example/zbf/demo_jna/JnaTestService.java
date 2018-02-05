package com.example.zbf.demo_jna;

/**
 *
 * Created by zbf on 2018/2/1.
 */

public class JnaTestService {
    private JNATest jnaEcgAnal = JNATest.JNAEcgAnalInstance;
    public String getWord(){
        return jnaEcgAnal.stringFromJNI();
    }
}
