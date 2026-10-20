package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alphabetinput_to_username {

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
		        username.sendKeys("abcXYZ");

		        if (username.getAttribute("value").equals("abcXYZ")) {
		            System.out.println("PASSED: Alphabet keys work");
		        } else {
		            System.out.println("FAILED: Alphabet keys do not work");
		        }

	}

}
