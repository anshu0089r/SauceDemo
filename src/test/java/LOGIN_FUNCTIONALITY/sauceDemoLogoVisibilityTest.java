
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceDemoLogoVisibilityTest {

    public static void main(String[] args) throws Exception {

        ChromeDriver driver = new ChromeDriver();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/locator.properties");
        prop.load(fis);
        fis.close();

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");

        // Locate SauceDemo logo
        WebElement logo = driver.findElement(By.xpath(prop.getProperty("logo.xpath")));

        // Check logo visibility
        boolean isVisible = logo.isDisplayed();

        if (isVisible) {
            System.out.println("PASSED");
            System.out.println("SauceDemo logo is visible");

        } else {

            System.out.println("FAILED");
            System.out.println("SauceDemo logo is not visible");
        }

    }
}
