package com.aisd.euler.utils;

import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.PerformanceTest;
import com.aisd.euler.interfaces.Representation;

public class GraphPerformanceTest extends PerformanceTest {
	@Inject
	Logger logger;
	@Inject
	@Named("not-eulerian")
	Provider<Representation> graphProvider;
	Representation graph;
	Stack<Integer> cycleStack;
	int numberOfEdges;
	boolean run = true;

	@Inject
	public GraphPerformanceTest() {
	}

	@Override
	protected void init() {
		logger.log(Logger.VERBOSE, "Performance test init");
		cycleStack = new Stack<Integer>();
		graph = graphProvider.get();
		logger.log(Logger.VERBOSE, "Graph: " + graph);
		logger.log(Logger.VERBOSE, "Vertices: " + graph.numberOfVertices()
				+ ", Edges: " + graph.numberOfEdges());
		numberOfEdges = graph.numberOfEdges();
		if (!isEulerian(graph)) {
			run = false;
			logger.log(Logger.WARN, "Not EULERIAN");
		}
	}

	private boolean isEulerian(Representation g) {
		for (int i = 0; i < g.numberOfVertices(); ++i) {
			int parity = 0;
			for (int j = 0; j < g.numberOfVertices(); ++j) {
				if (g.hasConnection(i, j)) {
					parity++;
				}
			}
			if ((parity % 2) == 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void onFinished() {
		logger.log(Logger.INFO, "Performance test finished with time: "
				+ runtime);
	}

	@Override
	public void run() {
		logger.log(Logger.INFO, "Performance test started");
		if (!run)
			return;
		for (int i = 0; i < graph.numberOfVertices(); ++i) {
			graph = graphProvider.get();
			cycleStack.clear();
			String solution;
			// cycleStack.push(i);

			int v = i;
			solution = v + "->";
			solution += step(v);

			// result
			logger.log(Logger.DEBUG, "solution: " + solution);
			if (cycleStack.size() == numberOfEdges + 1) {
				printStack(cycleStack);
			}
		}
	}

	private String step(int v) {
		// logger.log(Logger.DEBUG, "step" + v);
		while (!isIsolated(v)) {
			int v2 = grabFirstVertex(v);
			cycleStack.push(v);
			graph.remove(v, v2);
			v = v2;
		}
		if (!cycleStack.isEmpty()) {
			// logger.log(Logger.DEBUG, "stepstak" + v);
			v = cycleStack.pop();
			return v + "->" + step(v);

		}
		return "";
	}

	private boolean isIsolated(int n) {
		int count = 0;
		for (int i = 0; i < graph.numberOfVertices(); ++i) {
			if (graph.hasConnection(n, i))
				count++;
		}
		return count == 0;
	}

	private int grabFirstVertex(int n) {
		for (int i = 0; i < graph.numberOfVertices(); ++i) {
			if (graph.hasConnection(n, i))
				return i;
		}
		return n;
	}

	private void printStack(Stack<Integer> stack) {
		StringBuilder sb = new StringBuilder();
		sb.append(stack.pop());
		while (!stack.isEmpty()) {
			sb.append("->").append(stack.pop());
		}
		logger.log(Logger.DEBUG, sb.toString());
	}

	protected void dfs(int v) {
		for (int i = 0; i < graph.numberOfVertices(); ++i) {
			if (graph.hasConnection(v, i)) {
				graph.remove(v, i);
				dfs(i);
			}
		}
		cycleStack.push(v);
	}

}
