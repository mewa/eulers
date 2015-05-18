package com.aisd.euler;

import javax.inject.Inject;

import com.aisd.euler.components.ApplicationComponent;
import com.aisd.euler.components.DaggerApplicationComponent;
import com.aisd.euler.components.DaggerGraphComponent;
import com.aisd.euler.components.DaggerGraphPerformanceTestComponent;
import com.aisd.euler.components.DaggerLoggerComponent;
import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.modules.GraphPerformanceTestModule;
import com.aisd.euler.utils.GraphPerformanceTest;

public class Main {
	static ApplicationComponent appComponent;
	static Application app;
	static Logger logger;

	public static void inject(GraphPerformanceTest obj) {
		appComponent.inject(obj);
	}

	static {
		appComponent = DaggerApplicationComponent.builder()
				.graphComponent(DaggerGraphComponent.create())
				.loggerComponent(DaggerLoggerComponent.create()).build();
		app = appComponent.app();
		logger = app.logger();
	}

	public static void main(String[] args) {
		GraphPerformanceTest test = new GraphPerformanceTest();
		appComponent.inject(test);

		test.start();
		
		logger.log(Logger.DEBUG, "END");
	}

}
