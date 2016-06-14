package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.LoginPage;
import hospitalSeeker.header.HeaderPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    HeaderPage headerPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeMethod();
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);
        headerPage = HeaderPage.init(browser.getDriver());
    }

}
