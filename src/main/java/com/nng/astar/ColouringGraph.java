package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;

/**
 * Created by novak on 2016.04.16..
 */
public class ColouringGraph {
    private Graph graph;
    private Path path;

    public ColouringGraph(Graph graph) {
        this.graph = graph;
        this.path = null;
        String nodeStyleSheet = "node {	fill-color: black;}" +
                "node.open {fill-color: red;}"+
                "node.close {fill-color: blue;}"+
                "node.current {fill-color: green;}";
        String edgeStyleSheet = "edge { fill-color: black; }"+
                "edge.path {fill-color: red;}";
        graph.addAttribute("ui.stylesheet", nodeStyleSheet+edgeStyleSheet);
    }

    public void setPath(Path path) {
        this.path = path;
        for(Edge e: path.getEachEdge()){
            e.setAttribute("ui.class", "path");
        }
    }
}

