package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCase25 extends BaseTest {

    @Test
    public void scrollUpWithArrowButton(){

    	((JavascriptExecutor) driver).executeScript(
    	        "window.scrollTo(0, document.body.scrollHeight)"
    	);

        driver.findElement(By.cssSelector("#scrollUp")).click();

        String text = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        Assert.assertTrue(text.contains("FEATURES ITEMS"));
    }
}
