package page.Web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage {
    WebDriver driver;

    By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickProduct(String productName){
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
//            System.out.println("success " + productName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("product not found" + e);
        }
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
