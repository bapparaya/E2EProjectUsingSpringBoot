package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {


    @FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper'][2]/a")
    WebElement pimbtn;


    public void clickonPIM(){
        pimbtn.click();
        //return new PIMPage(driver);
    }

}
