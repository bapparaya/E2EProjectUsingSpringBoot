package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginbtn;

    @FindBy(xpath = "//div[@class='orangehrm-login-error']/div/div/p")
    private WebElement invalidloginerror;


    public String verifytitle() {

        return driver.getTitle();

    }

    public void verifylogin(String username, String password) {

        wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();

    }

    public String invalidlogin() {
        return invalidloginerror.getText();
    }
}
