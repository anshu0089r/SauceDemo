package LOGIN_FUNCTIONALITY;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class invalid_username_valid_password {

    public static void main(String[] args) throws IOException{

    	Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
    	
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("invalid_user");
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce");
        driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click();

        String error = driver.findElement(
            By.xpath(prop.getProperty("error.xpath"))
        ).getText();

        String expectedError =
            "Epic sadface: Username and password do not match any user in this service";

        if (error.equals(expectedError)) {
            System.out.println("TEST CASE PASSED");
        } else {
            System.out.println("TEST CASE FAILED");
            System.out.println("Actual Error: " + error);
        }
    }
}