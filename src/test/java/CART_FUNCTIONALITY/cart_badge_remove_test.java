package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart_badge_remove_test {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']"))
              .sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']"))
              .sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@name='login-button']"))
              .click();

        driver.findElement(By.xpath("//button[contains(@id,'backpack')]"))
              .click();

        driver.findElement(By.xpath("//button[contains(@id,'bike-light')]"))
              .click();

        driver.findElement(By.xpath("//button[normalize-space(.)='Remove' and contains(@id,'backpack')]"))
              .click();

        String cartCount = driver.findElement(
                By.xpath("//a[contains(@class,'shopping_cart_link')]/span"))
                .getText();

        if (cartCount.equals("1")) {
            System.out.println("TC_CART_006 : PASS");
        } else {
            System.out.println("TC_CART_006 : FAIL");
            System.out.println("Expected: 1");
            System.out.println("Actual: " + cartCount);
        }

        driver.quit();
    }
}