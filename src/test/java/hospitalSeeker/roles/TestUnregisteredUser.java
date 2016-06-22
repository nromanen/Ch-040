package hospitalSeeker.roles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestUnregisteredUser extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(HOME_URL);
    }

    @Test(dataProvider = "forbiddenElements")
    public void testForbiddenButtonsForDoctors(WebElement element, String string) {
        assertFalse(browser.isElementPresent(element), string + " is present!");
    }

    @Test(dataProvider = "urlsForUnreg")
    public void testAccessDeniedToUrlsForDoctors(String url, String errorText) {
        browser.goTo(url);
        assertTrue(browser.containsText(errorText), "access not denied");
    }

}
