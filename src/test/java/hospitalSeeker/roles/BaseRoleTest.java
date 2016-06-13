package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.LoginPage;
import hospitalSeeker.header.Header;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    Header header;

    @BeforeClass
    public void beforeClass() {
        super.beforeMethod();
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);

//        header = header.init(browser.getDriver());
        header = PageFactory.initElements(browser.getDriver(), Header.class);
//        browser.waitUntilElementVisible(header.homeButton);
    }

}
