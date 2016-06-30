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
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(header.cardButton))
                .concat(browser.checkIfElementNotPresent(header.manageButton))
                .concat(browser.checkIfElementNotPresent(header.patientsButton));
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
