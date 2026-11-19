
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class usernameFieldVisibilityTest {

    public static void main(String[] args) throws Exception {


        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
            "src/test/resources/locator.properties"
        );
        prop.load(fis);
        fis.close();    


        // Open SauceDemo
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Locate username field
        WebElement username = driver.findElement(By.xpath(prop.getProperty("username.xpath")));

        // Check username field visibility
        boolean isVisible = username.isDisplayed();

        if (isVisible) {
            System.out.println("PASSED");
            System.out.println("Username field is visible");
        } 
        else {
            System.out.println("FAILED");
            System.out.println("Username field is not visible");
        }

    }
}
