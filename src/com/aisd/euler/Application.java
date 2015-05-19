package com.aisd.euler;

import com.aisd.euler.interfaces.Logger;

public class Application implements Runnable {
	static int serial = -1;
	
	Logger logger;

	public Application(Logger logger) {
		this.logger = logger;
		logger.log(Logger.DEBUG, "App" + ++serial + " starting");
	}

	@Override
	public void run() {
		
	}

}
