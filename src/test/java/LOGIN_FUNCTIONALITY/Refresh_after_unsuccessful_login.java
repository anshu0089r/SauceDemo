package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Refresh_after_unsuccessful_login {

    public static void main(String[] args) throws Exception {

        // Load properties file
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
            "src/test/resources/locator.properties"
        );

        prop.load(fis);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Enter invalid username
        driver.findElement(By.xpath(
            prop.getProperty("username.xpath")
        )).sendKeys("wrong_user");

        // Enter invalid password
        driver.findElement(By.xpath(
            prop.getProperty("password.xpath")
        )).sendKeys("wrong_password");

        // Click login button
        driver.findElement(By.xpath(
            prop.getProperty("loginButton.xpath")
        )).click();

        // Get error message
        String error = driver.findElement(By.xpath(
            prop.getProperty("error.xpath")
        )).getText();

        System.out.println("Error Message: " + error);

        // Refresh browser
        driver.navigate().refresh();

        // Verify login page
        if (driver.findElement(By.xpath(
            prop.getProperty("loginButton.xpath")
        )).isDisplayed()) {

            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        fis.close();

    }
}