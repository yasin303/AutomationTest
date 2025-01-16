package com.yasin.stepdef;

import com.yasin.BaseTest;
import io.cucumber.java.en.Then;
import page.HomePage;

public class HomepageStepdef extends BaseTest {
    HomePage homePage;

    @Then("user is on homepage should see Welcome in the navigation bar")
    public void userIsOnHomepageShouldSeeWelcomeInTheNavigationBar() {
        homePage = new HomePage(driver);
        homePage.validateNavBar();
    }
}
