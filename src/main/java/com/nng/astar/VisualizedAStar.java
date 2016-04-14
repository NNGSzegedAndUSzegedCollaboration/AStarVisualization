package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class VisualizedAStar implements AStar {

  public Path shortestPath(Graph graph, String start, String goal) throws InterruptedException {
    NodeHeuristic.countMaxSpeed(graph);
    graph.display();

    PriorityQueue<NodeAStar> openSet = new PriorityQueue<>(11, new NodeComparator());
    ArrayList<NodeAStar> closedSet = new ArrayList<>();
    Node startNode = graph.getNode(start);
    Node goalNode = graph.getNode(goal);
    NodeAStar nodeAStar = new NodeAStar(startNode);

    openSet.add(nodeAStar);
    while(!openSet.isEmpty()){
        NodeAStar q = openSet.poll();
      //TODO
        for(Edge e: q.getNode().getEachEdge()){
          Node newNode = e.getNode0();
          if (q == e.getNode0()) {
            newNode = e.getNode1();
          }
          //TODO


        }

    }


    sleep(5000);
    return null;
  }

  private void sleep(long miliSec){
    try {
      //int i = System.in.read();
      Thread.sleep(miliSec);
    } catch (Exception ex) {

    }
  }

}
