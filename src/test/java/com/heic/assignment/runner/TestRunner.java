package com.heic.assignment.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/com/heic/assignment/features/",
        glue = {"com.heic.assignment.steps","com.heic.assignment.commons"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)
public class TestRunner {

}
