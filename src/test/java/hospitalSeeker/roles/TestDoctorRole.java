package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestDoctorRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
    }

    @Test
    public void testForbiddenButtonsForDoctors() {
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(header.cardButton))
                .concat(browser.checkIfElementNotPresent(header.manageButton));
        if (error.isEmpty()) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testDeniedUrlsForDoctors(String errorMessage, String url) {
        browser.goTo(url);
        assertTrue(browser.containsText("not authorfized to access"), "access not denied to page: ".concat(errorMessage));
    }

}
