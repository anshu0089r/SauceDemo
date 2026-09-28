package CART_FUNCTIONALITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart_product_details_test {
	
	 public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://www.saucedemo.com/");

	        driver.findElement(By.xpath("//input[@placeholder='Username']"))
	              .sendKeys("standard_user");

	        driver.findElement(By.xpath("//input[@placeholder='Password']"))
	              .sendKeys("secret_sauce");

	        driver.findElement(By.xpath("//input[@type='submit']"))
	              .click();

	        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"))
	              .click();

	        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"))
	              .click();

	        String productName = driver.findElement(
	                By.xpath("//div[@class='inventory_item_name']"))
	                .getText();

	        String productPrice = driver.findElement(
	                By.xpath("//div[@class='inventory_item_price']"))
	                .getText();

	        if (productName.equals("Sauce Labs Backpack") && productPrice.equals("$29.99")) {
	            System.out.println("TC_CART_004 : PASS");
	            System.out.println("Product details are correct");
	        } else {
	            System.out.println("TC_CART_004 : FAIL");
	            System.out.println("Product Name: " + productName);
	            System.out.println("Product Price: " + productPrice);
	        }

	        driver.quit();
	    }

}
