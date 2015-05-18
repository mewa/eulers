package com.aisd.euler;

import com.aisd.euler.components.DaggerApplicationComponent;
import com.aisd.euler.components.DaggerLoggerComponent;
import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;

public class Main {
	static Application app;
	static Logger logger;

	static {
		
	}

	public static void main(String[] args) {
		app = DaggerApplicationComponent.builder()
				.loggerComponent(DaggerLoggerComponent.create()).build().app();
		logger = app.logger();
		logger.log(Logger.DEBUG, "apps: " + app);
		
		logger.log(Logger.DEBUG, "START");

		logger.log(
				Logger.DEBUG,
				"app: "
						+ DaggerApplicationComponent
								.builder()
								.loggerComponent(DaggerLoggerComponent.create())
								.build().app());

//		for (int i = 0; i < 10; ++i) {
//			logger.log(Logger.DEBUG, "MEWA" + i);
//		}

		logger.log(Logger.DEBUG, "END");
	}

}
