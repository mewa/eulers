package com.aisd.euler.utils;

import javax.inject.Inject;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;

public class GraphPerformanceTest extends PerformanceTest {

	@Inject
	Logger logger;
	
	public GraphPerformanceTest() {
		
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
