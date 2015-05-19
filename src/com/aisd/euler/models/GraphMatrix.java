package com.aisd.euler.models;

import java.util.Scanner;

import javax.inject.Inject;

import com.aisd.euler.Main;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.Representation;

public class GraphMatrix implements Representation {
	protected int[][] matrix;
	@Inject
	Logger logger;
	
	public GraphMatrix() {
//		Main.inject(this);
	}
	
	public void read(Scanner data) {
		int numVertices = data.nextInt();
		matrix = new int[numVertices][];
		for (int i = 0; i < matrix.length; ++i) {
			matrix[i] = new int[numVertices];
		}
		int numEdges = data.nextInt();
		logger.log(Logger.INFO, "Vertices: " + numVertices + ", Edges: " + numEdges);
		while (data.hasNext()) {
			int x = data.nextInt();
			int y = data.nextInt();
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
	}
	
	@Override
	public boolean isConnected(int from, int to) {
		return false;
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

}
