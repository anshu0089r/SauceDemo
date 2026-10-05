package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class problem_user_test {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains("inventory.html")) {
            System.out.println("PASS - Problem User Login Successful");
        } else {
            System.out.println("FAIL - Problem User Login Failed");
        }

	}

}
