package com.nng.astar;

import org.graphstream.graph.Node;

import java.util.Comparator;

/**
 * Created by novak on 2016.04.14..
 */
public class NodeComparator implements Comparator<NodeAStar> {

    @Override
    public int compare(NodeAStar node1, NodeAStar node2) {
        if(node1.getfSum() < node2.getfSum()){
            return -1;
        }
        if(node1.getfSum() > node2.getfSum()){
            return 1;
        }
        return 0;
    }
}
