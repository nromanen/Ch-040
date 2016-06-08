package hospitalSeeker;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public BrowserWrapper browserAction;
    public static final String HOME_URL = "localhost:8080/HospitalSeeker/";
    public static final String DOCTOR_PAGE_URL = HOME_URL.concat("hospital/1/department/1");
    public static final String ADMIN_DASHBOARD_URL = HOME_URL.concat("admin/dashboard");
    public static final String ADDING_NEW_HOSPITAL_URL = HOME_URL.concat("admin/map/new");
    public static final String HOSPITALS_URL = HOME_URL.concat("hospitals");
    public static final String DOCTOR_URL = HOME_URL.concat("dashboard?id=37&did=1");
    public static final String PATIENTS_LIST_URL = HOME_URL.concat("patients");
    public static final String LOGIN_URL = HOME_URL.concat("login");
    public static final String REGISTER_URL = HOME_URL.concat("newUser");
    public static final String FIND_URL = HOME_URL.concat("mapsearch");
    public static final String VALIDATE_URL = HOME_URL.concat("admin/map/validate");

    public static final String ADMIN_LOGIN = "admin@ad.ad";
    public static final String ADMIN_PASSWORD = "qwer";
    public static final String MANAGER_LOGIN = "manager@com.com";
    public static final String MANAGER_PASSWORD = "manager";
    public static final String DOCTOR_LOGIN = "doctor@com.com";
    public static final String DOCTOR_PASSWORD = "doctor";
    public static final String PATIENT_LOGIN = "tutu@ukr.net";
    public static final String PATIENT_PASSWORD = "tutu2016";



    @BeforeMethod
    public void beforeMethod() {
        browserAction = new BrowserWrapper(new FirefoxDriver());
        browserAction.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
