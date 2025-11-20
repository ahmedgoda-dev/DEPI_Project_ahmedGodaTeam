package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionTitle;
    
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement emailField;
    
    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribeButton;
    
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;
    
    public boolean isSubscriptionTitleVisible() {
        return subscriptionTitle.isDisplayed();
    }
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
    public void clickSubscribe() {
        subscribeButton.click();
    }
    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_description']/h4/a")
    WebElement product1Name;

    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']/p")
    WebElement product1Price;

    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']/button")
    WebElement product1Quantity;

    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_total']/p")
    WebElement product1Total;

    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_description']/h4/a")
    WebElement product2Name;

    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']/p")
    WebElement product2Price;

    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_quantity']/button")
    WebElement product2Quantity;

    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_total']/p")
    WebElement product2Total;

    // --- Getter methods ---
    public String getProductName(int productIndex) {
        return productIndex == 1 ? product1Name.getText() : product2Name.getText();
    }

    public String getProductPrice(int productIndex) {
        return productIndex == 1 ? product1Price.getText() : product2Price.getText();
    }

    public String getProductQuantity(int productIndex) {
        return productIndex == 1 ? product1Quantity.getText() : product2Quantity.getText();
    }

    public String getProductTotal(int productIndex) {
        return productIndex == 1 ? product1Total.getText() : product2Total.getText();
    }
}
