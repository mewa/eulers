package com.aisd.euler;

import com.aisd.euler.components.ApplicationComponent;
import com.aisd.euler.components.DaggerApplicationComponent;
import com.aisd.euler.components.DaggerLoggerComponent;
import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;

public class Main {
	static ApplicationComponent appComponent;
	static Application app;
	static Logger logger;

	static {
		appComponent = DaggerApplicationComponent.builder()
				.loggerComponent(DaggerLoggerComponent.create()).build();
		app = appComponent.app();
		logger = app.logger();
	}

	public static void main(String[] args) {
		
		logger.log(Logger.DEBUG, "logger: " + logger);
		
		logger.log(Logger.DEBUG, "logger: " + app.logger());

//		for (int i = 0; i < 10; ++i) {
//			logger.log(Logger.DEBUG, "MEWA" + i);
//		}

		logger.log(Logger.DEBUG, "END");
	}

}
