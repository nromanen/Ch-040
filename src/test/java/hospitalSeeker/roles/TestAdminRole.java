package hospitalSeeker.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAdminRole extends BaseRoleTest{

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void testPrimaryAdminElements() {
        String error = browser.checkIfElementNotPresent(headerPage.actionsButton)
                .concat(browser.checkIfElementNotPresent(adminPage.allUsersTable));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testAccessToAdminDashboardPage() {
        headerPage.actionsButton.click();
        headerPage.allUsersButton.click();
        assertEquals(browser.getCurrentUrl(), ADMIN_DASHBOARD_URL, "URLs don't match!");
    }

    @Test
    public void testAccessToAddNewUserPage() {
        headerPage.actionsButton.click();
        headerPage.addNewUserButton.click();
        assertEquals(browser.getCurrentUrl(), ADDING_NEW_USER_URL, "URLs don't match!");
    }

    @Test
    public void testAccessToHospitalListPage() {
        headerPage.actionsButton.click();
        headerPage.hospitalListButton.click();
        assertEquals(browser.getCurrentUrl(), HOSPITAL_LIST_URL, "URLs don't match!");
    }

    @Test
    public void testAccessToAddNewHospital() {
        headerPage.actionsButton.click();
        headerPage.newHospitalButton.click();
        assertEquals(browser.getCurrentUrl(), ADDING_NEW_HOSPITAL_URL, "URLs don't match!");
    }

    @Test
    public void testAccessToCheckHospitalsPage() {
        headerPage.actionsButton.click();
        headerPage.checkHospitalsButton.click();
        assertEquals(browser.getCurrentUrl(), CHECK_HOSPITALS_LIST_URL, "URLs don't match!");
    }

    @Test
    public void testAccessToEditHospitalManagers() {
        headerPage.actionsButton.click();
        headerPage.editHospitalManagersButton.click();
        assertEquals(browser.getCurrentUrl(), EDIT_HOSPITALS_MANAGERS_URL, "URLs don't match!");
    }
}
