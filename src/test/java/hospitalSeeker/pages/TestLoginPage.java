package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import hospitalSeeker.templates.Header;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
    }

    @Test
    public void checkElementsLoginPage() {
        String error = browser.checkIfElementNotPresent(loginPage.emailLogin)
                .concat(browser.checkIfElementNotPresent(loginPage.passwordLogin))
                .concat(browser.checkIfElementNotPresent(loginPage.rememberMe))
                .concat(browser.checkIfElementNotPresent(loginPage.forgotPassword))
                .concat(browser.checkIfElementNotPresent(loginPage.loginButton))
                .concat(browser.checkIfElementNotPresent(loginPage.registerButton));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testLogin() {
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        Assert.assertTrue(browser.isElementPresent(header.appointmentsButton));
    }

    @Test
    public void testLoginWithoutEmail() {
        loginPage.loggingIn("", PATIENT_PASSWORD);
        Assert.assertTrue(browser.isElementPresent(loginPage.loginWarning));
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.loggingIn(PATIENT_LOGIN, "");
        Assert.assertTrue(browser.isElementPresent(loginPage.passwordWarning));
    }

    @Test
    public void testLoginIncorrectEmail() {
        loginPage.loggingIn("patient.cdd@hospitals.ua", PATIENT_PASSWORD);
        Assert.assertTrue(browser.isElementPresent(loginPage.invalidUsernameOrPasswordWarning));
    }

    @Test
    public void testLoginIncorrectPassword() {
        loginPage.loggingIn(PATIENT_LOGIN, "11111");
        Assert.assertTrue(browser.isElementPresent(loginPage.invalidUsernameOrPasswordWarning));
    }
}
