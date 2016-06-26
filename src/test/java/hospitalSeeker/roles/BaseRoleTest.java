package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.HeaderPage;
import hospitalSeeker.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        headerPage = HeaderPage.init(browser.getDriver());
    }



    @DataProvider(name = "forbiddenUrls")
    public Object[][] forbiddenUrls() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "not authorized to access" },
                { ADDING_NEW_HOSPITAL_URL, "not authorized to access" }, { PATIENTS_LIST_URL, "Patient" } };
    }

    @DataProvider(name = "urlsForUnreg")
    public Object[][] urlsForUnreg() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "Please Log In" },
                { ADDING_NEW_HOSPITAL_URL, "Please Log In" }, { PATIENTS_LIST_URL, "Please Log In" } };
    }

}
