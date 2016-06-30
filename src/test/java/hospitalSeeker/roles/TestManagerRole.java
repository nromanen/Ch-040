package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestManagerRole extends BaseRoleTest {


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
    }

    @Test
    public void testForbiddenButtonsForManagers() {
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(header.cardButton))
                .concat(browser.checkIfElementNotPresent(header.patientsButton));
        if (error.isEmpty()) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testDeniedUrlsForManagers(String errorMessage, String url) {
        browser.goTo(url);
        assertTrue(browser.containsText("not authorized to access"), "access not denied to page: ".concat(errorMessage));
    }

}
