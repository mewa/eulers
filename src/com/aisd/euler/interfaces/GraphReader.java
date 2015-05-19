package com.aisd.euler.interfaces;

import java.util.Scanner;

public interface GraphReader {
	Scanner getData();
	int readNumberOfVertices();
	int readNumberOfEdges();
}
