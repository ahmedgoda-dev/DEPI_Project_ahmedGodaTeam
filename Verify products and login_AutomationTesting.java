package seleniumCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestCase1 extends BaseTest {
    
    @Test
    public void searchProductsAndVerifyCartAfterLogin() {
        try {
            System.out.println("\n>>> Starting Test Case 20: Search Products and Verify Cart After Login");
            
            // 1. Navigate to Products page
            WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/products']")));
            productsLink.click();
            System.out.println("Step 1: Clicked on Products link");
            
            // 2. Verify ALL PRODUCTS page
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("title")));
            Assert.assertTrue(pageTitle.getText().contains("ALL PRODUCTS"), 
                "Not on ALL PRODUCTS page");
            System.out.println("Step 2: ✓ Verified ALL PRODUCTS page");
            
            // 3. Search for product
            WebElement searchBox = driver.findElement(By.id("search_product"));
            searchBox.clear();
            searchBox.sendKeys("Blue Top");
            driver.findElement(By.id("submit_search")).click();
            System.out.println("Step 3: Searched for 'Blue Top'");
            
            // 4. Verify SEARCHED PRODUCTS
            Thread.sleep(1000);
            WebElement searchTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("title")));
            Assert.assertTrue(searchTitle.getText().contains("SEARCHED PRODUCTS"), 
                "Search results not shown");
            System.out.println("Step 4: ✓ Verified SEARCHED PRODUCTS page");
            
            // 5. Verify products found
            List<WebElement> products = driver.findElements(
                By.cssSelector(".features_items .col-sm-4"));
            Assert.assertTrue(products.size() > 0, "No products found");
            System.out.println("Step 5: ✓ Found " + products.size() + " product(s)");
            
            // 6. Add products to cart
            List<WebElement> addToCartButtons = driver.findElements(
                By.cssSelector(".productinfo .btn.add-to-cart"));
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < Math.min(addToCartButtons.size(), 2); i++) {
                WebElement btn = addToCartButtons.get(i);
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
                Thread.sleep(500);
                js.executeScript("arguments[0].click();", btn);
                
                if (i < Math.min(addToCartButtons.size(), 2) - 1) {
                    WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Continue Shopping')]")));
                    continueBtn.click();
                    Thread.sleep(500);
                }
            }
            System.out.println("Step 6: ✓ Added products to cart");
            
            // 7. View Cart
            WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//u[text()='View Cart']")));
            viewCartBtn.click();
            
            List<WebElement> cartItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("#cart_info_table tbody tr")));
            Assert.assertTrue(cartItems.size() > 0, "Cart is empty");
            System.out.println("Step 7: ✓ Verified products in cart before login: " + cartItems.size() + " item(s)");
            
            // 8. Login
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='login-email']")));
            
          // ⚠️ 9 Date
            driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("Amr_Khaled@gmail.com");
            driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("Amr123");
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
            Thread.sleep(2000);
            System.out.println("Step 8: ✓ Logged in successfully");
            
            // 9. Verify cart after login
            driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
            cartItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("#cart_info_table tbody tr")));
            Assert.assertTrue(cartItems.size() > 0, "Products not in cart after login");
            System.out.println("Step 9: ✓ Verified products still in cart after login: " + cartItems.size() + " item(s)");
            
            System.out.println("\n✅ TEST CASE 20 PASSED - Cart verified successfully after login\n");
            
        } catch (Exception e) {
            System.err.println("\n❌ TEST CASE 20 FAILED: " + e.getMessage() + "\n");
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}