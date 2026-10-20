package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class passwordFieldMasking {

    public static void main(String[] args) throws IOException{

    	Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
    	
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement password = driver.findElement(By.xpath(prop.getProperty("password.xpath")));

        password.sendKeys("Test@123");

        String fieldType = password.getAttribute("type");

        if (fieldType.equals("password")) {
            System.out.println("PASS: Password field masks the entered text");
        } else {
            System.out.println("FAIL: Password field is not masked");
        }
    }
}