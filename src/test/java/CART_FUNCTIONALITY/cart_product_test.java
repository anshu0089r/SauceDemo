package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart_product_test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
              .click();

        driver.findElement(By.className("shopping_cart_link"))
              .click();

        String productName = driver.findElement(
                By.className("inventory_item_name"))
                .getText();

        if (productName.equals("Sauce Labs Backpack")) {
            System.out.println("TC_CART_003 : PASS");
            System.out.println("Correct product displayed in cart");
        } else {
            System.out.println("TC_CART_003 : FAIL");
            System.out.println("Expected: Sauce Labs Backpack");
            System.out.println("Actual: " + productName);
        }

        driver.quit();
    }
}