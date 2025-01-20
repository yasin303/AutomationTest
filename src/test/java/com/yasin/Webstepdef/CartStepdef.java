package com.yasin.Webstepdef;

import com.yasin.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import page.Web.CartPage;

import java.util.Map;

public class CartStepdef extends BaseTest {
    CartPage cartPage;

    @And("user clicks Place Order button")
    public void userClicksPlaceOrderButton() {
        cartPage = new CartPage(driver);
        cartPage.clickPlaceOrder();
    }

    @And("user fills order form with following details")
    public void userFillsOrderFormWithFollowingDetails(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        cartPage.fillOrderForm(
                formData.get("Name"),
                formData.get("Country"),
                formData.get("City"),
                formData.get("Card"),
                formData.get("Month"),
                formData.get("Year")
        );
    }

    @And("user clicks Purchase button")
    public void userClicksPurchaseButton() {
        cartPage.clickPurchase();
    }

    @Then("user should see success message {string}")
    public void userShouldSeeSuccessMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, cartPage.getSuccessMessage());
    }
}
