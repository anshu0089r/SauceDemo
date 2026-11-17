
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class emptyusername_emptypassword {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
            "src/test/resources/locator.properties"
        );
        prop.load(fis);
        fis.close();
        
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // Keep username and password fields empty
        // Click login button
        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        // Capture error message
        String error = driver.findElement(By.xpath(prop.getProperty("error.xpath"))).getText();

        if (error.contains("Username is required")) {
            System.out.println("PASSED");
            System.out.println("Empty username and password validation works");

        } else {
            System.out.println("FAILED");
        }
    }
}
