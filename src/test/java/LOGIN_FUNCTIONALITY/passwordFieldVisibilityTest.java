
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class passwordFieldVisibilityTest {

    public static void main(String[] args) throws Exception {

        ChromeDriver driver = new ChromeDriver();
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/locator.properties");
        prop.load(fis);
        fis.close();

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");
        // Locate password field
        WebElement password = driver.findElement(By.xpath(prop.getProperty("password.xpath")));
        // Check password field visibility
        boolean isVisible = password.isDisplayed();
        if (isVisible) {
            System.out.println("PASSED");
            System.out.println("Password field is visible");
        } else {

            System.out.println("FAILED");
            System.out.println("Password field is not visible");
        }
    }
}
