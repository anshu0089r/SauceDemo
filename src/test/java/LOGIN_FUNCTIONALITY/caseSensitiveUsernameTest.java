
package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class caseSensitiveUsernameTest {

    public static void main(String[] args) throws IOException {

    	Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Enter uppercase username
        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("STANDARD_USER");

        // Enter valid password
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce");

        // Click login button
        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        // Verify error message
        List<WebElement> error = driver.findElements(
            By.xpath(prop.getProperty("error.xpath")));

        if (!error.isEmpty() && error.get(0).isDisplayed() && error.get(0).getText()
        		.contains("Username and password do not match")) 
        {
            System.out.println("TC_21: PASS");
            System.out.println("Username is case-sensitive.");

        } else {

            System.out.println("TC_21: FAIL");
            System.out.println("Unexpected login result.");
        }
    }
}
