package pages;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginBtn;

    @FindBy(css = "a[href='/products']")
    private WebElement productsBtn;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsBtn;

    public void clickSignupLogin(){
        click(signupLoginBtn);
    }

    public void clickProducts(){
        click(productsBtn);
    }

    public void clickContactUs(){
        click(contactUsBtn);
    }
}