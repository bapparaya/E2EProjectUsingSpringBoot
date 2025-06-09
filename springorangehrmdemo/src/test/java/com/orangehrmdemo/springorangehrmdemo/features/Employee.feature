Feature: Employee Management
  As an HR user
  I want to add a new employee and verify the employee appears in the employee list

  Background:
    Given The user is on the login page
    And I login with username "Admin" and password "admin123"
    And The User is on the PIM page

  Scenario: Add a new employee
    When I add a new employee with first name "Bappa" and last name "raya" and empid "1470"
    Then I should see the employee personal details page

  Scenario: Verify employee in employee list
    When I search for employee named "Bappa" in the employee list
    Then I should see "Bappa" in the search results
