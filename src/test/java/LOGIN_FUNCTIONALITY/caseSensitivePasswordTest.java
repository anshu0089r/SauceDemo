
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class caseSensitivePasswordTest {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
            "src/test/resources/locator.properties"
        );
        prop.load(fis);
        fis.close();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("standard_user");

        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("SECRET_SAUCE");

        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        String error = driver.findElement(By.xpath(prop.getProperty("error.xpath"))).getText();

        if (error.contains("Username and password do not match")) {

            System.out.println("PASSED");
            System.out.println("Password is case-sensitive");

        } else {

            System.out.println("FAILED");
        }

     }
}
