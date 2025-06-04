package com.orangehrmdemo.springorangehrmdemo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebdriverCnfig {

    @Value("${selenium.browser}")
    private String browser;

    @Value("${selenium.url}")
    private String url;

    @Bean
    public WebDriver getDriver(){
        WebDriver driver = null;
        
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
        }else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
        }else{
            System.out.println("please pass valid browser"+ browser);
        }
        return driver;
    }
}
