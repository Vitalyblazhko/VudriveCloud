import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowser {
    WebDriver mWebDriver;

    @BeforeClass
    public void setUp() {
        mWebDriver = new ChromeDriver();
    }

    @Test
    public void openSiteTest() {
        mWebDriver.get("http://vudrive.net");
    }

    @AfterClass
    public void tearDown(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mWebDriver.quit();
    }
}
