package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class numericinput_to_username {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.saucedemo.com/"); 
		WebElement username = driver.findElement(By.xpath(prop.getProperty("username.xpath"))); 
		username.sendKeys("0123456789"); 
		if (username.getAttribute("value").equals("0123456789")) 
		{ System.out.println("PASSED: Number keys work"); } 
		else 
		{ System.out.println("FAILED: Number keys do not work"); }
		
	}

}
