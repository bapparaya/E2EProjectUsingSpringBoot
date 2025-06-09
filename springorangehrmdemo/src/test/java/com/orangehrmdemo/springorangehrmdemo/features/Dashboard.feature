Feature: Dashboard Menu Validation
  As a user of OrangeHRM
  I want to see all the dashboard menus after login
  So that I can navigate through the application

  Background:
    Given The user is on the login page
    And I login with username "Admin" and password "admin123"

  Scenario: Verify all dashboard menus are displayed
    Then I should see the following menus on the dashboard:
      | Admin        |
      | PIM          |
      | Leave        |
      | Time         |
      | Recruitment  |
      | My Info      |
      | Performance  |
      | Dashboard    |
      | Directory    |
      | Maintenance  |
      | Claim        |
      | Buzz         |
