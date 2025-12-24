package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

	
	@Test
	public void TC_004_addSingleItem() {
		
		CartPage cart = new CartPage(driver);
		ProductPage product = new ProductPage(driver);
		product.addFirstProduct();  // adding one item to cart
		cart.openCart();
		takeScreenShot("TC_004_AddSingleItem");
		
		Assert.assertEquals(cart.getCartCountBadge(), "1", "Single item was not added to the cart");
	}

	@Test
	public void TC_005_addMultipleItem() {
		
		CartPage cart = new CartPage(driver);
		ProductPage product = new ProductPage(driver);
		product.addFirstProduct();  // adding 1st item
		product.addFirstProduct();  // adding 2nd item
		product.addFirstProduct();  // adding 3rd item
		String count = cart.getCartCountBadge();
		takeScreenShot("TC_005_AddMultipleItem");
		
		Assert.assertEquals(count, "3", "Cart count does not match expected value");
	}

	@Test
	public void TC_006_removeItem() {
		
		CartPage cart = new CartPage(driver);
		ProductPage product = new ProductPage(driver);
		product.addFirstProduct();  // adding one item to cart
		cart.openCart();
		cart.removeItemFromCart();  // removing the item from cart
		takeScreenShot("TC_006_RemoveItem");
		
		Assert.assertEquals(cart.getCartCountBadge(), "0", "Item not removed from the cart");
	}

}
