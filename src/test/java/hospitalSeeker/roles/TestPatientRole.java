package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestPatientRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
    }

    @Test
    public void testForbiddenButtonsForPatients() {
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(header.patientsButton))
                .concat(browser.checkIfElementNotPresent(header.manageButton));
        if (error.isEmpty()) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testDeniedUrlsForPatients(String errorMessage, String url) {
        browser.goTo(url);
        assertTrue(browser.containsText("not authorized to access"), "access not denied to page: ".concat(errorMessage));
    }

}
