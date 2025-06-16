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
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            if (driver == null) {
                System.out.println("Driver is null. Cannot take screenshot.");
            } else if (!(driver instanceof TakesScreenshot)) {
                System.out.println("Driver does not support screenshots.");
            } else {
                try {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                    System.out.println("Screenshot taken and attached to scenario.");
                    // Save screenshot to local directory
                    java.nio.file.Path screenshotsDir = java.nio.file.Paths.get("screenshots");
                    if (!java.nio.file.Files.exists(screenshotsDir)) {
                        java.nio.file.Files.createDirectories(screenshotsDir);
                    }
                    String fileName = "screenshot-" + scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_") + "-" + System.currentTimeMillis() + ".png";
                    java.nio.file.Path screenshotPath = screenshotsDir.resolve(fileName);
                    java.nio.file.Files.write(screenshotPath, screenshot);
                    System.out.println("Screenshot saved to: " + screenshotPath.toAbsolutePath());
                } catch (Exception e) {
                    System.out.println("Screenshot capture or save failed: " + e.getMessage());
                }
            }
        }
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit after scenario.");
        }
    }
}
