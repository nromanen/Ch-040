package hospitalSeeker.roles;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestAdminRole extends BaseRoleTest {


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void testPrimaryAdminElements() {
        String error = browser.checkIfElementNotPresent(headerPage.actionsButton)
                .concat(browser.checkIfElementNotPresent(adminPage.allUsersTable));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testAccessToAdminPages(String errorMessage, String url) {
        browser.goTo(url);
        assertEquals(browser.getCurrentUrl(), url, "urls don't match! problem with this url: ".concat(errorMessage));
    }
}
