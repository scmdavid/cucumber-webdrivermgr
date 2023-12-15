package org.dev.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "org.dev.demo.steps",
   		plugin = { "json:target/cucumber/cucumber-report.json", "junit:target/cucumber/cucumber-report.xml", "pretty" }
)

public class RunCucumberIT {
}
