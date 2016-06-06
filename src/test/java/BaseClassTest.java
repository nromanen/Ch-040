import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 25-May-16.
 */
public class BaseClassTest {

    public BrowserWrapper browserAction;
    public static final String homeUrl = "http://91.209.24.68/ch-040";
    //public static final String doctorUrl = "http://91.209.24.68/dashboard?id=37&did=1";

//    public BaseTest(WebDriver driver) {
//        this.driver = driver;
//    }

    @BeforeMethod
    public void beforeMethod() {
        browserAction = new BrowserWrapper(new FirefoxDriver());
        System.out.println("BaseTest");
        browserAction.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
