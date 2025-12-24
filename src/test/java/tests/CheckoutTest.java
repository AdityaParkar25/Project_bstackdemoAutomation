package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.WaitUtils;

public class CheckoutTest extends BaseTest{

	@Test
	public void TC_007_placeOrderwithValidDetails() {
		
		// Login with Valid Credentials
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.selectUsername("demouser");
		login.selectPassword("testingisfun99");
		login.clickLoginButton();
		
		// Add item to cart
		CartPage cart = new CartPage(driver);
		ProductPage product = new ProductPage(driver);
		product.addFirstProduct();  // adding one item to cart
		cart.clickCheckoutBtn();
		
		// Enter shipping details and place an order
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.enterShippingDetails("Tony", "Stark", "125 Stark Tower", "Chicago", "413000");
		WaitUtils.sleep();
		takeScreenShot("TC_007_PlaceOrder");
		
		// Confirm if Order is placed successfully
		Assert.assertTrue(checkout.getConfirmationMsg().contains("successfully placed"));
		
	}

	
	@Test
	public void TC_008_checkoutWithoutAddingItems() {
		
		CartPage cart = new CartPage(driver);
		cart.openCart();
		WaitUtils.sleep();
		takeScreenShot("TC_008_CheckoutWithoutAddingItems");
		
		Assert.assertTrue(cart.getEmptyCartMsg().contains("Add some products"));
	}

}
