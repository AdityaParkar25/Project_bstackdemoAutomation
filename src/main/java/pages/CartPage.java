package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	private WebDriver driver;
	
	private By cart_Icon = By.className("bag");
	private By cart_Items = By.className("shelf-item");
	private By remove_Items = By.className("shelf-item__del");
	private By cart_Count = By.className("bag__quantity");
	private By checkoutButton = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]");
	private By emptyCartMsg = By.className("shelf-empty");
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void openCart() {
		
		driver.findElement(cart_Icon).click();
	}
	
	public int getCartItemsCount() {
		
		return driver.findElements(cart_Items).size();
	}
	
	public String getCartCountBadge() {
		
		return driver.findElement(cart_Count).getText();
	}
	
	public void removeItemFromCart() {
		
		driver.findElement(remove_Items).click();
	}
	
	public void clickCheckoutBtn() {
		
		driver.findElement(checkoutButton).click();
	}
	
	public String getEmptyCartMsg() {
		
		return driver.findElement(emptyCartMsg).getText();
	}

}
