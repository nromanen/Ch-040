package hospitalSeeker.roles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestAdminRole extends BaseRoleTest{

    @BeforeMethod
    public void beforeMethod(){
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test(dataProvider = "adminElements")
    public void testAccessToAdminPage(WebElement element, String string) {
        assertTrue(browser.isElementPresent(element), string + "isn't present!");
    }

    @AfterMethod
    public void afterMethod() {
        headerPage.logout();
    }

}
