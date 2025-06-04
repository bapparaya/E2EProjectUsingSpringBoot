package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {



    @FindBy(xpath="//input[@name='username']")
    WebElement username;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginbtn;


    public String  verifytitle(){
        return driver.getTitle();
    }
    public void verifylogin(String username, String password){
        //driver.getTitle();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginbtn.click();
        //return new HomePage(driver);
    }
}
