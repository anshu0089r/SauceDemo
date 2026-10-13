
package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class VerifyCartBadgeAfterRemovingAllProducts {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        boolean badgeAbsent = driver.findElements(
            By.className("shopping_cart_badge")
        ).isEmpty();

        if (badgeAbsent) {
            System.out.println("PASS: Cart badge is not displayed.");
        } else {
            System.out.println("FAIL: Cart badge is still displayed.");
        }

        driver.quit();
    }
}
