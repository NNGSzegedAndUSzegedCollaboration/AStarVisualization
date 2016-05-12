package com.nng.astar;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;

public interface AStar {
  public Path shortestPath(Graph graph, String start, String goal) throws InterruptedException;


}
