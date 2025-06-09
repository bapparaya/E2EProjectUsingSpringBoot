package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DashboardPage extends BasePage {


    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][2]/a")
    WebElement pimbtn;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li/a/span")
    List<WebElement> allmenulinks;

    public String verifytitle() {
        return driver.getTitle();
    }

    public void clickonPIM() {
        pimbtn.click();
        //return new PIMPage(driver);
    }

    public List<String> verifyallmenu() {

        List<String> allmenu = new ArrayList<>();
        for (WebElement ele : allmenulinks) {
            String menu = ele.getText();
            System.out.println(menu);
            allmenu.add(menu);
        }
        return allmenu;
    }


}
