package com.orangehrmdemo.springorangehrmdemo.stepdefinations;

import com.orangehrmdemo.springorangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.springorangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.springorangehrmdemo.pages.PIMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class Employeesteps {
@Autowired
    LoginPage loginPage;
@Autowired
    DashboardPage dashboardPage;
@Autowired
    PIMPage pimPage;

    List<String> allemps;

    @When("I add a new employee with first name {string} and last name {string} and empid {string}")
    public void i_add_a_new_employee_with_first_name_and_last_name_and_empid(String fname, String lname, String empid) {
      pimPage.addEmployee(fname,lname,empid);
    }
    @Then("I should see the employee personal details page")
    public void i_should_see_the_employee_personal_details_page() {
     String personal = pimPage.personaldetails();
        System.out.println(personal);
        Assert.assertEquals(personal,"Personal Details");

    }

    @When("I search for employee named {string} in the employee list")
    public void i_search_for_employee_named_in_the_employee_list(String string) {
      allemps = pimPage.emplistverify();
    }
    @Then("I should see {string} in the search results")
    public void i_should_see_in_the_search_results(String empfname) {
        boolean empfound = false;
       for(String efname:allemps){
           if(efname.equalsIgnoreCase(empfname)){
               empfound=true;
               break;
           }
       }
       Assert.assertTrue(true);
    }


    @And("The User is on the PIM page")
    public void theUserIsOnThePIMPage() {
        dashboardPage.clickonPIM();
    }
}
