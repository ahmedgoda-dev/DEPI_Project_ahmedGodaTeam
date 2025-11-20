package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartButton;

    public void clickCart() {
        cartButton.click();
    }
    
    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    WebElement homeTitle;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsButton;

    
    public boolean isHomePageVisible() {
        return homeTitle.isDisplayed();
    }

    public void clickProducts() {
        productsButton.click();
    }
    @FindBy(xpath = "(//a[contains(.,'View Product')])[1]")
    WebElement firstProductView;

    public void clickViewProduct(int index) {
        WebElement firstProduct = index == 1 ? firstProductView : null;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", firstProduct);
    }
}