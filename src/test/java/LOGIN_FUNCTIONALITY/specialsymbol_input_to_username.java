package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class specialsymbol_input_to_username {
	    public static void main(String[] args) {
	        ChromeDriver driver = new ChromeDriver();

	        driver.get("https://www.saucedemo.com/"); 
	        driver.findElement(By.id("user-name")).sendKeys("`~!?|@#$%^&*()_+/-"); 
	        String username = driver.findElement(By.id("user-name")).getAttribute("value"); 
	        if (username.equals("`~!?|@#$%^&*()_+/-")) 
	        { System.out.println("TEST CASE PASS"); } 
	        else 
	        { System.out.println("TEST CASE FAIL"); }
	  }
}
