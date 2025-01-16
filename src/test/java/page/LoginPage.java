package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginMenuLink = By.id("login2");
    By usernameInput = By.id("loginusername");
    By passwordInput = By.id("loginpassword");
    By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    By logoutLink = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void goToHomepage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickLoginMenu() {
        driver.findElement(loginMenuLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLogout() {
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyLogoutSuccess() {
        try {
            Thread.sleep(1000);
            assertTrue(driver.findElement(loginMenuLink).isDisplayed(),
                    "Login menu should be visible after logout");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginWithCredentials(String username, String password) {
        clickLoginMenu();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyInvalidErrorMessage(String errorMessage) {
        try {
            Thread.sleep(1000);
            String actualError = driver.switchTo().alert().getText();
            assertEquals(errorMessage, actualError);
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}