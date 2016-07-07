package hospitalSeeker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public BrowserWrapper browser;
    public DatabaseConfig databaseConfig;

    public BrowserWrapper getWrapper() {
        return browser;
    }

    public static final String HOME_URL = "https://localhost:8443/HospitalSeeker/";
    public static final String DOCTOR_PAGE_URL = HOME_URL.concat("hospital/1/department/1/doctor/6/dashboard");
    public static final String ADMIN_DASHBOARD_URL = HOME_URL.concat("admin/users?status=true");
    public static final String ADDING_NEW_HOSPITAL_URL = HOME_URL.concat("admin/map/new");
    public static final String ADDING_NEW_USER_URL = HOME_URL.concat("admin/newUser");
    public static final String HOSPITAL_LIST_URL = HOME_URL.concat("admin/map/listhospitals");
    public static final String HOSPITALS_URL = HOME_URL.concat("hospitals");
    public static final String EDIT_HOSPITALS_MANAGERS_URL = HOME_URL.concat("editHospitalsManagers");
    public static final String CHECK_HOSPITALS_LIST_URL = HOME_URL.concat("admin/map/validate");
    public static final String PATIENTS_LIST_URL = HOME_URL.concat("patients");
    public static final String LOGIN_URL = HOME_URL.concat("login");
    public static final String CONFIGURE_TOKENS_URL = HOME_URL.concat("admin/configureToken");
    public static final String REGISTER_URL = HOME_URL.concat("registration");
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

    @BeforeMethod
    public void before() {
        databaseConfig = new DatabaseConfig();
        databaseConfig.databaseSetup();
        browser = new BrowserWrapper(BrowserInitialization.initialize());
        browser.browserMaximize();
    }

    @AfterMethod
    public void after() {
        browser.getDriver().quit();
        databaseConfig.databaseTearDown();
    }
}
