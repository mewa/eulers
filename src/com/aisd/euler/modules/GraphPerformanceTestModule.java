package com.aisd.euler.modules;

import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.utils.GraphPerformanceTest;

import dagger.Module;
import dagger.Provides;

@Module
public class GraphPerformanceTestModule {
	@Provides
	PerformanceTest providePerformanceTest() {
		return new GraphPerformanceTest();
	}
}
