package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;

public class lockedout_user_login_test {

	public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();
		        driver.get("https://www.saucedemo.com/");
		        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        driver.findElement(By.id("login-button")).click();
		        
		        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		        if (errorMessage.contains("locked out")) {
		            System.out.println("PASS: Locked-out user cannot login");
		        } else {
		            System.out.println("FAIL: Locked-out user login test failed");
		        }
	}

}
