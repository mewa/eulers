package com.aisd.euler.interfaces;

public interface Representation {
	public boolean isConnected(int from, int to);
	public int numberOfVertices();
	public int numberOfEdges();
}
