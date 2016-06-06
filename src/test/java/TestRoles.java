import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestRoles extends BaseTest {

    DropdownLogin dropdownLogin;
    AdminPage adminPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        dropdownLogin = PageFactory.initElements(browserAction.getDriver(), DropdownLogin.class);
        adminPage = PageFactory.initElements(browserAction.getDriver(), AdminPage.class);
        header = PageFactory.initElements(browserAction.getDriver(), Header.class);
    }

    // 1. Go to home page
    // 2. Log in as admin using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button, options button and admin dashboard are present
    // 4. Log out by clicking "Log out" button
    @Test
    public void testDefaultAdminPage() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        assertTrue(browserAction.isElementPresentByXpath(Header.adminButtonXPATH), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminPage.dashboardTable), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminPage.optionsButton), "element isn't present");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Check if admin button and admin dashboard aren't present
    // 3. Go to admin/dashboard url
    // 4. Check if access to this page is denied
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForUnregisteredUsers() {
        browserAction.goTo(HOME_URL);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    // 1. Go to home page
    // 2. Log in as patient using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForPatients() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Log in as manager using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForManagers() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Log in as doctor using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForDoctors() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminPage.dashboardTable), "element is present!");
        browserAction.goTo(ADMIN_DASHBOARD_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Check if options button isn't present
    // 3. Go to admin/map/new url
    // 4. Check if access to this page is denied
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForUnregisteredUsers() {
        browserAction.goTo(HOME_URL);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
        browserAction.sleep();
    }

    // 1. Go to home page
    // 2. Log in as patient using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if options button isn't present
    // 4. Go to admin/map/new url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForPatients() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Log in as doctor using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if options button isn't present
    // 4. Go to admin/map/new url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForDoctors() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Log in as manager using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if options button isn't present
    // 4. Go to admin/map/new url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForManagers() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        assertFalse(browserAction.isElementPresent(adminPage.optionsButton), "element is present");
        browserAction.goTo(ADDING_NEW_HOSPITAL_URL);
        assertTrue(browserAction.containsText("not authorized to access"), "access not denied");
        dropdownLogin.logout();
    }

    // 1. Go to home page
    // 2. Log in as patient using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if patients button isn't present
    // 4. Go to /patients url
    // 5. Check if there isn't table with patients
    // 6. Log out by clicking "Log out" button
    @Test
    public void testAccessDeniedToPatientsListForUnregisteredUsers() {
        browserAction.goTo(HOME_URL);
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(PATIENTS_LIST_URL);
        assertTrue(browserAction.containsText("Log in"), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }
}
