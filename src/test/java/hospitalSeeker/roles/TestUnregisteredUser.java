package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestUnregisteredUser extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browserAction.goTo(HOME_URL);
    }

    @Test
    public void testAccessDeniedToAdminDashboard() {
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("Please Log In"), "access not denied!");
    }

    @Test
    public void testAccessDeniedToAddingNewHospital() {
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present!");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("Please Log In"), "access not denied!");
    }

    @Test
    public void testAccessDeniedToPatientsList() {
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present!");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Please Log In"), "access not denied!");
    }

}
