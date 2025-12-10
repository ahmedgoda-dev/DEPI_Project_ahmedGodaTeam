package pages;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends BasePage {

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupBtn;

    public void login(String email, String pass){
        type(loginEmail, email);
        type(loginPassword, pass);
        click(loginBtn);
    }

    public void signup(String name, String email){
        type(signupName, name);
        type(signupEmail, email);
        click(signupBtn);
    }
}
