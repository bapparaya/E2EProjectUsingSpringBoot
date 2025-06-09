package com.orangehrmdemo.springorangehrmdemo.stepdefinations;

import com.orangehrmdemo.springorangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.springorangehrmdemo.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class Loginpagesteps {

    @Autowired
    LoginPage loginpage;

    @Autowired
    DashboardPage dashboardPage;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String title = loginpage.verifytitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @When("The user attempts to login with valid credentials")
    public void login_with_valid_credentials(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMaps().get(0);
        loginpage.verifylogin(credentials.get("username"), credentials.get("password"));

    }

    @When("The user attempts to login with invalid credentials")
    public void login_with_invalid_credentials(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMaps().get(0);
        loginpage.verifylogin(credentials.get("username"), credentials.get("password"));
    }

    @Then("The user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String title = dashboardPage.verifytitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Then("An error message should be displayed indicating invalid credentials")
    public void error_message_for_invalid_login() {
        String message = loginpage.invalidlogin();
        System.out.println(message);
        Assert.assertEquals(message, "Invalid credentials");
    }
}
