package com.aisd.euler.modules.graph;

import java.util.Random;
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
	int serial = 0;

	@Provides
	Representation provideRepresentation(Logger logger, GraphReader reader) {
		GraphMatrix graphMatrix = new GraphMatrix(logger, reader);
		return graphMatrix;
	}

	@Provides
	@Named("not-eulerian")
	Representation provideNotEulerianRepresentation(Logger logger,
			@Named("not-eulerian") GraphReader reader) {
		GraphMatrix graphMatrix = new GraphMatrix(logger, reader);
		return graphMatrix;
	}

	@Provides
	@Named("gen")
	String genString() {
		StringBuilder sb = new StringBuilder();
		int numVerts = 10;
		generateGraph(numVerts, 20);
		sb.append(numVerts).append(" ").append(tab1.length).append("\n");
		for (int i = 0; i < tab1.length; ++i) {
			sb.append(tab1[i]).append(" ").append(tab2[i]).append("\n");
		}
		String str = sb.toString();
		System.out.println(str);
		return str;
	}

	int[] tab1;
	int[] tab2;

	void generateGraph(int numberOfVertices, int density) {
		int numbers = 0, tempNumber;
		int drawnNumbers = (density * numberOfVertices * (numberOfVertices)) / 200;
		boolean wasAlready = false;
		tab1 = new int[drawnNumbers];
		tab2 = new int[drawnNumbers];
		int x, y;
		for (int i = 0; i < numberOfVertices;) {
			x = new Random().nextInt() % numberOfVertices;
			for (int j = 0; j < numbers; j++) {
				if (tab1[j] == x)
					wasAlready = true;
			}
			if (!wasAlready) {
				tab1[i] = x;
				numbers++;
				i++;
			} else {
				wasAlready = false;
			}
		}
		for r(int i = 0; i < numberOfVertices; i++) {
			if (i == numberOfVertices - 1)
				tab2[i] = tab1[0];
			else
				tab2[i] = tab1[i + 1];
		}
		if (numbers != drawnNumbers) {
			do {
				wasAlready = false;
				x = new Random().nextInt() % numberOfVertices;
				y = new Random().nextInt() % numberOfVertices;
				for (int i = 0; i < numbers; i++) {
					if ((((tab1[i] == x) && (tab2[i] == y)) || ((tab1[i] == y) && (tab2[i] == x))))
						wasAlready = true;
					if (wasAlready)
						break;
				}
			} while (x == y || wasAlready);
			tab1[numbers] = x;
			tab2[numbers] = y;
			numbers++;
			tempNumber = x;
			do {
				if (numbers == drawnNumbers - 1) {
					tab1[numbers] = y;
					tab2[numbers] = tempNumber;
					break;
				}
				x = new Random().nextInt() % numberOfVertices;
				for (int i = 0; i < numbers; i++) {
					if (((tab1[i] == x) && (tab2[i] == y))
							|| (((tab1[i] == y) && (tab2[i] == x)) || (x == y)))
						wasAlready = true;
					if (wasAlready)
						break;
				}
				if (!wasAlready) {
					tab1[numbers] = y;
					tab2[numbers] = x;
					y = x;
					numbers++;
				} else
					wasAlready = false;
			} while (numbers < drawnNumbers);
		}
	}

	@Provides
	GraphReader provideMatrixGraphStream(@Named("gen") String str) {
		MatrixGraphStream stream = new MatrixGraphStream(str);
		return stream;
	}

	@Provides
	@Named("not-eulerian")
	GraphReader provideNotEulerianMatrixGraphStream() {
		MatrixGraphStream stream = new MatrixGraphStream("5 6\n" + "0 1 0 2\n"
				+ "1 2 1 3\n" + "2 4\n" + "3 4\n");
		return stream;
	}
}
