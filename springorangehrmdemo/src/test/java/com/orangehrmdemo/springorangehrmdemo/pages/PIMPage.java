package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement emplistbtn;

    @FindBy(xpath = "//div[@role='table']/div[2]/div/div/div[3]")
    List<WebElement> emplistbyfname;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    WebElement personaldetails;



    public void addEmployee(String fn, String ln, String id){
        addemployeebtn.click();
        firnamebtn.sendKeys(fn);
        lastnamebtn.sendKeys(ln);
        empid.clear();
        empid.sendKeys(id);
        savebtn.click();
        //return new EmloyeeList(driver);

    }

    public String personaldetails(){
        return personaldetails.getText();
    }

    public List<String> emplistverify(){
        emplistbtn.click();
        List<String> fnames = new ArrayList<>();
       for(WebElement elist: emplistbyfname){
           String fname = elist.getText();
           System.out.println(fname);
           fnames.add(fname);
       }
       return fnames;
    }
}
