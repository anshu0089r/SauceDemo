package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By; 
import org.openqa.selenium.chrome.ChromeDriver;

public class username_with_nopassword {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		
		ChromeDriver driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/"); 
	    driver.findElement(By.xpath(prop.getProperty("username.xpath"))).sendKeys("standard_user");
	    driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click(); 
	    String error1 = driver.findElement(By.xpath(prop.getProperty("error.xpath"))).getText(); 
	    if (error1.equals("Epic sadface: Password is required")) 
	    { System.out.println("PASSED"); 
	    	} 
	    else 
	    { System.out.println("FAILED"); 
	    	}
	}
}
