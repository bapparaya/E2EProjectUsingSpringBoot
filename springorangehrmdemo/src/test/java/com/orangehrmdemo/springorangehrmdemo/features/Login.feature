Feature: Login functionality for OrangeHRM

  Background:
    Given The user is on the login page

  Scenario: Login with valid credentials
    When The user attempts to login with valid credentials
      | username | password  |
      | Admin    | admin123  |
    Then The user should be redirected to the dashboard

  Scenario: Login with invalid credentials
    When The user attempts to login with invalid credentials
      | username | password   |
      | invalid  | wrongpass  |
    Then An error message should be displayed indicating invalid credentials
