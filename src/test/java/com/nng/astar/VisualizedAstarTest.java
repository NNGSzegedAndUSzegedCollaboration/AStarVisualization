package com.nng.astar;

import org.graphstream.graph.Graph;
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
    Graph graph = Mockito.mock(Graph.class);
    visualizedAstar.shortestPath(graph, "", "");
    Mockito.verify(graph).display();
  }

}
