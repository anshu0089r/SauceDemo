
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserBackAfterLoginTest {

    public static void main(String[] args) throws Exception {


        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
        		"src/test/resources/locator.properties"
        );
        prop.load(fis);
        fis.close();
        
        ChromeDriver driver = new ChromeDriver();
        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");

        // Enter valid username
        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("standard_user");

        // Enter valid password
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce");

        // Click login
        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        // Verify Products page
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText();

        if (title.equals("Products")) {
            // Navigate backward
            driver.navigate().back();

            // Verify navigation
            String currentURL = driver.getCurrentUrl();
            if (currentURL.equals("https://www.saucedemo.com/")) {
                System.out.println("PASSED");
                System.out.println("Browser back navigated to login page");

            } else {
                System.out.println("FAILED");
                System.out.println("Current URL: " + currentURL);
            }

        } else {
            System.out.println("FAILED");
            System.out.println("Login was unsuccessful");
        }

    }
}
