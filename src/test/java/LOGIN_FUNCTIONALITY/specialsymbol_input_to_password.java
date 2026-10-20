package LOGIN_FUNCTIONALITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class specialsymbol_input_to_password {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
	            "src/test/resources/locator.properties"
	        );
		prop.load(file);
		file.close();
		
		EdgeDriver driver = new EdgeDriver(); 
		driver.get("https://www.saucedemo.com/"); 
		
        driver.findElement(By.xpath(prop.getProperty("password.xpath"))).sendKeys("`~!?|@#$%^&*()_+/-"); 
        String password = driver.findElement(By.xpath(prop.getProperty("password.xpath"))).getAttribute("value"); 
        if (password.equals("`~!?|@#$%^&*()_+/-")) 
        { System.out.println("TEST CASE PASS"); } 
        else 
        { System.out.println("TEST CASE FAIL"); }
	}

}
