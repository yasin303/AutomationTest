package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By cartMenu = By.id("cartur");
    By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    By successMessage = By.xpath("//h2[contains(text(),'Thank you')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartMenu() {
        driver.findElement(cartMenu).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
