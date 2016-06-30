package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestUnregisteredUser extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(HOME_URL);
    }

    @Test
    public void testForbiddenButtonsForUnregisteredUsers() {
        String error = browser.checkIfElementNotPresent(headerPage.actionsButton)
                .concat(browser.checkIfElementNotPresent(headerPage.cardButton))
                .concat(browser.checkIfElementNotPresent(headerPage.manageButton))
                .concat(browser.checkIfElementNotPresent(headerPage.patientsButton));
        if (error.isEmpty()) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testDeniedUrlsForUnregisteredUsers(String errorMessage, String url) {
        browser.goTo(url);
        assertTrue(browser.containsText("Please Login"), "access not denied to page: ".concat(errorMessage));
    }
}
