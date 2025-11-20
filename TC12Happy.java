package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;
import pages.CartPage;

public class TC12Happy extends BaseTest {

	@Test
	public void verifyProductsAddedToCart() {

	    HomePage home = new HomePage(driver);
	    ProductsPage products = new ProductsPage(driver);
	    CartPage cart = new CartPage(driver);
	   
	    Assert.assertTrue(home.isHomePageVisible());

	    home.clickProducts();
	    products.addToCart(1);
	    products.clickContinueShopping();
	    products.addToCart(2);
	    products.clickViewCart();

	    Assert.assertEquals(cart.getProductName(1), "Blue Top");
	    Assert.assertEquals(cart.getProductPrice(1), "Rs. 500");
	    Assert.assertEquals(cart.getProductQuantity(1), "1");
	    Assert.assertEquals(cart.getProductTotal(1), "Rs. 500");

	    Assert.assertEquals(cart.getProductName(2), "Men Tshirt");
	    Assert.assertEquals(cart.getProductPrice(2), "Rs. 400");
	    Assert.assertEquals(cart.getProductQuantity(2), "1");
	    Assert.assertEquals(cart.getProductTotal(2), "Rs. 400");
	}
}
