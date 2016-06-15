package hospitalSeeker;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public BrowserWrapper browser = new BrowserWrapper(BrowserInitialization.initialize());

    public static final String HOME_URL = "http://localhost:8080/HospitalSeeker/";
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
    public static final String MANAGER_LOGIN = "manager@com.com";
    public static final String MANAGER_PASSWORD = "manager";
    public static final String DOCTOR_LOGIN = "doctor.gh@hospitals.ua";
    public static final String DOCTOR_PASSWORD = "1111";
    public static final String PATIENT_LOGIN = "Atutu@ukr.net";
    public static final String PATIENT_PASSWORD = "Atutu2016";

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH:mm");
                Date date = new Date();
                File scrFile = ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("target/surefire-reports/screenshots/" +
                        result.getMethod().getMethodName() + "Failure_" + dateFormat.format(date) + ".png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    @AfterClass
    public void afterClass() {
        browser.getDriver().quit();
    }

}
