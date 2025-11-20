package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTest {

    protected WebDriver driver;
    String baseURL = "https://automationexercise.com";

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}