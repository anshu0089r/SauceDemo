package ABOUT_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AboutTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com/");

            // 1. Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // 2. Open Sidebar Menu
            wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();

            // 3. Wait for the "About" link to be visibly rendered
            WebElement aboutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link"))
            );

            // 4. Verify Visibility
            if (aboutLink.isDisplayed()) {
                System.out.println("TEST CASE PASSED");
            } else {
                System.out.println("TEST CASE FAILED");
            }

        } catch (Exception e) {
            System.out.println("TEST CASE FAILED: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}