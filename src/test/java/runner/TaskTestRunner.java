package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/resources/features",
    glue = "taskstepdefinitions",
    plugin = {"pretty","html:target/task-cucumber-reports/report.html",
            "json:target/task-cucumber-reports/cucumber.json",
            "junit:target/task-cucumber-reports/cucumber.xml"
        }
)
public class TaskTestRunner {
    
}
