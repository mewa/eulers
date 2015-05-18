package com.aisd.euler.utils;

import com.aisd.euler.interfaces.IClock;

public class SerialClock implements IClock {
	long serial = -1;
	
	@Override
	public long time() {
		return ++serial;
	}

}
