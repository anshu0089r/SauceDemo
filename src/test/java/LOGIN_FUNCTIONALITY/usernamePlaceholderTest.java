
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class usernamePlaceholderTest {

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
        // Locate username field
        WebElement username = driver.findElement(By.xpath(prop.getProperty("username.xpath")));

        // Get placeholder text
        String actualPlaceholder = username.getAttribute("placeholder");

        String expectedPlaceholder = "Username";

        // Verify placeholder text
        if (actualPlaceholder.equals(expectedPlaceholder)) {

            System.out.println("PASSED");
            System.out.println("Username placeholder is correct");
            System.out.println("Actual Placeholder: " + actualPlaceholder);

        } else {

            System.out.println("FAILED");
            System.out.println("Actual Placeholder: " + actualPlaceholder);
        }

    }
}
