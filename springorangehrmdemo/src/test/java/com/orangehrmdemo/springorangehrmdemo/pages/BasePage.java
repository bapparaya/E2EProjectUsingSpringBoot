package com.orangehrmdemo.springorangehrmdemo.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

public class BasePage {

    @Autowired
    protected WebDriver driver;

    protected WebDriverWait wait;

    @Value("${application.timeout:10}")
    protected int timeout;


    @PostConstruct
    public void init() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been injected. Check your configuration.");
        } else {
            PageFactory.initElements(driver, this);
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

//    @PreDestroy
//    public void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
