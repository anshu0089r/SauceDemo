package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class numericinput_to_username {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.saucedemo.com/"); 
		WebElement username = driver.findElement(By.id("user-name")); 
		username.sendKeys("0123456789"); 
		if (username.getAttribute("value").equals("0123456789")) 
		{ System.out.println("PASSED: Number keys work"); } 
		else 
		{ System.out.println("FAILED: Number keys do not work"); }
		
	}

}
