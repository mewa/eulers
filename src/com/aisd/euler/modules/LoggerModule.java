package com.aisd.euler.modules;

import com.aisd.euler.interfaces.Logger;

import dagger.Module;
import dagger.Provides;

@Module
public class LoggerModule {

	@Provides
	Logger provideLogger() {
		return new Logger() {
			@Override
			public void write(String msg) {
				System.out.println(msg);
			}

			@Override
			public void log(int level, String msg) {
				write(msg);
			}

			@Override
			public void setLogLevel(int level) {
								
			}
		};
	}
}
