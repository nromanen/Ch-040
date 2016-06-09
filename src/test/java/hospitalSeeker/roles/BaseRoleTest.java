package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.header.DropdownLogin;
import hospitalSeeker.header.Header;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseRoleTest extends BaseTest {

    DropdownLogin dropdownLogin;
    AdminPage adminPage;
    Header header;

    @BeforeClass
    public void beforeClass() {
        super.beforeMethod();
        dropdownLogin = PageFactory.initElements(browserAction.getDriver(), DropdownLogin.class);
        adminPage = PageFactory.initElements(browserAction.getDriver(), AdminPage.class);
        header = PageFactory.initElements(browserAction.getDriver(), Header.class);
    }

    @AfterClass
    public void afterClass() {
        browserAction.getDriver().quit();
    }

}
