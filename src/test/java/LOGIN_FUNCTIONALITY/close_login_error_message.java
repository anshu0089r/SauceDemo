package LOGIN_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class close_login_error_message {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement loginButton =
                driver.findElement(By.id("login-button"));

        loginButton.click();

        WebElement errorMessage =
                driver.findElement(By.cssSelector("[data-test='error']"));

        if (errorMessage.isDisplayed()) {

            WebElement closeButton =
                    driver.findElement(By.className("error-button"));

            closeButton.click();

            if (!errorMessage.isDisplayed()) {
                System.out.println("PASS: Login error message closed successfully");
            } else {
                System.out.println("FAIL: Login error message is still displayed");
            }

        } else {
            System.out.println("FAIL: Login error message was not displayed");
        }

        driver.quit();
    }
}