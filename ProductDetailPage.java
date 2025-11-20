package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class ProductDetailPage {

    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id = "quantity")
    WebElement quantityInput;

   
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartBtn;

    
    @FindBy(xpath = "//a[contains(@href,'/view_cart')]")
    WebElement viewCartBtn;

    
    
    public void setQuantity(int qty) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(qty));
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }

    public void clickViewCart() {
        scrollIntoView(viewCartBtn);
        viewCartBtn.click();
    }
    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productNameField;

    public String getProductName() {
        return productNameField.getText();
    }

    
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}