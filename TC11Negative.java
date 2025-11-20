package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.CartPage;

public class TC11Negative extends BaseTest {

	@DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][] {
            {"testuser.com"},      
            {""},                  
            {"test@.com"}     
        };
    }

    @Test(dataProvider = "invalidEmails")
    public void verifySubscriptionNegativeScenario(String invalidEmail) throws InterruptedException {

        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        home.clickCart();
        Thread.sleep(3000);

        // Enter invalid email
        cart.enterEmail(invalidEmail);
        cart.clickSubscribe();

        Thread.sleep(3000);

        
        boolean isSuccess = false;
        try {
            isSuccess = cart.isSuccessMessageVisible();
        } catch (Exception e) {
           
        }

        Assert.assertFalse(isSuccess, 
            "FAILED: Success message appeared for invalid email: " + invalidEmail);
    }
}
