package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By; 
import org.openqa.selenium.chrome.ChromeDriver;

public class username_with_nopassword {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/"); 
	    driver.findElement(By.id("password")).sendKeys("secret_sauce"); 
	    driver.findElement(By.id("login-button")).click(); 
	    String error1 = driver.findElement(By.xpath("//*[@data-test='error']")).getText(); 
	    if (error1.equals("Epic sadface: Username is required")) 
	    { System.out.println("PASSED"); 
	    	} 
	    else 
	    { System.out.println("FAILED"); 
	    	}
	}
}
