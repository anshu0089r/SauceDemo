package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class error_user_login_test {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		
		ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("error_user");
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce");

        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
	}

}
