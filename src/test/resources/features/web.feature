@login
Feature: Feature Web Demoblaze

  @valid-login
  Scenario: Login with valid credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user enters username "suleprikitiw" in login form
    And user enters password "password123" in login form
    And user clicks login button
    Then user is on homepage should see Welcome in the navigation bar

  @invalid-login
  Scenario: Login with invalid credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user enters username "suleprikiti" in login form
    And user enters password "wrong_password" in login form
    And user clicks login button
    Then user should see invalid error message "User does not exist."

  @empty-credentials
  Scenario: Login with empty credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user clicks login button
    Then user should see invalid error message "Please fill out Username and Password."

  @logout
  Scenario: Successfully logout from the application
    Given user is logged in to Demoblaze
    When user clicks on Log out menu
    Then user should be logged out successfully