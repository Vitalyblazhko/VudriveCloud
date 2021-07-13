import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Element;

import java.security.cert.TrustAnchor;

public class LogoutTest extends TestBase{

    @BeforeMethod
    public void preconditions() {
        if(!isUserLoggedIn()) {
            login();
        }
        if(isElementPresent(By.cssSelector(".eupopup-button.eupopup-button_1"))) {
            mWebDriver.findElement(By.cssSelector(".eupopup-button.eupopup-button_1")).click();
        }
    }

    @Test
    public void testLogout() {
        Actions actions = new Actions(mWebDriver);
        actions.moveToElement(mWebDriver.findElement(By.xpath("//a[text()='" + USER_NAME + "']"))).perform();

        WebElement element = mWebDriver.findElement(By.xpath("//a[text()='Logout']"));
        JavascriptExecutor js = (JavascriptExecutor) mWebDriver;
        js.executeScript("arguments[0].click();",element);

        mWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='" + USER_NAME + "']")));

        Assert.assertFalse(isUserLoggedIn());

    }
}
