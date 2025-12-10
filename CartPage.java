package pages;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a.check_out")
    private WebElement checkoutBtn;

    @FindBy(css = "a.btn.btn-default.check_out")
    private WebElement registerLoginBtn;

    public void clickCheckout(){
        click(checkoutBtn);
    }

    public void clickRegisterLogin(){
        click(registerLoginBtn);
    }
}
