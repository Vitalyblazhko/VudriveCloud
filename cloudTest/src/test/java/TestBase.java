import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver mWebDriver;
    WebDriverWait mWait;

    String URL = "https://vudrive.net";
    String USER_NAME = "vitalyb@jungo.com";
    String PASSWORD = "pGwNCt3m";

    @BeforeClass
    public void setUp() {
        mWebDriver = new FirefoxDriver();
        mWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mWait = new WebDriverWait(mWebDriver, 5, 100);
        openSite(URL);
    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mWebDriver.quit();
    }

    public void type(By by, String input) {
        mWebDriver.findElement(by).click();
        mWebDriver.findElement(by).clear();
        mWebDriver.findElement(by).sendKeys(input);
    }

    public void clickLoginButton(String id) {
        mWebDriver.findElement(By.id(id)).click();
    }

    public void clickLogout(By by) {
        mWebDriver.findElement(by).click();
    }

    public void openSite(String url) {
        mWebDriver.get(url);
    }

    public void login() {
        type(By.id("email"), USER_NAME);
        type(By.id("password"), PASSWORD);
        clickLoginButton("login");
    }

    protected boolean isElementPresent(By by) {
        try{
            mWebDriver.findElement(by);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[text()='vitalyb@jungo.com']"));
    }
}
