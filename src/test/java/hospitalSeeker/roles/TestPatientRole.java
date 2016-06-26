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
        String error = browser.checkIfElementNotPresent(headerPage.actionsButton)
                .concat(browser.checkIfElementNotPresent(headerPage.patientsButton))
                .concat(browser.checkIfElementNotPresent(headerPage.manageButton));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testAccessDeniedDashboardForPatients() {
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewHospitalForPatients() {
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewUserForPatients() {
        browser.goTo(ADDING_NEW_USER_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedEditManagersForPatients() {
        browser.goTo(EDIT_HOSPITALS_MANAGERS_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

}
