package com.example.zbf.demo_jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface LAddLib extends Library {
	
	LAddLib INSTANCE = (LAddLib)Native.loadLibrary("add", LAddLib.class);
	int add(int x, int y);
}

