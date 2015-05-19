package com.aisd.euler.components;

import javax.inject.Singleton;

import com.aisd.euler.Application;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.modules.ApplicationModule;
import com.aisd.euler.modules.DebugLoggerModule;
import com.aisd.euler.modules.StandardOutputModule;
import com.aisd.euler.modules.clocks.NanoClockModule;
import com.aisd.euler.utils.GraphPerformanceTest;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DebugLoggerModule.class,
		NanoClockModule.class, StandardOutputModule.class })
public interface ApplicationComponent {
	Application app();
}
