package com.aisd.euler.modules.graph;

import java.util.Scanner;

import javax.inject.Named;

import com.aisd.euler.interfaces.GraphReader;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.models.MatrixGraphStream;

import dagger.Module;
import dagger.Provides;

@Module
public class GraphMatrixRepresentationModule {

	@Provides
	Representation provideRepresentation(Logger logger, GraphReader reader) {
		GraphMatrix graphMatrix = new GraphMatrix(logger, reader);
		return graphMatrix;
	}

	@Provides
	GraphReader provideMatrixGraphStream() {
		MatrixGraphStream stream = new MatrixGraphStream("5 6\n"
				+ "0 1 0 2\n"
				+ "1 2\n"
				+ "2 3 2 4\n"
				+ "3 4\n");
		return stream;
	}
}
