package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.HeaderPage;
import hospitalSeeker.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


public class BaseRoleTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    HeaderPage headerPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        headerPage = HeaderPage.init(browser.getDriver());
    }

    @DataProvider(name = "adminDashboardElements")
    public Object[][] adminDashboardElements() {
        return new Object[][] { { headerPage.actionsButton, "actionsButton" },
                { adminPage.allUsersTable, "allUsersTable" } };
    }

    @DataProvider(name = "adminActionButtons")
    public Object[][] adminActionButtons() {
        return new Object[][] { { headerPage.allUsersButton, "allUsersButton", ADMIN_DASHBOARD_URL },
                { headerPage.addNewUserButton, "addNewUserButton", ADDING_NEW_USER_URL },
                { headerPage.hospitalListButton, "hospitalListButton", HOSPITAL_LIST_URL },
                { headerPage.newHospitalButton, "newHospitalButton", ADDING_NEW_HOSPITAL_URL },
                { headerPage.checkHospitalsButton, "checkHospitalsButton", CHECK_HOSPITALS_LIST_URL },
                { headerPage.editHospitalManagersButton, "editHospitalManagerButton", EDIT_HOSPITALS_MANAGERS_URL }};
    }

    @DataProvider(name = "forbiddenElements")
    public Object[][] forbiddenElements() {
        return new Object[][] { { headerPage.actionsButton, "actionsButton" },
                { adminPage.allUsersTable, "allUsersTable" }, { headerPage.patientsButton, "patientsButton" } };
    }

    @DataProvider(name = "forbiddenUrls")
    public Object[][] forbiddenUrls() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "not authorized to access" },
                { ADDING_NEW_HOSPITAL_URL, "not authorized to access" }, { PATIENTS_LIST_URL, "Patient" } };
    }

    @DataProvider(name = "urlsForUnreg")
    public Object[][] urlsForUnreg() {
        return new Object[][] { { ADMIN_DASHBOARD_URL, "Please Log In" },
                { ADDING_NEW_HOSPITAL_URL, "Please Log In" }, { PATIENTS_LIST_URL, "Please Log In" } };
    }

}
