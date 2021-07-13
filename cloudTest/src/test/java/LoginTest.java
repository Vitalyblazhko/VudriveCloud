import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        login();

        mWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + USER_NAME + "']")));

        Assert.assertTrue(isUserLoggedIn());

    }


}
