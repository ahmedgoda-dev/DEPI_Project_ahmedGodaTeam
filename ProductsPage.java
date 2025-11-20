package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;


public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-product-id='1']")
    WebElement firstProductAddToCart;

    @FindBy(xpath = "//a[@data-product-id='2']")
    WebElement secondProductAddToCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement viewCartBtn;

    
    public void addToCart(int productIndex) {
        WebElement product = (productIndex == 1) ? firstProductAddToCart : secondProductAddToCart;

        scrollIntoView(product);

        try {
            product.click();
        } catch (Exception e) {
            jsClick(product); // JS fallback
        }

        sleep(3000); // modal wait
    }

    /** Continue shopping button after the pop-up */
    public void clickContinueShopping() {
        scrollIntoView(continueShoppingBtn);

        try {
            continueShoppingBtn.click();
        } catch (Exception e) {
            jsClick(continueShoppingBtn);
        }

        sleep(3000);
    }

    /** View cart button (JS click fallback added) */
    public void clickViewCart() {
        scrollIntoView(viewCartBtn);

        try {
            viewCartBtn.click();
        } catch (Exception e) {
            jsClick(viewCartBtn);
        }

        sleep(3000); // allow cart page to load
    }


    // ===================== HELPERS =====================

    /** Scroll element into view */
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        sleep(500);
    }

    /** JavaScript click fallback */
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /** Sleep wrapper */
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {}
    }
}
