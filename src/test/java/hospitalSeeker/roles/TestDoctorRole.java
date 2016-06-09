package hospitalSeeker.roles;

import hospitalSeeker.header.Header;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDoctorRole extends BaseRoleTest {

    // TODO: 09.06.16 what if use browser instead of browserAction?

    @BeforeMethod
    public void beforeMethod(){
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
    }

    @Test
    public void testAccessDeniedToAdminDashboardForDoctors() {
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForDoctors() {
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForDoctor() {
        assertTrue(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Patient"), "access denied");
    }

    @AfterMethod
    public void afterMethod() {
        dropdownLogin.logout();
    }

}
