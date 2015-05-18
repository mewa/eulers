package com.aisd.euler.modules;

import com.aisd.euler.models.DAGraph;
import com.aisd.euler.models.GraphFile;

import dagger.Module;
import dagger.Provides;

@Module
public class DAGraphModule {

	@Provides
	DAGraph provideGraph(GraphFile file) {
		return new DAGraph(file);
	}
	
}
