package com.aisd.euler.utils;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.interfaces.Representation;

public class GraphPerformanceTest extends PerformanceTest {
	@Inject
	Logger logger;
	@Inject
	Provider<Representation> graphProvider;
	Representation graph;

	@Inject
	public GraphPerformanceTest() {
	}

	@Override
	protected void init() {
		logger.log(Logger.VERBOSE, "Performance test init");
		graph = graphProvider.get();
		logger.log(Logger.VERBOSE, "Graph: " + graph);
		logger.log(Logger.VERBOSE, "Vertices: " + graph.numberOfVertices()
				+ ", Edges: " + graph.numberOfEdges());
	}

	@Override
	protected void onFinished() {
		logger.log(Logger.INFO, "Performance test finished with time: "
				+ runtime);
	}

	@Override
	public void run() {
		logger.log(Logger.INFO, "Performance test started");
		for (int i = 1; i < graph.numberOfVertices(); ++i) {
			graph.hasConnection(i - 1, i);
		}
	}

}
