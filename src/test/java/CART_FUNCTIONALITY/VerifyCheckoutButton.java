
package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCheckoutButton {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']"))
              .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']"))
              .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']"))
              .click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"))
              .click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"))
              .click();

        driver.findElement(By.xpath("//button[@id='checkout']"))
              .click();

        boolean checkoutPageDisplayed = driver.findElement(
            By.xpath("//span[text()='Checkout: Your Information']")
        ).isDisplayed();

        if (checkoutPageDisplayed) {
            System.out.println("Test Passed: Checkout page displayed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
