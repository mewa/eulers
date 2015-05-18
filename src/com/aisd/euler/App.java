package com.aisd.euler;

import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;

public class App implements Application {

	Logger logger;
	static int serial = -1;

	public App(Logger logger) {
		this.logger = logger;
		logger.log(Logger.DEBUG, "App " + ++serial + " starting");
		logger.log(Logger.DEBUG, "Logger: " + logger);
	}

	@Override
	public final Logger logger() {
		return logger;
	}

}
