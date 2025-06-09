package com.orangehrmdemo.springorangehrmdemo.libraries;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@Configuration
public class WebdriverCnfig {

    @Value("${selenium.browser}")
    private String browser;

    @Value("${selenium.url}")
    private String url;

    //private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

//    @Bean
//    @Scope("driverscope")
//    public WebDriver getDriver(){
//        WebDriver driver = null;
//
//        if(browser.equalsIgnoreCase("chrome")){
//            driver=new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.get(url);
//        }else if(browser.equalsIgnoreCase("edge")){
//            driver = new EdgeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.get(url);
//        }else{
//            System.out.println("please pass valid browser"+ browser);
//        }
//        return driver;
//    }

    @Bean
    @ScenarioScope
    @ConditionalOnProperty(name = "selenium.browser", havingValue = "chrome")
    public WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @ScenarioScope
    @ConditionalOnProperty(name = "selenium.browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
