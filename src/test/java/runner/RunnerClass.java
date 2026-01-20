package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/AddToCart.feature",
        glue = "stepdefinition",
        plugin = {"pretty", "html:target/CucumberReport.html"}

)
public class RunnerClass {

}
