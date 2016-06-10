package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestUnregisteredUser extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(HOME_URL);
    }

    @Test
    public void testAccessDeniedToAdminDashboard() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present!");
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present!");
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("Please Log In"), "access not denied!");
    }

    @Test
    public void testAccessDeniedToAddingNewHospital() {
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present!");
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("Please Log In"), "access not denied!");
    }

    @Test
    public void testAccessDeniedToPatientsList() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present!");
        browser.goTo(PATIENTS_LIST_URL);
        assertTrue(browser.containsText("Please Log In"), "access not denied!");
    }

}
