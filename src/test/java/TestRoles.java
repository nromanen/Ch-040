import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestRoles extends BaseTest {

    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage = PageFactory.initElements(browserAction.getDriver(), LoginPage.class);
        adminDashboardPage = PageFactory.initElements(browserAction.getDriver(), AdminDashboardPage.class);
    }

    // 1. Go to home page
    // 2. Log in as admin using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button, options button and admin dashboard are present
    // 4. Log out by clicking "Log out" button
    @Test
    public void testDefaultAdminPage() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(adminLogin, adminPassword);
        assertTrue(browserAction.isElementPresentByXpath(Header.adminButtonXPATH), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminDashboardPage.dashboardTable), "element isn't present");
        assertTrue(browserAction.isElementPresent(adminDashboardPage.optionsButton), "element isn't present");
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Check if admin button and admin dashboard aren't present
    // 3. Go to admin/dashboard url
    // 4. Check if access to this page is denied
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForUnregisteredUsers() {
        browserAction.goTo(homeUrl);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminDashboardPage.dashboardTable), "element is present");
        browserAction.goTo(adminDashboardUrl);
        assertEquals(browserAction.getTitle(), "Login", "access not denied");
        browserAction.sleep();
    }

    // 1. Go to home page
    // 2. Log in as patient using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForPatients() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(patientLogin, patientPassword);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present");
        assertFalse(browserAction.isElementPresent(adminDashboardPage.dashboardTable), "element is present");
        browserAction.goTo(adminDashboardUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Log in as manager using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForManagers() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(managerLogin, managerPassword);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminDashboardPage.dashboardTable), "element is present!");
        browserAction.goTo(adminDashboardUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied!");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Log in as doctor using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if admin button and admin dashboard aren't present
    // 4. Go to admin/dashboard url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAdminDashboardForDoctors() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(doctorLogin, doctorPassword);
        assertFalse(browserAction.isElementPresent(Header.adminButtonByText), "element is present!");
        assertFalse(browserAction.isElementPresent(adminDashboardPage.dashboardTable), "element is present!");
        browserAction.goTo(adminDashboardUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied!");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Check if options button isn't present
    // 3. Go to admin/map/new url
    // 4. Check if access to this page is denied
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForUnregisteredUsers() {
        browserAction.goTo(homeUrl);
        assertFalse(browserAction.isElementPresent(adminDashboardPage.optionsButton), "element is present");
        browserAction.goTo(addingNewHospitalUrl);
        assertEquals(browserAction.getTitle(), "Login", "access not denied");
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
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(patientLogin, patientPassword);
        assertFalse(browserAction.isElementPresent(adminDashboardPage.optionsButton), "element is present");
        browserAction.goTo(addingNewHospitalUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Log in as doctor using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if options button isn't present
    // 4. Go to admin/map/new url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForDoctors() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(doctorLogin, doctorPassword);
        assertFalse(browserAction.isElementPresent(adminDashboardPage.optionsButton), "element is present");
        browserAction.goTo(addingNewHospitalUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Log in as manager using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if options button isn't present
    // 4. Go to admin/map/new url
    // 5. Check if access to this page is denied
    // 6. Log out by clicking "Log out" button
    @Test (dependsOnMethods = {"testDefaultAdminPage"})
    public void testAccessDeniedToAddingNewHospitalForManagers() {
        browserAction.goTo(homeUrl);
        loginPage.loggingIn(managerLogin, managerPassword);
        assertFalse(browserAction.isElementPresent(adminDashboardPage.optionsButton), "element is present");
        browserAction.goTo(addingNewHospitalUrl);
        assertEquals(browserAction.getTitle(), "Denied Access", "access not denied");
        browserAction.sleep();
        loginPage.logout();
    }

    // 1. Go to home page
    // 2. Log in as patient using method loggingIn (click on dropdown button "Log in", enter email, password, click "Log in")
    // 3. Check if patients button isn't present
    // 4. Go to /patients url
    // 5. Check if there isn't table with patients
    // 6. Log out by clicking "Log out" button
    @Test
    public void testAccessDeniedToPatientsListForUnregisteredUsers() {
        browserAction.goTo(homeUrl);
        assertFalse(browserAction.isElementPresent(Header.patientsButtonByXpath), "element is present");
        browserAction.goTo(patientsListUrl);
        assertEquals(browserAction.getTitle(), "Login", "access not denied");
        browserAction.sleep();
    }

    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }
}
