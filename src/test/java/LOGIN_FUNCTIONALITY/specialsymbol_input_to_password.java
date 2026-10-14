package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class specialsymbol_input_to_password {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver(); 
		driver.get("https://www.saucedemo.com/"); 
        driver.findElement(By.id("user-name")).sendKeys("`~!?|@#$%^&*()_+/-"); 
        String password = driver.findElement(By.id("password")).getAttribute("value"); 
        if (password.equals("`~!?|@#$%^&*()_+/-")) 
        { System.out.println("TEST CASE PASS"); } 
        else 
        { System.out.println("TEST CASE FAIL"); }
	}

}
