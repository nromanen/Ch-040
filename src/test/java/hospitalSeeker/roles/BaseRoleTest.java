package hospitalSeeker.roles;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.HeaderPage;
import hospitalSeeker.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;


public class BaseRoleTest extends BaseTest {

    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();

    }

    @DataProvider(name = "primaryAdminElements")
    public Object[][] primaryAdminElements() {
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);
        headerPage = PageFactory.initElements(browser.getDriver(), HeaderPage.class);
        return new Object[][]{{headerPage.actionsButton, "actionsButton"},
                {adminPage.allUsersTable, "allUsersTable"}};
    }

    @DataProvider(name = "test1")
    public static Iterator<Object[]> createData() {
        ArrayList<Object[]> list = new ArrayList<Object[]>()
        {
            {
                add(new Object[]{headerPage.actionsButton, "actionsButton"});
                add(new Object[]{adminPage.allUsersTable, "allUsersTable"});
            }
        };
        return list.iterator();
    }
}