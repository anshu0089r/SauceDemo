
package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCartAfterNavigation {
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

        driver.findElement(By.xpath("//button[@id='continue-shopping']"))
              .click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"))
              .click();

        boolean isProductPresent = driver.findElement(
            By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
        ).isDisplayed();

        System.out.println("Product remains in cart: " + isProductPresent);

        driver.quit();
    }
}
