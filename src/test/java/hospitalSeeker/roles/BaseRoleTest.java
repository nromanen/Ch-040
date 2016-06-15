package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.HeaderPage;
import hospitalSeeker.LoginPage;
import org.testng.annotations.BeforeClass;


public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    HeaderPage headerPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeMethod();
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        headerPage = HeaderPage.init(browser.getDriver());
    }

}
