package pages;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "subject")
    private WebElement subject;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(name = "submit")
    private WebElement submitBtn;

    public void fillContactForm(String n, String e, String s, String m){
        type(name, n);
        type(email, e);
        type(subject, s);
        type(message, m);
        click(submitBtn);
    }
}
