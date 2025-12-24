package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;
	
	private By firstName = By.id("firstNameInput");
	private By lastName = By.id("lastNameInput");
	private By address = By.id("addressLine1Input");
	private By stateProvince = By.id("provinceInput");
	private By postalCode = By.id("postCodeInput");
	private By submitButton = By.id("checkout-shipping-continue");
	private By orderConfirmMsg = By.id("confirmation-message");
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void enterShippingDetails(String fname, String lname,
									String addr, String prov, String pcode) {
		
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(address).sendKeys(addr);
		driver.findElement(stateProvince).sendKeys(prov);
		driver.findElement(postalCode).sendKeys(pcode);
		driver.findElement(submitButton).click();
	}
	
	public String getConfirmationMsg() {
		
		return driver.findElement(orderConfirmMsg).getText();
	}
	
}
