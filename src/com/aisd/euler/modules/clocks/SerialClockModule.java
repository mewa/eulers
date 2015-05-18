package com.aisd.euler.modules.clocks;

import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.utils.SerialClock;

import dagger.Module;
import dagger.Provides;

@Module
public class SerialClockModule {

	@Provides
	IClock provideClock() {
		return new SerialClock();
	}
}
