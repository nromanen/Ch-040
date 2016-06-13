package hospitalSeeker.roles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDoctorRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod(){
        browser.goTo(HOME_URL);
        browser.waitUntilElementVisible(header.homeButton);
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForDoctors() {
        assertFalse(browser.isElementPresent(header.actionsButton), "element is present!");
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present!");
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForDoctors() {
        assertFalse(browser.isElementPresent(adminPage.allUsersTable), "element is present");
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForDoctor() {
        assertTrue(browser.isElementPresent(header.actionsButton), "element is present");
        browser.goTo(PATIENTS_LIST_URL);
        assertTrue(browser.containsText("Patient"), "access denied");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
