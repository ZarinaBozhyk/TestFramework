package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * #Summary:
 * #Author: Zarina Bozhyk
 * #Author’s Email:
 * #Creation Date: 3/22/2020
 * #Comments:
 */
@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/features"},
        tags = {"not @Ignore"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber",
                "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
        }
)
public class MainRunner {
}