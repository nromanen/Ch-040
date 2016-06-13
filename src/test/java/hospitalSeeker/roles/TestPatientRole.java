package hospitalSeeker.roles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPatientRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForPatients() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present");
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present");
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForPatients() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present");
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForPatient() {
        assertFalse(browser.isElementPresent(header.patientsButton), "element is present");
        browser.goTo(PATIENTS_LIST_URL);
        assertTrue(browser.containsText("Log in"), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        header.logoutButton.click();
    }

}
