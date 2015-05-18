package com.aisd.euler.models;

import javax.inject.Inject;

import com.aisd.euler.interfaces.Graph;
import com.aisd.euler.interfaces.Representation;

public class DAGraph extends Graph {
	Representation representation;

	@Inject
	public DAGraph(Representation representation) {
		this.representation = representation;
	}
}
