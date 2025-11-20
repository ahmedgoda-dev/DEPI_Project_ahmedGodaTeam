package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.CartPage;

public class TC13Happy extends BaseTest {

    @Test
    public void verifyProductQuantityInCart() {

        HomePage home = new HomePage(driver);
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        CartPage cart = new CartPage(driver);

        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickViewProduct(1);

        String productName = productDetail.getProductName();

        productDetail.setQuantity(4);
        productDetail.clickAddToCart();
        productDetail.clickViewCart();

        Assert.assertEquals(cart.getProductName(1), productName, "Product name mismatch in cart");
        Assert.assertEquals(cart.getProductQuantity(1), "4", "Product quantity mismatch in cart");
    }
}