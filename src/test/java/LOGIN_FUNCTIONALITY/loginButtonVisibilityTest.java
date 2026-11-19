
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginButtonVisibilityTest {

    public static void main(String[] args) throws Exception {

    	Properties prop = new Properties();
    	FileInputStream fis = new FileInputStream("src/test/resources/locator.properties");
    	prop.load(fis);
    	fis.close();


        // Open SauceDemo
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Locate login button
        WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("loginButton.xpath")));

        // Verify visibility
        boolean isVisible = loginButton.isDisplayed();

        // Verify enabled status
        boolean isEnabled = loginButton.isEnabled();

        if (isVisible && isEnabled) {
            System.out.println("PASSED");
            System.out.println("Login button is visible");
            System.out.println("Login button is enabled");
        } 
        else {
            System.out.println("FAILED");
        }
    }
}
