package hospitalSeeker.pages;

import hospitalSeeker.tools.BaseTest;
import hospitalSeeker.templates.Header;
import hospitalSeeker.tools.LocalizationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;

public class TestLoginPage extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;
    Header header;

    public static String REQUIRED_FIELD;
    public static String USERNAME_OR_PASSWORD_WARNING;
    public static String NOT_ACTIVATED_ACCOUNT;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = LocalizationConfig.getPropertiesForLocalization();
        REQUIRED_FIELD = properties.getProperty("REQUIRED_FIELD");
        USERNAME_OR_PASSWORD_WARNING = properties.getProperty("USERNAME_OR_PASSWORD_WARNING");
        NOT_ACTIVATED_ACCOUNT = properties.getProperty("NOT_ACTIVATED_ACCOUNT");
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        if ("UA".equals(language))
            header.changeLocToUa();
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
        browser.sleep(3);
        Assert.assertTrue(browser.isElementPresent(header.appointmentsButton));
    }

    @Test
    public void testLoginWithoutEmail() {
        loginPage.loggingIn("", PATIENT_PASSWORD);
        Assert.assertEquals(loginPage.loginWarning.getText(), REQUIRED_FIELD);
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.loggingIn(PATIENT_LOGIN, "");
        Assert.assertEquals(loginPage.passwordWarning.getText(), REQUIRED_FIELD);
    }

    @Test
    public void testLoginIncorrectEmail() {
        loginPage.loggingIn("patient.cdd@hospitals.ua", PATIENT_PASSWORD);
        Assert.assertEquals(loginPage.warning.getText(), USERNAME_OR_PASSWORD_WARNING);
    }

    @Test
    public void testLoginIncorrectPassword() {
        loginPage.loggingIn(PATIENT_LOGIN, "11111");
        Assert.assertEquals(loginPage.warning.getText(), USERNAME_OR_PASSWORD_WARNING);
    }

    @Test
    public void testLoginByNotConfirmedEmail() {
        loginPage.registerButton.click();
        registerPage.registration("patient.ns@hospitals.ua", "Patient77", "Patient77");
        header.loginButton.click();
        loginPage.loggingIn("patient.ns@hospitals.ua", "Patient77");
        Assert.assertEquals(loginPage.warning.getText(), NOT_ACTIVATED_ACCOUNT);
    }
}
