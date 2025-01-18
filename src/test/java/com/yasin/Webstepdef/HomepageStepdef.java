package com.yasin.Webstepdef;

import com.yasin.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.CartPage;
import page.HomePage;

public class HomepageStepdef extends BaseTest {
    HomePage homePage;
    CartPage cartPage;

    @Then("user is on homepage should see Welcome in the navigation bar")
    public void userIsOnHomepageShouldSeeWelcomeInTheNavigationBar() {
        homePage = new HomePage(driver);
        homePage.validateNavBar();
    }

    @And("user clicks on Cart menu")
    public void userClicksOnCartMenu() {
        cartPage = new CartPage(driver);
        cartPage.clickCartMenu();
    }
}
