package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class error_user_login_test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("error_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
	}

}
