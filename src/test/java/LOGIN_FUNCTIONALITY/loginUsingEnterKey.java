
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginUsingEnterKey {

    public static void main(String[] args) throws Exception {


        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/locator.properties");
        prop.load(fis);
        fis.close();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // Enter valid username
        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("standard_user");

        // Enter valid password
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce");

        // Press Enter instead of clicking Login
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys(Keys.ENTER);

        // Verify successful login
        String title = driver.findElement(By.xpath(prop.getProperty("product_title.xpath"))).getText();

        if (title.equals("Products")) {
            System.out.println("PASSED! Login successful using Enter key");
        } else {

            System.out.println("FAILED");
        }

    }
}
