package LOGIN_FUNCTIONALITY;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class alphabetinput_to_password {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abcXYZ");
        if (password.getAttribute("value").equals("abcXYZ")) {
            System.out.println("PASSED: Alphabet keys work");
        } else {
            System.out.println("FAILED: Alphabet keys do not work");
        }
	}

}
