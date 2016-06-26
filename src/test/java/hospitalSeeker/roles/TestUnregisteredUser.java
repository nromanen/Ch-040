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
        System.out.println(error);
    }

    @Test
    public void testAccessDeniedDashboardForUnregisteredUsers() {
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewHospitalForUnregisteredUsers() {
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedAddNewUserForUnregisteredUsers() {
        browser.goTo(ADDING_NEW_USER_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedEditManagersForUnregisteredUsers() {
        browser.goTo(EDIT_HOSPITALS_MANAGERS_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }
}
