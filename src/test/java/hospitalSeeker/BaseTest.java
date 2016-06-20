package hospitalSeeker;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public BrowserWrapper browser;

    public BrowserWrapper getWrapper() {
        return browser;
    }

    public static final String HOME_URL = "https://localhost:8443/HospitalSeeker/";
    public static final String DOCTOR_PAGE_URL = HOME_URL.concat("hospital/1/department/1");
    public static final String ADMIN_DASHBOARD_URL = HOME_URL.concat("admin/users?status=all");
    public static final String ADDING_NEW_HOSPITAL_URL = HOME_URL.concat("admin/map/new");
    public static final String ADMIN_ENABLED_USERS = HOME_URL.concat("admin/users?status=true");
    public static final String HOSPITALS_URL = HOME_URL.concat("hospitals");
    public static final String DOCTOR_URL = HOME_URL.concat("dashboard?id=37&did=1");
    public static final String PATIENTS_LIST_URL = HOME_URL.concat("patients");
    public static final String LOGIN_URL = HOME_URL.concat("login");
    public static final String REGISTER_URL = HOME_URL.concat("newUser");
    public static final String FIND_URL = HOME_URL.concat("mapsearch");
    public static final String VALIDATE_URL = HOME_URL.concat("admin/map/validate");

    public static final String ADMIN_LOGIN = "admin@hospitals.ua";
    public static final String ADMIN_PASSWORD = "1111";
    public static final String MANAGER_LOGIN = "manager.kh@hospitals.ua";
    public static final String MANAGER_PASSWORD = "1111";
    public static final String DOCTOR_LOGIN = "doctor.gh@hospitals.ua";
    public static final String DOCTOR_PASSWORD = "1111";
    public static final String PATIENT_LOGIN = "patient.cd@hospitals.ua";
    public static final String PATIENT_PASSWORD = "1111";

    @BeforeClass
    public void beforeClass() {
        browser = new BrowserWrapper(BrowserInitialization.initialize());
    }

    @AfterClass
    public void afterClass() {
        browser.getDriver().quit();
    }

}
