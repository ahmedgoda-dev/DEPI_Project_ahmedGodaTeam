package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestCase23 extends BaseTest {

    @Test
    public void verifyAddressDetails() {

        HomePage home = new HomePage(driver);
        SignupLoginPage loginPage = new SignupLoginPage(driver);
        CartPage cart = new CartPage(driver);

        home.clickSignupLogin();
        loginPage.signup("Ahmed", "ahmed" + System.currentTimeMillis() + "@test.com");

        // Continue account creation manually if needed…

        home.clickProducts();
        ProductsPage products = new ProductsPage(driver);
        products.addFirstProductToCart();
        products.goToCart();

        cart.clickCheckout();

        Assert.assertTrue(driver.getPageSource().contains("Address Details"));
    }
}
