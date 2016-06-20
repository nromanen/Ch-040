package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.HeaderPage;
import hospitalSeeker.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    HeaderPage headerPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        headerPage = HeaderPage.init(browser.getDriver());
    }

    @DataProvider(name = "adminElements")
    public Object[][] adminElements() {
        return new Object[][] { { headerPage.actionsButton, "actionsButton" },
                { adminPage.allUsersTable, "allUsersTable" }, { headerPage.patientsButton, "patientsButton" } };
    }

    @DataProvider(name = "urls")
    public Object[][] urls() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "not authorized to access" },
                { ADDING_NEW_HOSPITAL_URL, "not authorized to access" }, { PATIENTS_LIST_URL, "Patient" } };
    }

    @DataProvider(name = "urlsForUnreg")
    public Object[][] urlsForUnreg() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "Please Log In" },
                { ADDING_NEW_HOSPITAL_URL, "Please Log In" }, { PATIENTS_LIST_URL, "Please Log In" } };
    }

}
