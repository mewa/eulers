package com.aisd.euler.modules;

import javax.inject.Singleton;

import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.OutputStream;
import com.aisd.euler.modules.clocks.NanoClockModule;
import com.aisd.euler.utils.DebugLogger;

import dagger.Module;
import dagger.Provides;

@Module(includes = { NanoClockModule.class, StandardOutputModule.class })
public class DebugLoggerModule {

	@Provides
	@Singleton
	Logger provideLogger(OutputStream stream, IClock clock) {
		return new DebugLogger(stream, clock);
	}
}
