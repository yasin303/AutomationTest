@web
Feature: Feature Web Demoblaze

  Scenario: Login with valid credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user enters username "suleprikitiw" in login form
    And user enters password "password123" in login form
    And user clicks login button
    Then user is on homepage should see Welcome in the navigation bar

  Scenario: Login with invalid credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user enters username "suleprikiti" in login form
    And user enters password "wrong_password" in login form
    And user clicks login button
    Then user should see invalid error message "User does not exist."

  Scenario: Login with empty credentials
    Given user is on Demoblaze homepage
    When user clicks on Log in menu
    And user clicks login button
    Then user should see invalid error message "Please fill out Username and Password."

  Scenario: Successfully checkout items
    Given user is logged in to Demoblaze
    When user clicks on "Samsung galaxy s6" product
    And user clicks Add to Cart button
    And user accepts product added popup
    And user clicks on Cart menu
    And user clicks Place Order button
    And user fills order form with following details
      | Name    | John Doe        |
      | Country | United States   |
      | City    | New York        |
      | Card    | 4111111111111111|
      | Month   | 12              |
      | Year    | 2025            |
    And user clicks Purchase button
    Then user should see success message "Thank you for your purchase!"

  Scenario: Successfully logout from the application
    Given user is logged in to Demoblaze
    When user clicks on Log out menu
    Then user should be logged out successfully