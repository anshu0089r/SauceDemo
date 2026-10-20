package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class close_login_error_message {

    public static void main(String[] args) throws IOException{
    	
    	Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement loginButton =
                driver.findElement(By.xpath(prop.getProperty("loginButton.xpath")));

        loginButton.click();

        WebElement errorMessage =
                driver.findElement(By.xpath(prop.getProperty("error.xpath")));

        if (errorMessage.isDisplayed()) {

            WebElement closeButton =
                    driver.findElement(By.xpath(prop.getProperty("closeerror.xpath")));

            closeButton.click();

            if (driver.findElements(
                    By.xpath(prop.getProperty("error.xpath"))
                ).isEmpty()) {

                System.out.println("PASS: Login error message closed successfully");

            } else {
                System.out.println("FAIL: Login error message is still displayed");
            }

        } else {
            System.out.println("FAIL: Login error message was not displayed");
        }

        driver.quit();
    }
}