package hospitalSeeker.roles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAdminRole extends BaseRoleTest{

    @BeforeMethod
    public void beforeMethod(){
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test(dataProvider = "adminDashboardElements")
    public void testPrimaryAdminElements(WebElement element, String errorMessage) {
        assertTrue(browser.isElementPresent(element), errorMessage + " isn't present!");
    }

    @Test(dataProvider = "adminActionButtons", priority = 1)
    public void testAccessToAdminPages(WebElement element, String errorMessage, String url) {
        headerPage.actionsButton.click();
        element.click();
        assertEquals(browser.getCurrentUrl(), url, "urls don't match! problem with this url: " + errorMessage);
    }
    @AfterMethod
    public void afterMethod1() {
        headerPage.logout();
    }

}
