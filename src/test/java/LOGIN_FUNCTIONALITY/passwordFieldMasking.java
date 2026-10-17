package LOGIN_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class passwordFieldMasking {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("Test@123");

        String fieldType = password.getAttribute("type");

        if (fieldType.equals("password")) {
            System.out.println("PASS: Password field masks the entered text");
        } else {
            System.out.println("FAIL: Password field is not masked");
        }
    }
}