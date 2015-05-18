package com.aisd.euler.modules.clocks;

import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.utils.NanoClock;

import dagger.Module;
import dagger.Provides;

@Module
public class NanoClockModule {

	@Provides
	IClock provideClock() {
		return new NanoClock();
	}
}
