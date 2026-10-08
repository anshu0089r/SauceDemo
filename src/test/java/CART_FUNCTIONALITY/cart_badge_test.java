package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart_badge_test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[contains(@id,'user-name')]"))
              .sendKeys("standard_user");

        driver.findElement(By.xpath("//input[contains(@id,'password')]"))
              .sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type='submit']"))
              .click();

        driver.findElement(By.xpath("//button[starts-with(@id,'add-to-cart')]"))
              .click();

        driver.findElement(By.xpath("//button[contains(@name,'bike-light')]"))
              .click();

        String cartCount = driver.findElement(
                By.xpath("//span[@class='shopping_cart_badge']"))
                .getText();

        if (cartCount.equals("2")) {
            System.out.println("TC_CART_002 : PASS");
        } else {
            System.out.println("TC_CART_002 : FAIL");
        }

        driver.quit();
    }
}