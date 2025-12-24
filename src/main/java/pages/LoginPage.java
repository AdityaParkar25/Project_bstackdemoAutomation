package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By signIn = By.xpath("//*[@id=\"signin\"]");
	private By usernameSelect = By.id("username");
	private By passwordSelect = By.id("password");
	private By loginButton = By.id("login-btn");
	private By errorMsg = By.className("api-error");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignIn() {
		
		driver.findElement(signIn).click();
	}
	
	public void selectUsername(String username) {

		driver.findElement(usernameSelect).click();
		driver.findElement(By.xpath("//div[text()='" + username + "']")).click();
		
	}
	

	public void selectPassword(String password) {

		driver.findElement(passwordSelect).click();
		driver.findElement(By.xpath("//div[text()='" + password + "']")).click();
	}
	
	public void clickLoginButton() {
		
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}

}
