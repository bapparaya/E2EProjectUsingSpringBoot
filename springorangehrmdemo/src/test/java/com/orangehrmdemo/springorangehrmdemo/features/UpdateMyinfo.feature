Feature: Employee creation and profile update verification

  Background:
    Given OrangeHRM application is launched

  Scenario: Admin creates employee with login credentials and verifies profile update
    Given Admin logs in with username "Admin" and password "admin123"
    When Admin navigates to the PIM page
    And Admin adds a new employee with the following details:
      | First Name     | Bappa       |
      | Last Name      | raya        |
      | Create Login   | true       |
      | Username       | Bapparaya   |
      | Password       | Bappa@123   |
      | Confirm Password | Bappa@123 |
    Then Employee "Bapparaya" should be successfully created
    And Admin logs out

    When Employee logs in with username "Bapparaya" and password "Bappa@123"
    And Employee navigates to "My Info" section
    And Employee updates personal details with:
      | Other ID | EMP-98765 |
    Then A success message should be displayed confirming the update
    And Employee logs out

    When Admin logs in with username "Admin" and password "admin123"
    And Admin searches for employee "Bapparaya"
    And Admin opens the employee's personal details
    Then The "Other ID" field should have value "EMP-98765"
