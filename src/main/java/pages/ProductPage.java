package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	private WebDriver driver;
	private By addProductButton = By.xpath("//*[@id=\"1\"]/div[4]");
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void addFirstProduct() {
		
		driver.findElement(addProductButton).click();
	}

}
