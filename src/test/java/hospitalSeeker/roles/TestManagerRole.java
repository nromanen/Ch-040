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
        String error = browser.checkIfElementNotPresent(headerPage.actionsButton)
                .concat(browser.checkIfElementNotPresent(headerPage.cardButton))
                .concat(browser.checkIfElementNotPresent(headerPage.patientsButton));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testAccessDeniedDashboardForManagers() {
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewHospitalForManagers() {
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewUserForManagers() {
        browser.goTo(ADDING_NEW_USER_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedEditManagersForManagers() {
        browser.goTo(EDIT_HOSPITALS_MANAGERS_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

}
