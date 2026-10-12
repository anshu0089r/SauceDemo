
package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class VerifyCartAfterRefresh {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.navigate().refresh();

        boolean backpack = driver.findElements(
            By.xpath("//div[@class='inventory_item_name' and normalize-space()='Sauce Labs Backpack']")
        ).size() > 0;

        boolean bikeLight = driver.findElements(
            By.xpath("//div[@class='inventory_item_name' and normalize-space()='Sauce Labs Bike Light']")
        ).size() > 0;

        if (backpack && bikeLight) {
            System.out.println("PASS: Both products remain in the cart after refresh.");
        } else {
            System.out.println("FAIL: One or both products are missing from the cart.");
        }

        driver.quit();
    }
}
