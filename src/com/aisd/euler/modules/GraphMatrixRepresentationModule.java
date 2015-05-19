package com.aisd.euler.modules;

import java.util.Scanner;

import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.models.MatrixGraphStream;

import dagger.Module;
import dagger.Provides;

@Module
public class GraphMatrixRepresentationModule {

	@Provides
	Representation provideRepresentation() {
		GraphMatrix graphMatrix = new GraphMatrix();
		graphMatrix.read(new Scanner("5 5\n"
				+ "0 1 0 2 0 3 0 4\n"
				+ "1 2"));
		return graphMatrix;
	}

	@Provides
	MatrixGraphStream provideMatrixGraphStream() {
		MatrixGraphStream stream = new MatrixGraphStream("5 10");
		return stream;
	}
}
