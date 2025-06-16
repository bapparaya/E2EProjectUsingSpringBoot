package com.orangehrmdemo.springorangehrmdemo.stepdefinations;

import com.orangehrmdemo.springorangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.springorangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.springorangehrmdemo.pages.Myinfo;
import com.orangehrmdemo.springorangehrmdemo.pages.PIMPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Map;

public class UpdateMyInfoStepDefinitions {

    @Autowired
    LoginPage loginPage;
    @Autowired
    DashboardPage dashboardPage;
    @Autowired
    PIMPage pimPage;
    @Autowired
    Myinfo myinfo;


    @Given("OrangeHRM application is launched")
    public void orange_hrm_application_is_launched() {
        System.out.println("launched the browser");
    }

    @Given("Admin logs in with username {string} and password {string}")
    public void admin_logs_in_with_username_and_password(String un, String pwd) {
        loginPage.verifylogin(un, pwd);
    }

    @When("Admin navigates to the PIM page")
    public void admin_navigates_to_the_pim_page() {
        dashboardPage.clickonPIM();
    }

    @When("Admin adds a new employee with the following details:")
    public void admin_adds_a_new_employee_with_the_following_details(DataTable dataTable) {
        Map<String, String> empData = dataTable.asMap(String.class, String.class);

        String firstName = empData.get("First Name");
        String lastName = empData.get("Last Name");
        String empId = empData.get("empid");
        String username = empData.get("Username");
        String password = empData.get("Password");
        String confirmPassword = empData.get("Confirm Password");

        System.out.println(firstName + " " + lastName + " " + empId + " " + username + " " + password + " " + confirmPassword);
        pimPage.addemployeeWithLoginDetails(firstName, lastName, empId, username, password, confirmPassword);

    }

    @Then("Employee {string} should be successfully created")
    public void employee_should_be_successfully_created(String expectedempname) {
        String actualempname = pimPage.emCreated();
        System.out.println("it is the actual name " + actualempname);
        System.out.println("it is from feature file " + expectedempname);
        Assert.assertEquals(actualempname, expectedempname);
    }

    @Then("Admin logs out")
    public void admin_logs_out() {
        pimPage.logOut();
    }

    @When("Employee logs in with username {string} and password {string}")
    public void employee_logs_in_with_username_and_password(String un, String pwd) {
        loginPage.verifylogin(un, pwd);
    }

    @When("Employee navigates to {string} section")
    public void employee_navigates_to_section(String string) {
        dashboardPage.moveToMyInfopage();
    }

    @When("Employee updates personal details with:")
    public void employee_updates_personal_details_with(DataTable dataTable) {
        Map<String, String> otherId = dataTable.asMap();
        System.out.println(otherId.get("Other ID"));
        myinfo.ennterOtherid(otherId.get("Other ID"));
    }

    @Then("A success message should be displayed confirming the update")
    public void a_success_message_should_be_displayed_confirming_the_update() {
        System.out.println("added sucessfully");
    }

    @Then("Employee logs out")
    public void employee_logs_out() {
        pimPage.logOut();
    }

    @When("Admin searches for employee {string}")
    public void admin_searches_for_employee(String empFname) {
        dashboardPage.clickonPIM();
        pimPage.openEmpProfile(empFname);
    }

    @Then("The Other ID field should have value {string}")
    public void theOtherIDFieldShouldHaveValue(String expectedEmp) {
        String actualEmp = pimPage.otherempid();
        Assert.assertEquals(actualEmp, expectedEmp);
    }
}
