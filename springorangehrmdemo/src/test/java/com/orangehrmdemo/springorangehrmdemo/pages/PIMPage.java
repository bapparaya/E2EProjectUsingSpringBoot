package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class PIMPage extends BasePage {



    @FindBy(xpath="//a[text()='Add Employee']")
    WebElement addemployeebtn;

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firnamebtn;

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastnamebtn;

    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement empid;

    @FindBy(xpath="//button[@type='submit']")
    WebElement savebtn;



    public void addEmployee(String fn, String ln, String id){
        addemployeebtn.click();
        firnamebtn.sendKeys(fn);
        lastnamebtn.sendKeys(ln);
        empid.sendKeys(id);
        savebtn.click();
        //return new EmloyeeList(driver);

    }
}
