package hospitalSeeker;

import hospitalSeeker.header.DropdownLogin;
import hospitalSeeker.header.Header;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestRoles extends BaseTest {

    DropdownLogin dropdownLogin;
    AdminPage adminPage;
    Header header;


    @BeforeClass
    public void beforeClass() {
        super.beforeMethod();
        dropdownLogin = PageFactory.initElements(browserAction.getDriver(), DropdownLogin.class);
        adminPage = PageFactory.initElements(browserAction.getDriver(), AdminPage.class);
        header = PageFactory.initElements(browserAction.getDriver(), Header.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        browserAction.goTo(HOME_URL);
    }

    @Test
    public void testDefaultAdminPage() {
        dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        assertTrue(browserAction.isElementPresentByXpath(Header.adminButtonXPATH), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminPage.dashboardTable), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminPage.optionsButton), "element isn't present");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAdminDashboardForUnregisteredUsers() {
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @Test
    public void testAccessDeniedToAdminDashboardForPatients() {
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAdminDashboardForManagers() {
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAdminDashboardForDoctors() {
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForUnregisteredUsers() {
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
        browserAction.sleep();
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForPatients() {
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForDoctors() {
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToAddingNewHospitalForManagers() {
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToPatientsListForUnregisteredUser() {
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @Test
    public void testAccessDeniedToPatientsListForPatient() {
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByText), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToPatientsListForDoctor() {
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        assertTrue(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Patient"), "access denied");
        dropdownLogin.logout();
    }

    @Test
    public void testAccessDeniedToPatientsListForManager() {
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByText), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
        dropdownLogin.logout();
    }


    @AfterClass
    public void afterClass() {
        browserAction.getDriver().quit();
    }
}
