package com.aisd.euler;

import javax.inject.Inject;

import junit.framework.Test;

import com.aisd.euler.components.ApplicationComponent;
import com.aisd.euler.components.DaggerApplicationComponent;
import com.aisd.euler.components.DaggerGraphComponent;
import com.aisd.euler.components.DaggerGraphPerformanceTestComponent;
import com.aisd.euler.components.DaggerLoggerComponent;
import com.aisd.euler.components.GraphPerformanceTestComponent;
import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.models.GraphMatrix;
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
				.graphComponent(DaggerGraphComponent.create()).build();
		app = appComponent.app();
		logger = app.logger();
		logger.setLogLevel(Logger.VERBOSE);
	}

	public static void main(String[] args) {
		GraphPerformanceTest test = new GraphPerformanceTest();
		test.start();

		logger.log(Logger.DEBUG, "END");
	}

	public static void inject(GraphMatrix graphMatrix) {
		appComponent.inject(graphMatrix);
	}

}
