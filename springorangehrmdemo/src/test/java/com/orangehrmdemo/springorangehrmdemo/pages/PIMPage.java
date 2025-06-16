package com.orangehrmdemo.springorangehrmdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PIMPage extends BasePage {


    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addemployeebtn;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firnamebtn;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastnamebtn;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement empid;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement savebtn;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement emplistbtn;

    @FindBy(xpath = "//div[@role='table']/div[2]/div/div/div[3]")
    private List<WebElement> emplistbyfname;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personaldetails;

    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 --strong\"]")
    private WebElement empfullname;

    @FindBy(xpath = "//div[@class='oxd-switch-wrapper']/label/span")
    private WebElement createLogincheckbox;

    @FindBy(xpath = "(//div[@class='oxd-form-row']/div/div/div/div[2]/input)[2]")
    private WebElement userloginid;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmpasssword;

    @FindBy(xpath = "//span[@class=\"oxd-userdropdown-tab\"]")
    private WebElement logoutmenu;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutbtn;

    @FindBy(xpath = "(//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]/div/div[2]/input)[2]")
    private WebElement otheridbox;


    public void addEmployee(String fn, String ln, String id) {
        addemployeebtn.click();
        firnamebtn.sendKeys(fn);
        lastnamebtn.sendKeys(ln);
        empid.clear();
        empid.sendKeys(id);
        savebtn.click();
        //return new EmloyeeList(driver);

    }

    public void addemployeeWithLoginDetails(String fn, String ln, String id, String login, String pwd, String confirmpwd) {
        addemployeebtn.click();
        wait.until(ExpectedConditions.visibilityOf(firnamebtn)).sendKeys(fn);
        lastnamebtn.sendKeys(ln);
        empid.clear();
        empid.sendKeys(id);
        wait.until(ExpectedConditions.elementToBeClickable(createLogincheckbox)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(userloginid)).sendKeys(login);
        password.sendKeys(pwd);
        confirmpasssword.sendKeys(confirmpwd);
        savebtn.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String personaldetails() {
        return personaldetails.getText();
    }

    public String emCreated() {
        String name = wait.until(ExpectedConditions.visibilityOf(empfullname)).getText();
        System.out.println("it id the emp full name" + name);
        return name;
    }

    public String otherempid() {
        String value = wait.until(ExpectedConditions.visibilityOf(otheridbox)).getAttribute("value");
        System.out.println("It is other empid value: " + value);
        return value;
    }


    public List<String> emplistverify() {
        emplistbtn.click();
        List<String> fnames = new ArrayList<>();
        for (WebElement elist : emplistbyfname) {
            String fname = elist.getText();
            System.out.println(fname);
            fnames.add(fname);
        }
        return fnames;
    }


    public void openEmpProfile(String empname) {
        emplistbtn.click();
        for (WebElement elist : emplistbyfname) {
            if (elist.getText().equalsIgnoreCase(empname)) {
                elist.click();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

        }

    }

    public void logOut() {
        logoutmenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutbtn)).click();
    }
}
