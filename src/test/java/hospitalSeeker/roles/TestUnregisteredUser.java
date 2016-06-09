package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestUnregisteredUser extends BaseRoleTest {

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }

    @BeforeMethod
    public void beforeMethod() {
        browserAction.goTo(HOME_URL);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForUnregisteredUsers() {
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForUnregisteredUsers() {
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
        browserAction.sleep();
    }

    @Test
    public void testAccessDeniedToPatientsListForUnregisteredUser() {
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }

}
