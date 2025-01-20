package com.yasin.Webstepdef;

import com.yasin.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page.Web.ProductPage;

public class ProductStepdef extends BaseTest {
    ProductPage productPage;

    @When("user clicks on {string} product")
    public void userClicksOnProduct(String productName) {
        productPage = new ProductPage(driver);
        productPage.clickProduct(productName);
    }

    @And("user clicks Add to Cart button")
    public void userClicksAddToCartButton() {
        productPage.clickAddToCart();
    }

    @And("user accepts product added popup")
    public void userAcceptsProductAddedPopup() {
        productPage.acceptAlert();
    }
}
