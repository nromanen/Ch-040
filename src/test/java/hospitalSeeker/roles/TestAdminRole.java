package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class TestAdminRole extends BaseRoleTest{

    @BeforeMethod
    public void beforeMethod(){
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD); // TODO: 09.06.16 loggingIn won't work now
    }

    @Test
    public void testAccessToAdminPage() {
        assertTrue(browserAction.isElementPresentByXpath(Header.adminButtonXPATH), "element isn't present!");
        assertTrue(browserAction.isElementPresent(adminPage.dashboardTable), "element isn't present!");
        assertTrue(browserAction.isElementPresent(adminPage.optionsButton), "element isn't present!");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
