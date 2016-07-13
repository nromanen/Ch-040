package hospitalSeeker.roles;

import hospitalSeeker.pages.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.templates.Header;
import hospitalSeeker.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class BaseRoleTest extends BaseTest {

    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static Header header;

    @BeforeMethod
    public void beforeMethod() {
//        super.beforeMethod();
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);
        header = PageFactory.initElements(browser.getDriver(), Header.class);
    }

    @DataProvider(name = "primaryAdminUrls")
    public Object[][] primaryAdminUrls() {
        return new Object[][] { { "allUsers", ADMIN_DASHBOARD_URL },
                { "addNewUser", ADDING_NEW_USER_URL },
                { "hospitalList", HOSPITAL_LIST_URL },
                { "newHospital", ADDING_NEW_HOSPITAL_URL },
                { "checkHospitals", CHECK_HOSPITALS_LIST_URL },
                { "editHospitalManager", EDIT_HOSPITALS_MANAGERS_URL },
                { "configureTokens", CONFIGURE_TOKENS_URL }};
    }
}