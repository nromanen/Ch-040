package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class TestAdminRole extends BaseRoleTest{

    @BeforeMethod
    public void beforeMethod(){
        browser.goTo(HOME_URL);
        dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD); // TODO: 09.06.16 loggingIn won't work now
    }

    @Test
    public void testAccessToAdminPage() {
        assertTrue(browser.isElementPresentByXpath(Header.adminButtonXPATH), "element isn't present!");
        assertTrue(browser.isElementPresent(adminPage.dashboardTable), "element isn't present!");
        assertTrue(browser.isElementPresent(adminPage.optionsButton), "element isn't present!");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
