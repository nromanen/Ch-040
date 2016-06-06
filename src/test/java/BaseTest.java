import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public BrowserWrapper browserAction;
    public static final String homeUrl = "http://91.209.24.68/ch-040";
    public static final String doctorPageUrl = "http://91.209.24.68/ch-040/hospital/1/department/1";
    public static final String adminDashboardUrl = "http://91.209.24.68/ch-040/admin/dashboard";
    public static final String addingNewHospitalUrl = "http://91.209.24.68/ch-040/admin/map/new";
    public static final String hospitalsUrl = "http://91.209.24.68/ch-040/hospitals";
    public static final String departmentUrl = "http://91.209.24.68/ch-040/hospital/1";
    public static final String doctorsUrl = "http://91.209.24.68/ch-040/hospital/1/department/1";
    public static final String doctorUrl = "http://91.209.24.68/ch-040/dashboard?id=37&did=1";
    public static final String patientsListUrl = "http://91.209.24.68/ch-040/patients";
    
    public static final String adminLogin = "admin@ad.ad";
    public static final String adminPassword = "qwer";
    public static final String managerLogin = "manager@com.com";
    public static final String managerPassword = "manager";
    public static final String doctorLogin = "doctor@com.com";
    public static final String doctorPassword = "doctor";
    public static final String patientLogin = "tutu@ukr.net";
    public static final String patientPassword = "tutu2016";

    @BeforeMethod
    public void beforeMethod() {
        browserAction = new BrowserWrapper(new FirefoxDriver());
        browserAction.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
