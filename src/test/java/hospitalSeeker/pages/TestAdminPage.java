package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import hospitalSeeker.DataSetUtils;
import hospitalSeeker.templates.Header;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestAdminPage extends BaseTest {

    AdminPage adminPage;
    LoginPage loginPage;
    Header header;
    public static final String PATIENT_EMAIL = "patient.in@hospitals.ua";

    @DataProvider(name = "rolesCount")
    public Object[][] rolesCount() {
        return new Object[][]{
                {"ADMIN", 1},
                {"MANAGER", 1},
                {"DOCTOR", 1},
                {"PATIENT", 2}
        };
    }

    @DataProvider(name = "searchBy")
    public Object[][] searchBy() {
        return new Object[][]{
                {"Email", "manager.kh@hospitals.ua", 2},
                {"First Name", "Charles", 3},
                {"Last Name", "Darvin", 4}
        };
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void checkElementsAdminPage() {
        String error = browser.checkIfElementNotPresent(adminPage.allUsersTable)
                .concat(browser.checkIfElementNotPresent(adminPage.showUsers))
                .concat(browser.checkIfElementNotPresent(adminPage.role))
                .concat(browser.checkIfElementNotPresent(adminPage.searchBy))
                .concat(browser.checkIfElementNotPresent(adminPage.search))
                .concat(browser.checkIfElementNotPresent(adminPage.searchButton))
                .concat(browser.checkIfElementNotPresent(adminPage.enabled))
                .concat(browser.checkIfElementNotPresent(adminPage.disabled))
                .concat(browser.checkIfElementNotPresent(adminPage.allUsers))
                .concat(browser.checkIfElementNotPresent(adminPage.actionsViewUser))
                .concat(browser.checkIfElementNotPresent(adminPage.actionsEditUser))
                .concat(browser.checkIfElementNotPresent(adminPage.actionsDeleteUser))
                .concat(browser.checkIfElementNotPresent(adminPage.sortEmailColumn))
                .concat(browser.checkIfElementNotPresent(adminPage.sortFirstNameColumn))
                .concat(browser.checkIfElementNotPresent(adminPage.sortRoleColumn));
        System.out.println(error);
    }

    @Test
    public void testCountAllUsers() {
        adminPage.searchButton.click();
        Assert.assertEquals(adminPage.allRows.size(), 5);
    }

    @Test(dataProvider = "rolesCount")
    public void testCountUsers(String role, int expectedCount) {
        browser.selectDropdown(adminPage.role, role);
        adminPage.searchButton.click();
        Assert.assertTrue(browser.getDataFromTable(1, 5).contains(role));
        Assert.assertEquals(adminPage.allRows.size(), expectedCount);
    }

    @Test(dataProvider = "searchBy")
    public void testSearchBy(String filter, String expectedValue, int columnNumber) {
        browser.selectDropdown(adminPage.searchBy, filter);
        adminPage.search.sendKeys(expectedValue);
        adminPage.searchButton.click();
        Assert.assertEquals(browser.getDataFromTable(1, columnNumber), expectedValue);
    }

    @Test
    public void testDisabledUsers() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        adminPage.disabled.click();
        Assert.assertEquals(adminPage.allRows.size(), 1);
    }

    @Test
    public void testViewUser() {
        browser.selectDropdown(adminPage.searchBy, "Email");
        adminPage.search.sendKeys("manager.kh@hospitals.ua");
        adminPage.searchButton.click();
        adminPage.actionsViewUser.click();
        browser.waitUntilElementVisible(adminPage.viewUserTitle);
        Assert.assertTrue(browser.isElementPresent(adminPage.viewUserTitle));
    }

    @Test
    public void testEditUser() {
        browser.selectDropdown(adminPage.searchBy, "Email");
        adminPage.search.sendKeys("manager.kh@hospitals.ua");
        adminPage.searchButton.click();
        adminPage.actionsEditUser.click();
        browser.waitUntilElementVisible(adminPage.editEditUserButton);
        Assert.assertTrue(browser.isElementPresent(adminPage.editEditUserButton));
    }

    @Test
    public void testDeleteUser() {
        browser.selectDropdown(adminPage.searchBy, "Email");
        adminPage.search.sendKeys("manager.kh@hospitals.ua");
        adminPage.searchButton.click();
        adminPage.actionsDeleteUser.click();
        browser.waitUntilElementVisible(adminPage.deleteUserAlertDeleteButton);
        Assert.assertTrue(browser.isElementPresent(adminPage.deleteUserAlertDeleteButton));
    }

    @Test
    public void testDisableUser() {
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(PATIENT_EMAIL, PATIENT_PASSWORD);
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        adminPage.disableUser(PATIENT_EMAIL, getWrapper());
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(PATIENT_EMAIL, PATIENT_PASSWORD);
        Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
    }

    @Test
    public void testBlockedAccount() {
        header.logout();
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn("patient.rr@hospitals.ua", PATIENT_PASSWORD);
        Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
    }

    @Test
    public void testPagination() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.refreshPage();
        adminPage.lastPageButton.click();
        Assert.assertEquals(adminPage.allRows.size(), 10);
    }

    @Test
    public void testSortingEmail() {
        adminPage.sortEmailColumn.click();
        Assert.assertEquals(browser.getDataFromTable(1, 2), "patient.in@hospitals.ua");
    }

    @Test
    public void testSortingFirstName() {
        adminPage.sortFirstNameColumn.click();
        Assert.assertEquals(browser.getDataFromTable(1, 3), "Charles");
    }

    @Test
    public void testSortingLastName() {
        adminPage.sortLastNameColumn.click();
        Assert.assertEquals(browser.getDataFromTable(1, 4), "Darvin");
    }

    @Test
    public void testSortingRole() {
        adminPage.sortRoleColumn.click();
        Assert.assertEquals(browser.getDataFromTable(1, 5), "PATIENT");

    }
}


