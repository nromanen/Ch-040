package hospitalSeeker.roles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestManagerRole extends BaseRoleTest {


    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
    }

    @Test(dataProvider = "adminElements")
    public void testForbiddenButtonsForManagers(WebElement element, String string) {
        assertFalse(browser.isElementPresent(element), string + " is present!");
    }

    @Test(dataProvider = "urls")
    public void testAccessDeniedToUrlsForManagers(String url, String errorText) {
        browser.goTo(url);
        assertTrue(browser.containsText(errorText), "access not denied");
    }

    @AfterTest
    public void afterTest() {
        headerPage.logout();
    }

}
