package AhmedProject;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAddressDetailsTest extends BaseTest {

    @Test
    public void verifyAddressDetails() throws InterruptedException {

        driver.get("https://automationexercise.com/");

        // Add product to cart
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(1500);
        driver.findElement(By.linkText("View Cart")).click();

        // Proceed to checkout
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Login page appears
        driver.findElement(By.linkText("Register / Login")).click();

        // Register a new user
        driver.findElement(By.name("name")).sendKeys("Ahmed Tester");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']"))
              .sendKeys("ahmed" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

        // Fill account details
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("first_name")).sendKeys("Ahmed");
        driver.findElement(By.id("last_name")).sendKeys("Tarek");
        driver.findElement(By.id("address1")).sendKeys("Test Street");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Nasr City");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("0100000000");
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        // Continue
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Verify Address Headers
        String deliveryHeader = driver.findElement(By.xpath("//h3[text()='Your delivery address']")).getText();
        String billingHeader = driver.findElement(By.xpath("//h3[text()='Your billing address']")).getText();

        Assert.assertEquals(deliveryHeader.trim(), "YOUR DELIVERY ADDRESS");
        Assert.assertEquals(billingHeader.trim(), "YOUR BILLING ADDRESS");
    }

    @Test
    public void downloadInvoiceAfterPurchase() throws InterruptedException {

        driver.get("https://automationexercise.com/");

        // Add product
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Checkout
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Payment
        driver.findElement(By.name("name_on_card")).sendKeys("Ahmed");
        driver.findElement(By.name("card_number")).sendKeys("1111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2029");
        driver.findElement(By.id("submit")).click();

        // Download Invoice
        driver.findElement(By.linkText("Download Invoice")).click();

        Assert.assertTrue(true, "Invoice download button clicked successfully.");
    }

    @Test
    public void verifyScrollWithArrowButton() throws InterruptedException {

        driver.get("https://automationexercise.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll Down
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);

        // Click Arrow Button
        driver.findElement(By.id("scrollUp")).click();
        Thread.sleep(1500);

        // Verify Top
        Long scrollPos = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertEquals(scrollPos.longValue(), 0L);
    }

    @Test
    public void verifyScrollWithoutArrowButton() throws InterruptedException {

        driver.get("https://automationexercise.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1200);

        // Scroll up manually
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(1200);

        // Verify top
        Long scrollPos = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertEquals(scrollPos.longValue(), 0L);
    }
}
