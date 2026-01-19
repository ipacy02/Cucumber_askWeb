package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

//@CucumberOptions(plugin={"html:target/CucumberReport.html"})
@CucumberOptions(
        features = "src/test/resources/feature/Checkout.feature",
        glue = "stepdefinition",
        plugin={"pretty", "html:target/CucumberReport.html"}


)
public class RunnerClass {

}
