package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPatientRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForPatients() {
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForPatients() {
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForPatient() {
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByText), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
