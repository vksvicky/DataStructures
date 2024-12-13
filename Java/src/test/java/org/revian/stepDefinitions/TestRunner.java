package org.revian.stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources")
@CucumberOptions(
        features = "../../test/resources",
        glue = "org.revian.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
    // This class will run all the Cucumber tests
}

