package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alphabetinput_to_username {

	public static void main(String[] args) {
		
		        ChromeDriver driver = new ChromeDriver();
		        driver.get("https://www.saucedemo.com/");

		        WebElement username = driver.findElement(By.id("user-name"));
		        username.sendKeys("abcXYZ");

		        if (username.getAttribute("value").equals("abcXYZ")) {
		            System.out.println("PASSED: Alphabet keys work");
		        } else {
		            System.out.println("FAILED: Alphabet keys do not work");
		        }

	}

}
