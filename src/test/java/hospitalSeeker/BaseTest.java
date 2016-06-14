package hospitalSeeker;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public BrowserWrapper browser;
    public static final String HOME_URL = "http://localhost:8080/HospitalSeeker/";
    public static final String DOCTOR_PAGE_URL = HOME_URL.concat("hospital/1/department/1");
    public static final String ADMIN_DASHBOARD_URL = HOME_URL.concat("admin/users?status=all");
    public static final String ADDING_NEW_HOSPITAL_URL = HOME_URL.concat("admin/map/new");
    public static final String HOSPITALS_URL = HOME_URL.concat("hospitals");
    public static final String DOCTOR_URL = HOME_URL.concat("dashboard?id=37&did=1");
    public static final String PATIENTS_LIST_URL = HOME_URL.concat("patients");
    public static final String LOGIN_URL = HOME_URL.concat("login");
    public static final String REGISTER_URL = HOME_URL.concat("newUser");
    public static final String FIND_URL = HOME_URL.concat("mapsearch");
    public static final String VALIDATE_URL = HOME_URL.concat("admin/map/validate");
    public static final String LOGINERROR_URL = HOME_URL.concat("login?error");
    
    public static final String ADMIN_LOGIN = "admin@hospitals.ua";
    public static final String ADMIN_PASSWORD = "1111";
    public static final String MANAGER_LOGIN = "manager@com.com";
    public static final String MANAGER_PASSWORD = "manager";
    public static final String DOCTOR_LOGIN = "doctor.gh@hospitals.ua";
    public static final String DOCTOR_PASSWORD = "1111";
    public static final String PATIENT_LOGIN = "Atutu@ukr.net";
    public static final String PATIENT_PASSWORD = "Atutu2016";


    public void firefox() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        browser = new BrowserWrapper(new MarionetteDriver());
    }

    public void firefoxLinux() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        browser = new BrowserWrapper(new MarionetteDriver());
    }

    public void chrome() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        browser = new BrowserWrapper(new ChromeDriver());
    }

    public void chromeLinux() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        browser = new BrowserWrapper(new ChromeDriver());
    }

    public void internetExplorer() {
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        caps.setCapability("nativeEvents",false);
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriver.exe");
        browser = new BrowserWrapper(new InternetExplorerDriver(caps));
    }

    @BeforeMethod
    public void beforeMethod() {
       firefox();
    }

    @AfterClass
    public void afterClass() {
        browser.getDriver().quit();
    }

}
