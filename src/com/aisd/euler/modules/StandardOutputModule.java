package com.aisd.euler.modules;

import javax.inject.Singleton;

import com.aisd.euler.interfaces.OutputStream;
import com.aisd.euler.utils.StandardOutput;

import dagger.Module;
import dagger.Provides;

@Module
public class StandardOutputModule {
	@Provides
	@Singleton
	OutputStream provideOutputStream() {
		return new StandardOutput();
	}
}
