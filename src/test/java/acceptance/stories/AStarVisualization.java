package acceptance.stories;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import acceptance.steps.AStarVisualizationSteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class AStarVisualization extends JUnitStory {

  public AStarVisualization() {
    configuredEmbedder().embedderControls()
        .doVerboseFailures(true)
        .doVerboseFiltering(true)
        .doIgnoreFailureInStories(false)
        .doIgnoreFailureInView(false);
  }

  @Override
  public Configuration configuration() {
    return new MostUsefulConfiguration()
        .useStoryPathResolver(new CasePreservingResolver())
        .useStoryLoader(new LoadFromClasspath())
        .useStoryReporterBuilder(
            new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(getClass()))
                .withDefaultFormats()
                .withFailureTrace(true).withFailureTraceCompression(true));
  }

  @Override
  public InjectableStepsFactory stepsFactory() {
    return new InstanceStepsFactory(configuration(), new AStarVisualizationSteps());
  }
}
