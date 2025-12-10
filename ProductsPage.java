package pages;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    private WebElement searchBox;

    @FindBy(id = "submit_search")
    private WebElement searchBtn;

    @FindBy(css = ".productinfo.text-center p")
    private WebElement productName;

    @FindBy(css = "a.add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement viewCartBtn;

    public void searchProduct(String product){
        type(searchBox, product);
        click(searchBtn);
    }

    public void addFirstProductToCart(){
        click(addToCartBtn);
    }

    public void goToCart(){
        click(viewCartBtn);
    }
}