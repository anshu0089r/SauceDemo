package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginpageloadtest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
        if (actualTitle.contains("Swag Labs")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
		}

	}

}
