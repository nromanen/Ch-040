package hospitalSeeker;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;

public class BaseTest {

    public BrowserWrapper browser;
    private IDatabaseTester databaseTester;

    public BrowserWrapper getWrapper() {
        return browser;
    }

    public static final String HOME_URL = "https://localhost:8443/HospitalSeeker/";
    public static final String DOCTOR_PAGE_URL = HOME_URL.concat("hospital/1/department/1/doctor/6/dashboard");
    public static final String ADMIN_DASHBOARD_URL = HOME_URL.concat("admin/users?status=true");
    public static final String ADDING_NEW_HOSPITAL_URL = HOME_URL.concat("admin/map/new");
    public static final String ADDING_NEW_USER_URL = HOME_URL.concat("newUser");
    public static final String HOSPITAL_LIST_URL = HOME_URL.concat("admin/map/listhospitals");
    public static final String HOSPITALS_URL = HOME_URL.concat("hospitals");
    public static final String EDIT_HOSPITALS_MANAGERS_URL = HOME_URL.concat("editHospitalsManagers");
    public static final String CHECK_HOSPITALS_LIST_URL = HOME_URL.concat("admin/map/validate");
    public static final String PATIENTS_LIST_URL = HOME_URL.concat("patients");
    public static final String LOGIN_URL = HOME_URL.concat("login");
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
        browser = new BrowserWrapper(BrowserInitialization.initialize());
        browser.browserMaximize();
        System.out.println("hello");
        try {
            databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/database_full.xml"));
            databaseTester.setDataSet(dataSet);
            databaseTester.onSetup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void after() {
        browser.getDriver().quit();
        try {
            databaseTester.onTearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
