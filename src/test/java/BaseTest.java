import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public BrowserWrapper browserAction;
    public static final String HOME_URL = "http://91.209.24.68/ch-040";
    public static final String DOCTOR_PAGE_URL = "http://91.209.24.68/ch-040/hospital/1/department/1";
    public static final String ADMIN_DASHBOARD_URL = "http://91.209.24.68/ch-040/admin/dashboard";
    public static final String ADDING_NEW_HOSPITAL_URL = "http://91.209.24.68/ch-040/admin/map/new";
    public static final String HOSPITALS_URL = "http://91.209.24.68/ch-040/hospitals";
    public static final String DEPARTMENT_URL = "http://91.209.24.68/ch-040/hospital/1";
    public static final String DOCTORS_URL = "http://91.209.24.68/ch-040/hospital/1/department/1";
    public static final String DOCTOR_URL = "http://91.209.24.68/ch-040/dashboard?id=37&did=1";
    public static final String PATIENTS_LIST_URL = "http://91.209.24.68/ch-040/patients";
    public static final String PATIENTS_URL = "http://91.209.24.68/ch-040/patients";
    
    public static final String ADMIN_LOGIN = "admin@ad.ad";
    public static final String ADMIN_PASSWORD = "qwer";
    public static final String MANAGER_LOGIN = "manager@com.com";
    public static final String MANAGER_PASSWORD = "manager";
    public static final String DOCTOR_LOGIN = "doctor@com.com";
    public static final String DOCTOR_PASSWORD = "doctor";
    public static final String PATIENT_LOGIN = "tutu@ukr.net";
    public static final String PATIENT_PASSWORD = "tutu2016";
    private static final String USER_NAME_FOR_PATIENT = "pat12@uk.uk";
  	private static final String PASSWORD_FOR_PATIENT = "pat12";
  	private static final String USER_NAME_FOR_DOCTOR = "doctor@com.com";
  	private static final String PASSWORD_FOR_DOCTOR = "doctor";
  	

    @BeforeMethod
    public void beforeMethod() {
        browserAction = new BrowserWrapper(new FirefoxDriver());
        browserAction.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
