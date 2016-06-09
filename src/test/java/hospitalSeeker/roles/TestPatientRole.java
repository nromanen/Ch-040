package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPatientRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(HOME_URL);
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForPatients() {
        assertFalse(browser.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browser.isElementPresent(adminPage.dashboardTable), "element is present");
        browser.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForPatients() {
        assertFalse(browser.isElementPresent(adminPage.optionsButton), "element is present");
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browser.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForPatient() {
        assertFalse(browser.isElementPresent(Header.patientsButtonByText), "element is present");
        browser.goTo(PATIENTS_LIST_URL);
        assertTrue(browser.containsText("Log in"), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
