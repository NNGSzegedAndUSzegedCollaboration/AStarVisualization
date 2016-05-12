package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class VisualizedAStar implements AStar {

  public Path shortestPath(Graph graph, String start, String goal) throws InterruptedException {
    ColouringGraph colouringGraph = new ColouringGraph(graph);
    NodeHeuristic.countMaxSpeed(graph);
    graph.display();

    PriorityQueue<NodeAStar> openSet = new PriorityQueue<>(11, new NodeComparator());
    ArrayList<NodeAStar> closedSet = new ArrayList<>();
    Node startNode = graph.getNode(start);
    Node goalNode = graph.getNode(goal);
    NodeAStar goalNodeAstar = null;

    NodeAStar nodeAStar = new NodeAStar(startNode);
    openSet.add(nodeAStar);

    while(!openSet.isEmpty()){
        //System.out.println("openSet:"+openSet.size()+" closedSet:"+closedSet.size());
        NodeAStar q = openSet.poll();
        q.getNode().setAttribute("ui.class","current");
        sleep(3000);
        if(goalNodeAstar != null && goalNodeAstar.getfSum() < q.getfSum()){
          Path path = pathCalculation(goalNodeAstar);
          colouringGraph.setPath(path);

          sleep(30000);
          return path;
        }

        for(Edge e: q.getNode().getEachEdge()){
          Node newNode = e.getNode0();
          if (q.getNode() == e.getNode0()) {
            newNode = e.getNode1();
          }
          //System.out.println("Elek:"+q.getNode()+" - "+newNode);

          NodeAStar aStarNode = new NodeAStar(newNode, q, e, goalNode);
          if (newNode == goalNode){
            if(goalNodeAstar == null){
              goalNodeAstar = aStarNode;
            }else if(aStarNode.getfSum() < goalNodeAstar.getfSum()){
              goalNodeAstar = aStarNode;
            }
          }
          NodeAStar n = searchInCollection(openSet, aStarNode);
          if (n != null){
            if(aStarNode.getfSum() < n.getfSum()){
              openSet.remove(n);
              openSet.add(aStarNode);
            }
          }else{
            n = searchInCollection(closedSet,aStarNode);
            if(n != null){
              if(aStarNode.getfSum() < n.getfSum()){
                closedSet.remove(n);
                openSet.add(aStarNode);
                aStarNode.getNode().setAttribute("ui.class","open");
                sleep(2000);
              }
            }else{
              openSet.add(aStarNode);
              aStarNode.getNode().setAttribute("ui.class", "open");
              sleep(2000);
            }
          }
        }
      closedSet.add(q);
      q.getNode().setAttribute("ui.class","close");
      sleep(2000);
    }
    sleep(5000);
    return null;
  }

  private Path pathCalculation(NodeAStar goalNodeAstar){
    Path retPath = new Path();
    NodeAStar current = goalNodeAstar;
    while(current.getParent() != null){
      retPath.add(current.getNode(), current.getEdge());
      current = current.getParent();
    }
    return retPath;
  }

  private NodeAStar searchInCollection(Collection<NodeAStar> collection, NodeAStar nodeAStar){
    for (NodeAStar n: collection){
      if (n.getNode() == nodeAStar.getNode()){
        return n;
      }
    }
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
