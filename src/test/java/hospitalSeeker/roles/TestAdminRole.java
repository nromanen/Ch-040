package hospitalSeeker.roles;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestAdminRole extends BaseRoleTest {


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void testPrimaryAdminElements() {
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(adminPage.allUsersTable));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test(dataProvider = "primaryAdminUrls")
    public void testAccessToAdminPagesByUrl(String errorMessage, String url) {
        browser.goTo(url);
        assertEquals(browser.getCurrentUrl(), url, "urls don't match! problem with this url: ".concat(errorMessage));
    }

    @Test
    public void testAllUsersButton() {
        header.actionsButton.click();
        header.allUsersButton.click();
        assertEquals(browser.getCurrentUrl(), ADMIN_DASHBOARD_URL, "url's don't match!");
    }

    @Test
    public void testAddNewUserButton() {
        header.actionsButton.click();
        header.addNewUserButton.click();
        assertEquals(browser.getCurrentUrl(), ADDING_NEW_USER_URL, "url's don't match!");
    }

    @Test
    public void testHospitalListButton() {
        header.actionsButton.click();
        header.hospitalListButton.click();
        assertEquals(browser.getCurrentUrl(), HOSPITAL_LIST_URL, "url's don't match!");
    }

    @Test
    public void testAddNewHospitalButton() {
        header.actionsButton.click();
        header.newHospitalButton.click();
        assertEquals(browser.getCurrentUrl(), ADMIN_DASHBOARD_URL, "url's don't match!");
    }

    @Test
    public void testCheckHospitalsButton() {
        header.actionsButton.click();
        header.checkHospitalsButton.click();
        assertEquals(browser.getCurrentUrl(), CHECK_HOSPITALS_LIST_URL, "url's don't match!");
    }

    @Test
    public void testEditHospitalManagersButton() {
        header.actionsButton.click();
        header.editHospitalManagersButton.click();
        assertEquals(browser.getCurrentUrl(), EDIT_HOSPITALS_MANAGERS_URL, "url's don't match!");
    }

    @Test
    public void testConfigureTokensButton() {
        header.actionsButton.click();
        header.configTokensButton.click();
        assertEquals(browser.getCurrentUrl(), CONFIGURE_TOKENS_URL, "url's don't match!");
    }
}
