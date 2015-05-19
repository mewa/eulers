package com.aisd.euler.modules;

import javax.inject.Singleton;

import com.aisd.euler.Application;
import com.aisd.euler.interfaces.Logger;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
	
	@Provides
	@Singleton
	Application provideApplication(Logger logger) {
		return new Application(logger);
	}
}
