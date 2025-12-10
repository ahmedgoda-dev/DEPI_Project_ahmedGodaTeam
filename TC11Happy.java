package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.CartPage;

public class TC11Happy extends BaseTest {

    @Test
    public void verifySubscriptionPositive() throws InterruptedException {

        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(home.isHomePageVisible(), "Home page is NOT visible!");

        home.clickCartButton();
        Thread.sleep(1000);

        Assert.assertTrue(cart.isSubscriptionHeaderVisible(), "'SUBSCRIPTION' header is NOT visible!");

        cart.enterSubscriptionEmail("testuser@gmail.com");
        cart.clickSubscriptionArrowButton();

        Assert.assertTrue(
            cart.isSubscriptionSuccessMessageVisible(),
            "Subscription success message is NOT visible!"
        );
    }
}
