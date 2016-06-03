import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public BrowserWrapper browserAction;
    public static String homeUrl = "http://91.209.24.68/ch-040";
    public static String doctorPageUrl = "http://91.209.24.68/ch-040/hospital/1/department/1";
    public static String adminDashboardUrl = "http://91.209.24.68/ch-040/admin/dashboard";
    public static String addingNewHospitalUrl = "http://91.209.24.68/ch-040/admin/map/new";

    @BeforeMethod
    public void beforeMethod() {
        browserAction = new BrowserWrapper(new FirefoxDriver());
        browserAction.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
