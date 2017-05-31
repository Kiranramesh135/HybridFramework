

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/resources/Specifications/" }, plugin = { "pretty", "html:target/cucumber/",
        "json:target/cucumber.json" }
//, tags = { "@test1" }
// ,glue = {"helpers","com.hybridframework.stepdefinitions"}
)
public class CucumberRunnerTest {
	
}
