package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbtn;

    @FindBy(xpath = "//div[@class='orangehrm-login-error']/div/div/p")
    WebElement invalidloginerror;


    public String verifytitle() {

        return driver.getTitle();

    }

    public void verifylogin(String username, String password) {
        //driver.getTitle();

//        this.username.sendKeys(username);
//        this.password.sendKeys(password);
//        loginbtn.click();

        wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
        //return new HomePage(driver);
    }

    public String invalidlogin() {
        return invalidloginerror.getText();
    }
}
