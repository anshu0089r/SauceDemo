package ABOUT_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verify_click{
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        if(driver.findElement(By.id("about_sidebar_link")).isEnabled())
            System.out.println("TEST CASE 2 PASSED");
        else
            System.out.println("TEST CASE 2 FAILED");

        driver.quit();
    }
}
