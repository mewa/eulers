package com.aisd.euler.models;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import com.aisd.euler.interfaces.GraphReader;

public class MatrixGraphStream implements GraphReader {
	private Scanner data;
	
	public MatrixGraphStream(String data) {
		this.data = new Scanner(data);
	}
	
	@Override
	public int readNumberOfVertices() {
		data.reset();
		return data.nextInt();
	}

	@Override
	public int readNumberOfEdges() {
		data.reset();
		data.nextInt();
		return data.nextInt();
	}

}