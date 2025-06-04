package com.orangehrmdemo.springorangehrmdemo.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public class Hooks {

    @Autowired
    WebDriver driver;

    @Before
    public void initialize(Scenario scenario){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(Scenario scenario){
//        if (scenario.isFailed()) {
//            try {
//                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", "Failure Screenshot");
//            } catch (Exception e) {
//                System.err.println("Screenshot capture failed: " + e.getMessage());
//            }
//        }
        if (driver != null) {
            driver.quit();
        }
    }
}
