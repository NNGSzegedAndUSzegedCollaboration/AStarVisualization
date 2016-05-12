package com.nng.astar;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VisualizedAstarTest {

  private VisualizedAStar visualizedAstar;

  @Before
  public void setUp() {
    visualizedAstar = new VisualizedAStar();
  }

  @Test
  public void graphIsDisplayedProperly() throws InterruptedException {
    /*Graph graph = Mockito.mock(Graph.class);
    visualizedAstar.shortestPath(graph, "", "");
    Mockito.verify(graph).display();*/

    Graph graph = new SingleGraph("Graf");

    Node n = graph.addNode("Szeged");
    n.addAttribute("ui.label", "Szeged");
    n.addAttribute("x", 46.253170);
    n.addAttribute("y", 20.150205);

    n = graph.addNode("H�dmez�v�s�rhely");
    n.addAttribute("ui.label", "H�dmez�v�s�rhely");
    n.addAttribute("x", 46.414691);
    n.addAttribute("y", 20.318424);

    n = graph.addNode("Mak�");
    n.addAttribute("ui.label", "Mak�");
    n.addAttribute("x", 46.215120);
    n.addAttribute("y", 20.478761);

    n = graph.addNode("Orosh�za");
    n.addAttribute("ui.label", "Orosh�za");
    n.addAttribute("x", 46.557642);
    n.addAttribute("y", 20.670273);

    n = graph.addNode("B�k�scsaba");
    n.addAttribute("ui.label", "B�k�scsaba");
    n.addAttribute("x", 46.680143);
    n.addAttribute("y", 21.098212);

    Edge e = graph.addEdge("A", "Szeged", "H�dmez�v�s�rhely");
    e.addAttribute("ui.label", "25min");
    e.addAttribute("timeInMinutes", 25);

    e = graph.addEdge("B", "H�dmez�v�s�rhely", "Orosh�za");
    e.addAttribute("ui.label", "29min");
    e.addAttribute("timeInMinutes", 29);

    e = graph.addEdge("C", "Orosh�za", "B�k�scsaba");
    e.addAttribute("ui.label", "34min");
    e.addAttribute("timeInMinutes", 34);

    e = graph.addEdge("D", "Szeged", "Mak�");
    e.addAttribute("ui.label", "30min");
    e.addAttribute("timeInMinutes", 30);

    e = graph.addEdge("E", "Mak�", "B�k�scsaba");
    e.addAttribute("ui.label", "63min");
    e.addAttribute("timeInMinutes", 63);

    e = graph.addEdge("F", "Mak�", "Orosh�za");
    e.addAttribute("ui.label", "46min");
    e.addAttribute("timeInMinutes", 46);

    e = graph.addEdge("G", "Mak�", "H�dmez�v�s�rhely");
    e.addAttribute("ui.label", "27min");
    e.addAttribute("timeInMinutes", 27);

    //graph.display();

    visualizedAstar.shortestPath(graph, "Szeged", "B�k�scsaba");





  }

}
