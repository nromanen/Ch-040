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
        dropdownLogin = PageFactory.initElements(browser.getDriver(), DropdownLogin.class);
        adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);

//        header = header.init(browser.getDriver());
        header = PageFactory.initElements(browser.getDriver(), Header.class);
//        browser.waitUntilElementVisible(header.homeButton);
    }

    @AfterClass
    public void afterClass() {
        browser.getDriver().quit();
    }

}
