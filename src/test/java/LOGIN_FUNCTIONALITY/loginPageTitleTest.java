package LOGIN_FUNCTIONALITY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageTitleTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";

        // Verify page title
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("PASSED");
            System.out.println("Login page title is correct");
            System.out.println("Actual Title: " + actualTitle);

        } else {

            System.out.println("FAILED");
            System.out.println("Actual Title: " + actualTitle);
        }

        driver.quit();
    }
}
