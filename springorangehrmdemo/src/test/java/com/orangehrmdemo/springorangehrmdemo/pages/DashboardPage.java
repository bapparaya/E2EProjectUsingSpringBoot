package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DashboardPage extends BasePage {


    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][2]/a")
    private WebElement pimBtn;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoBtn;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li/a/span")
    private List<WebElement> allMenulinks;

    public String verifytitle() {
        return driver.getTitle();
    }

    public void clickonPIM() {
        pimBtn.click();
        //return new PIMPage(driver);
    }

    public void moveToMyInfopage() {
        myInfoBtn.click();
    }

    public List<String> verifyallmenu() {

        List<String> allmenu = new ArrayList<>();
        for (WebElement ele : allMenulinks) {
            String menu = ele.getText();
            System.out.println(menu);
            allmenu.add(menu);
        }
        return allmenu;
    }


}
