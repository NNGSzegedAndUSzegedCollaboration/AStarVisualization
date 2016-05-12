package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

/**
 * Created by novak on 2016.04.14..
 */
public class NodeAStar {
    private Node node;
    private Edge edge;
    private double heuristic;
    private double distance;
    private double fSum;
    private NodeAStar parent;

    public NodeAStar(Node node, NodeAStar parent, Edge edge, Node end) {
        this.node = node;
        this.edge = edge;
        this.heuristic = NodeHeuristic.countHeuristic(node,end);
        this.distance = parent.distance+(int)edge.getAttribute("timeInMinutes");
        this.fSum = this.heuristic + this.distance;
        this.parent = parent;
    }
    //elso elemnek
    public NodeAStar(Node node) {
        this.node = node;
        this.edge = null;
        this.heuristic = 0.0;
        this.distance = 0.0;
        this.fSum = 0.0;
        this.parent = null;
    }

    public double getfSum() {
        return fSum;
    }

    public Node getNode() {
        return node;
    }

    public Edge getEdge() {
        return edge;
    }

    public NodeAStar getParent() {
        return parent;
    }
}
