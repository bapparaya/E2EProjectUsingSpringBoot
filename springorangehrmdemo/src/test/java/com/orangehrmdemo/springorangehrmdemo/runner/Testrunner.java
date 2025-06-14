package com.orangehrmdemo.springorangehrmdemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/orangehrmdemo/springorangehrmdemo/features/UpdateMyinfo.feature",           // Feature file location
        glue = {"com.orangehrmdemo.springorangehrmdemo.stepdefinations"},                                // Step definitions package
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class Testrunner extends AbstractTestNGCucumberTests {

}
