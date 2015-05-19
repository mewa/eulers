package com.aisd.euler.modules;

import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.DAGraph;

import dagger.Module;
import dagger.Provides;

@Module
public class DAGraphModule {
	
	@Provides
	DAGraph provideGraph(Representation representation) {
		return new DAGraph(representation);
	}
	
}
