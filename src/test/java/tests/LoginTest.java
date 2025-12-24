package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

	@Test
	public void TC_001_testValidLogin() {

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickSignIn();
		loginPage.selectUsername("demouser");
		loginPage.selectPassword("testingisfun99");
		loginPage.clickLoginButton();
		WaitUtils.sleep();
		takeScreenShot("TC_001_TestValidLogin");
	}

	@Test
	public void TC_002_testInvalidLogin() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickSignIn();
		loginPage.selectUsername("locked_user");
		loginPage.selectPassword("testingisfun99");
		loginPage.clickLoginButton();
		WaitUtils.sleep();
		takeScreenShot("TC_002_TestInvalidLogin");
		
		Assert.assertTrue(loginPage.getErrorMessage().contains("locked"),
				"Invalid username error expected");
	}

	@Test
	public void TC_003_emptyCredentials() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickSignIn();
		loginPage.clickLoginButton();
		WaitUtils.sleep();
		takeScreenShot("TC_003_EmptyCredentials");
		
		Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"),
				"Validation error expected");
	}

}
