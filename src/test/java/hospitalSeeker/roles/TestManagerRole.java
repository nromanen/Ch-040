package hospitalSeeker.roles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestManagerRole extends BaseRoleTest {


    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForManagers() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present!");
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present!");
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForManagers() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present");
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForManager() {
        assertFalse(browser.isElementPresent(header.patientsButton), "element is present");
        browser.goTo(PATIENTS_LIST_URL);
        assertTrue(browser.containsText("Log in"), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        header.logoutButton.click();
    }

}
