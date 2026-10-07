package CART_FUNCTIONALITY;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveProductFromCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        
        driver.findElement(By.className("shopping_cart_link")).click();
        
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        
        
        if (driver.findElements(By.id("item-4-title-link")).isEmpty()) {
        	System.out.println("Test Passed: Product is removed from the cart.");
        } else {
            System.out.println("Test Failed: Product is still in the cart.");
        
        }
        
        driver.quit();
;	}

}
