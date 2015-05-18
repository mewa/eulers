package com.aisd.euler.modules;

import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.OutputStream;
import com.aisd.euler.utils.DebugLogger;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugLoggerModule {

	@Provides
	Logger provideLogger(OutputStream stream, IClock clock) {
		return new DebugLogger(stream, clock);
	}
}
