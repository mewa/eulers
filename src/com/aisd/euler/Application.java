package com.aisd.euler;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.utils.GraphPerformanceTest;

@Singleton
public class Application implements Runnable {
	static int serial = -1;

	Logger logger;
	@Inject Provider<Representation> matrix;
	@Inject GraphPerformanceTest test;

	@Inject
	public Application(Logger logger) {
		this.logger = logger;
		logger.log(Logger.DEBUG, "Application" + ++serial + " created");
	}

	@Override
	public void run() {
		logger.log(Logger.DEBUG, "Application starting");
		logger.log(Logger.DEBUG, "Test: " + test);
		logger.setLogLevel(Logger.VERBOSE);
		test.start();
		logger.setLogLevel(Logger.DEBUG);
	}

}
