
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class passwordPlaceholderTest {

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

        // Locate password field
        WebElement password = driver.findElement(By.xpath(prop.getProperty("password.xpath")));

        // Get placeholder text
        String actualPlaceholder =
            password.getAttribute("placeholder");

        String expectedPlaceholder = "Password";

        // Verify placeholder
        if (expectedPlaceholder.equals(actualPlaceholder)) {

            System.out.println("PASSED");
            System.out.println("Password placeholder is correct");
            System.out.println("Actual Placeholder: " + actualPlaceholder);

        } else {
            System.out.println("FAILED");
            System.out.println("Actual Placeholder: " + actualPlaceholder);
        }

    }
}

