package com.orangehrmdemo.springorangehrmdemo.pages;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

    @Autowired
    WebDriver driver;

    @PostConstruct
    public void init(){
        PageFactory.initElements(driver, this);
    }

//    @PreDestroy
//    public void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
