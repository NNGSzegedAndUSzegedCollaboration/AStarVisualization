package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 * Created by novak on 2016.04.14..
 */
public class NodeHeuristic {

    private static double maxspeed = Double.MIN_VALUE;

    public static void countMaxSpeed(Graph graph){
        for (Edge edge : graph.getEachEdge()){
            double distance = countDistanceBetweenNodes(edge.getNode0(),edge.getNode1());
            int time = edge.getAttribute("timeInMinutes");
            double speed = distance / time;
            if (speed > maxspeed){
                maxspeed = speed;
            }
            //System.out.println(speed);
        }
    }

    /*
    * Google:
    * http://www.math.u-szeged.hu/Geo/_site/index.php/hu/educat/stud-essays-list/category/6-ma-thesis?download=196:goembharomszoegek-es-nehany-alkalmazasuk-bemutatasa-a-lenart-goemb-segitsegevel
    * */
    private static double countDistanceBetweenNodes(Node node1, Node node2){
        double fiA = Math.toRadians((double)node1.getAttribute("x"));
        double fiB = Math.toRadians((double)node2.getAttribute("x"));
        double lambdaA = Math.toRadians((double)node1.getAttribute("y"));
        double lambdaB = Math.toRadians((double)node2.getAttribute("y"));

        double cosx = (Math.sin(fiA)*Math.sin(fiB))+(Math.cos(fiA)*Math.cos(fiB)*Math.cos(lambdaB-lambdaA));
        double distance = (Math.toDegrees(Math.acos(cosx)))*111.32;
        return distance;
    }

    public static double countHeuristic(Node node1, Node node2){
        double distance = countDistanceBetweenNodes(node1, node2);
        double time = distance / maxspeed;
        return time;
    }
}
