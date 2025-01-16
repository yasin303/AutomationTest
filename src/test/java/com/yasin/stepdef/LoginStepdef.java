package com.yasin.stepdef;

import com.yasin.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class LoginStepdef extends BaseTest {
    LoginPage loginPage;

    @Given("user is on Demoblaze homepage")
    public void userIsOnDemoblazeHomepage() {
        loginPage = new LoginPage(driver);
        loginPage.goToHomepage();
    }

    @When("user clicks on Log in menu")
    public void userClicksOnLogInMenu() {
        loginPage.clickLoginMenu();
    }

    @And("user enters username {string} in login form")
    public void userEntersUsernameInLoginForm(String username) {
        loginPage.enterUsername(username);
    }

    @And("user enters password {string} in login form")
    public void userEntersPasswordInLoginForm(String password) {
        loginPage.enterPassword(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Given("user is logged in to Demoblaze")
    public void userIsLoggedInToDemoblaze() {
        loginPage = new LoginPage(driver);
        loginPage.goToHomepage();
        loginPage.loginWithCredentials("suleprikitiw", "password123");
    }

    @Then("user should be logged out successfully")
    public void userShouldBeLoggedOutSuccessfully() {
        loginPage.verifyLogoutSuccess();
    }

    @When("user clicks on Log out menu")
    public void userClicksOnLogOutMenu() {
        loginPage.clickLogout();
    }

    @Then("user should see invalid error message {string}")
    public void userShouldSeeInvalidErrorMessage(String userErrorMessage) {
        loginPage.verifyInvalidErrorMessage(userErrorMessage);
    }
}
