package LOGIN_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class numericinput_to_password {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("0123456789");
        if (password.getAttribute("value").equals("0123456789")) {
            System.out.println("PASSED: Number keys work");
        } else {
            System.out.println("FAILED: Number keys do not work");
        }
    }
}
