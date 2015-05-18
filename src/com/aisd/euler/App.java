package com.aisd.euler;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.models.DAGraph;

public class App implements Application {
	static int serial = -1;
	
	Logger logger;

	public App(Logger logger) {
		this.logger = logger;
		logger.log(Logger.DEBUG, "App" + ++serial + " starting");
	}

	@Override
	public final Logger logger() {
		return logger;
	}

}
