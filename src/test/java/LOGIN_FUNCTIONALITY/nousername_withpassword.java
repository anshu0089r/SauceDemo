package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By; 
import org.openqa.selenium.chrome.ChromeDriver;

public class nousername_withpassword {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		
		ChromeDriver driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/"); 
	    
	    driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("secret_sauce"); 
	    driver.findElement(By.xpath(prop.getProperty("loginButton.xpath"))).click(); 
	    String error1 = driver.findElement(By.xpath(prop.getProperty("error.xpath"))).getText(); 
	    if (error1.equals("Epic sadface: Username is required")) 
	    { System.out.println("PASSED"); 
	    	} 
	    else 
	    { System.out.println("FAILED"); 
	    	}
	}
}
