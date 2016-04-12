package acceptance.steps;

import java.util.List;
import java.util.stream.Collectors;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.nng.astar.VisualizedAStar;

public class AStarVisualizationSteps {

  private Graph graph;
  private Path shortestPath;

  @Given("a graph $graphName")
  public void givenAGraphMap(String graphName) {
    graph = new SingleGraph(graphName);
  }

  @Given("an edge between $from and $to that takes $timeInMinutes min")
  public void givenAnEdge(String from, String to, int timeInMinutes) {
    graph.addEdge(from + '-' + to, from, to);
  }

  @Given("a node $nodeName at $y, $x")
  public void givenANode(String nodeName, float y, float x) {
    graph.addNode(nodeName).addAttribute("xyz", x, y, 0);
  }

  @When("A* is run to find the shortest path from $start to $goal")
  public void whenAStarIsRunToFindTheShortestPath(String start, String goal) throws InterruptedException {
    shortestPath = new VisualizedAStar().shortestPath(graph, start, goal);
  }

  @Then("it returns the path through $nodes")
  public void thenItReturnsPath(List<String> nodes) {
    shortestPath.getNodePath().stream()
        .map(n -> n.getId())
        .collect(Collectors.toList())
        .equals(nodes);
  }
}
