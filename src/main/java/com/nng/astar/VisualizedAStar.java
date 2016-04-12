package com.nng.astar;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;

public class VisualizedAStar implements AStar {

  public Path shortestPath(Graph graph, String start, String goal) throws InterruptedException {
    graph.display();
    return null;
  }
}
