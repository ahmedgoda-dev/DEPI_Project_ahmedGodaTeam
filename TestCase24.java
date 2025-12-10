package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

public class TestCase24 extends BaseTest {

    @Test
    public void downloadInvoice() {

        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        home.clickProducts();
        products.addFirstProductToCart();
        products.goToCart();

        cart.clickCheckout();

        // After payment page → Download Invoice
        driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).click();

        driver.findElement(By.id("submit")).click();  // Pay

        driver.findElement(By.cssSelector("a.btn.btn-default")).click(); // Download Invoice
    }
}
