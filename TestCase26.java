package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase26 extends BaseTest {

    @Test
    public void scrollUpWithoutArrow(){

    	((JavascriptExecutor) driver).executeScript(
    	        "window.scrollTo(0, document.body.scrollHeight)"
    	);

    	((JavascriptExecutor) driver).executeScript(
    	        "window.scrollTo(0, 0)"
    	);

        String text = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        Assert.assertTrue(text.contains("FEATURES ITEMS"));
    }
}
