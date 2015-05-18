package com.aisd.euler.utils;

import com.aisd.euler.interfaces.IClock;

public class NanoClock implements IClock {

	@Override
	public long time() {
		return System.nanoTime();
	}

}
