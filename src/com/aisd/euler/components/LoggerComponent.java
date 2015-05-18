package com.aisd.euler.components;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.modules.DebugLoggerModule;
import com.aisd.euler.modules.StandardOutputModule;
import com.aisd.euler.modules.clocks.SerialClockModule;

import dagger.Component;

@Component(modules = { StandardOutputModule.class, DebugLoggerModule.class,
		SerialClockModule.class })
public interface LoggerComponent {
	Logger provideLogger();
}
