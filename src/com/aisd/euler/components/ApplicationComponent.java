package com.aisd.euler.components;

import javax.inject.Singleton;

import com.aisd.euler.interfaces.Application;
import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.models.DAGraph;
import com.aisd.euler.modules.ApplicationModule;
import com.aisd.euler.utils.GraphPerformanceTest;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }, dependencies = {
		LoggerComponent.class, GraphComponent.class })
public interface ApplicationComponent {
	Application app();
	void inject(GraphPerformanceTest obj);
}
