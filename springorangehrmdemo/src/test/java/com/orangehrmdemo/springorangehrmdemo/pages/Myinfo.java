package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class Myinfo extends BasePage {

    @FindBy(xpath = "(//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]/div/div[2]/input)[2]")
    private WebElement otheridbox;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    private WebElement saveotheridbtn;

    public void ennterOtherid(String id){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("it is the page method other id"+ id);
        otheridbox.sendKeys(id);
        saveotheridbtn.click();

    }
}
