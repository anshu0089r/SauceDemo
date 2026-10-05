package CART_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class bagpack_test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		driver.findElement(By.className("shopping_cart_link")).click();

		String product = driver.findElement(By.className("inventory_item_name")).getText();

		if (product.equals("Sauce Labs Backpack")) {
			System.out.println("TC_CART_001 : PASS");
		} else {
			System.out.println("TC_CART_001 : FAIL");
		}

	}

	

}
