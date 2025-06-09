package com.orangehrmdemo.springorangehrmdemo.stepdefinations;

import com.orangehrmdemo.springorangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.springorangehrmdemo.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class Dashboardpagesteps {

    @Autowired
    LoginPage loginpage;


    @Autowired
    DashboardPage dashboardPage;

    @Given("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginpage.verifylogin(username, password);
    }

    @Then("I should see the following menus on the dashboard:")
    public void i_should_see_the_following_menus_on_the_dashboard(DataTable dataTable) {
        List<String> expectedmenu = dataTable.asList();
        List<String> actualmenus = dashboardPage.verifyallmenu();
        Assert.assertEquals(actualmenus, expectedmenu, "Mismatch in dashboard menus!");
    }
}
