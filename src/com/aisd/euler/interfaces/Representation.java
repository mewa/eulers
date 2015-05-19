package com.aisd.euler.interfaces;

public interface Representation {
	public boolean hasConnection(int from, int to);
	public int numberOfVertices();
	public int numberOfEdges();
}
