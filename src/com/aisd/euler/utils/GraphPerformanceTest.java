package com.aisd.euler.utils;

import javax.inject.Inject;

import com.aisd.euler.Main;
import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;

public class GraphPerformanceTest extends PerformanceTest {	
	@Inject
	Logger logger;
	
	@Inject
	public GraphPerformanceTest() {
		Main.inject(this);
	}
	
	@Override
	protected void init() {
				
	}

	@Override
	protected void onFinished() {
				
	}

	@Override
	public void run() {
		logger.log(Logger.DEBUG, "Performance test started");	
	}

}
