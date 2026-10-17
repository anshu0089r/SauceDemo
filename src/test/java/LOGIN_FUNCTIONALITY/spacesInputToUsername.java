package LOGIN_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class spacesInputToUsername {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));

        username.sendKeys("  standard_user  ");

        String enteredUsername = username.getAttribute("value");

        if (enteredUsername.equals("  standard_user  ")) {
            System.out.println("PASS: Username field accepts leading and trailing spaces");
        } else {
            System.out.println("FAIL: Username field does not preserve the entered spaces");
        }
    }
}
