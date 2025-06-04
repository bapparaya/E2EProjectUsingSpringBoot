package com.orangehrmdemo.springorangehrmdemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/orangehrmdemo/springorangehrmdemo/features",           // Feature file location
        glue = {"com.orangehrmdemo.springorangehrmdemo.stepdefinations"},                                // Step definitions package
        plugin = {"pretty", "html:target/cucumber-report.html"}, // Reports
        monochrome = true                                   // Readable console output
)
public class Testrunner extends AbstractTestNGCucumberTests {

}
