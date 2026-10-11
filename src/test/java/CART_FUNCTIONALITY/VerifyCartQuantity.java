
package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCartQuantity {
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

        String quantity = driver.findElement(
            By.xpath("//div[@class='cart_quantity']")
        ).getText();

        if (quantity.equals("1")) {
            System.out.println("Test Passed: Cart quantity is 1");
        } else {
            System.out.println("Test Failed: Incorrect cart quantity");
        }

        driver.quit();
    }
}
