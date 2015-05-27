package com.aisd.euler.models;

import java.util.Arrays;
import java.util.Scanner;

import javax.inject.Inject;

import com.aisd.euler.interfaces.GraphReader;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.modules.DebugLoggerModule;

public class GraphMatrix implements Representation {
	protected int[][] matrix;
	
	Logger logger;
	GraphReader reader;
	
	public GraphMatrix(GraphMatrix matrix) {
		this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
		for (int i = 0; i < matrix.matrix.length; ++i) {
			this.matrix[i] = Arrays.copyOf(matrix.matrix[i], matrix.matrix.length);
		}
		this.logger = matrix.logger;
	}
	
	@Inject
	public GraphMatrix(Logger logger, GraphReader reader) {
		this.logger = logger;
		this.reader = reader;
		read();
	}
	
	public void read() {
		Scanner data = reader.getData();
		int numVertices = data.nextInt();
		matrix = new int[numVertices][];
		for (int i = 0; i < matrix.length; ++i) {
			matrix[i] = new int[numVertices];
		}
		int numEdges = data.nextInt();
//		logger.log(Logger.INFO, "Vertices: " + numVertices + ", Edges: " + numEdges);
		while (data.hasNext()) {
			int x = data.nextInt();
			int y = data.nextInt();
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
	}
	
	@Override
	public boolean hasConnection(int from, int to) {
		return matrix[from][to] != 0;
	}

	@Override
	public int numberOfVertices() {
		return matrix.length;
	}

	@Override
	public int numberOfEdges() {
		int count = 0;
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = i + 1; j < matrix.length; ++j) {
				if (matrix[i][j] != 0) {
					++count;
				}
			}
		}
		return count;
	}

	@Override
	public void remove(int from, int to) {
		matrix[from][to] = 0;
		matrix[to][from] = 0;
	}

}
