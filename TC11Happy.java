package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.CartPage;

public class TC11Happy extends BaseTest {

@Test
	  public void verifySubscriptionHappyScenario() throws InterruptedException {

	   HomePage home = new HomePage(driver);
	   CartPage cart = new CartPage(driver);

	   home.clickCart();
	   Thread.sleep(3000);

	   Assert.assertTrue(cart.isSubscriptionTitleVisible(), "Subscription title is NOT visible!");

	   cart.enterEmail("testuser@gmail.com");
	   cart.clickSubscribe();

	   Thread.sleep(3000);

	   Assert.assertTrue(cart.isSuccessMessageVisible(), "Success message is NOT visible!");
	    }
}