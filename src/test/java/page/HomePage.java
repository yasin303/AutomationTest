package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    By welcomeNav = By.cssSelector("#nameofuser");
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateNavBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeNav));
        assertTrue(productElement.isDisplayed());
        assertEquals("Welcome suleprikitiw", productElement.getText());
    }
}