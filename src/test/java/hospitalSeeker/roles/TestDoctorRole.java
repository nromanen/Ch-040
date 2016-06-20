package hospitalSeeker.roles;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDoctorRole extends BaseRoleTest {

    @BeforeMethod
    public void beforeMethod() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
    }

    @Test(dataProvider = "adminElements")
    public void testForbiddenButtonsForDoctors(WebElement element, String string) {
        assertFalse(browser.isElementPresent(element), string + " is present!");
    }

    @Test(dataProvider = "urls")
    public void testAccessDeniedToUrlsForDoctors(String url, String errorText) {
        browser.goTo(url);
        assertTrue(browser.containsText(errorText), "access not denied");
    }

    @AfterMethod
    public void afterMethod() {
        headerPage.logout();
    }

}
