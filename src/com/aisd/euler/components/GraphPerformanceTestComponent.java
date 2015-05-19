package com.aisd.euler.components;

import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.modules.GraphPerformanceTestModule;

import dagger.Component;

@Component(modules = { GraphPerformanceTestModule.class }, dependencies = { GraphComponent.class })
public interface GraphPerformanceTestComponent {
	PerformanceTest providePerformanceTest();
}
