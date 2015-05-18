package com.aisd.euler.modules;

import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.GraphMatrix;

import dagger.Module;
import dagger.Provides;

@Module
public class GraphMatrixRepresentationModule {
	@Provides
	Representation provideRepresentation() {
		GraphMatrix graphMatrix = new GraphMatrix();
		return graphMatrix;
	}
}
