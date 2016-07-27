package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import hospitalSeeker.templates.Header;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class TestRegisterPage extends BaseTest {
    public static String language = "UA";
    RegisterPage registerPage;
    Header header;

    public static String REQUIRED_FIELD;
    public static String WARNING_EXISTING_EMAIL;
    public static String INCORRECT_EMAIL_FORMAT;
    public static String INSECURE_PASSWORD;
    public static String WEAK_PASSWORD;
    public static String CONFIRM_PASSWORD_ERROR;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = TestLoginPage.class.getClassLoader().getResourceAsStream("app.properties");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            properties.load(reader);
            if ("ukrainian".equals(properties.getProperty("language"))) {
                inputStream = TestLoginPage.class.getClassLoader().getResourceAsStream("ua.messages.properties");
                reader = new InputStreamReader(inputStream, "UTF-8");
                properties.load(reader);
                REQUIRED_FIELD = properties.getProperty("REQUIRED_FIELD");
                WARNING_EXISTING_EMAIL = properties.getProperty("WARNING_EXISTING_EMAIL");
                INCORRECT_EMAIL_FORMAT = properties.getProperty("INCORRECT_EMAIL_FORMAT");
                INSECURE_PASSWORD = properties.getProperty("INSECURE_PASSWORD");
                WEAK_PASSWORD = properties.getProperty("WEAK_PASSWORD");
                CONFIRM_PASSWORD_ERROR = properties.getProperty("CONFIRM_PASSWORD_ERROR");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        registerPage = RegisterPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(REGISTER_URL);
        if ("UA".equals(TestRegisterPage.language))
            header.changeLocToUa();
    }

    @Test
    public void checkElementsRegisterPage() {
        String error = browser.checkIfElementNotPresent(registerPage.emailRegister)
                .concat(browser.checkIfElementNotPresent(registerPage.passwordRegister))
                .concat(browser.checkIfElementNotPresent(registerPage.confirmPasswordRegister))
                .concat(browser.checkIfElementNotPresent(registerPage.registerButton))
                .concat(browser.checkIfElementNotPresent(registerPage.loginButton));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testRegister() {
        registerPage.registration("patient@mail1234.ru", "Patient77", "Patient77");
        Assert.assertTrue(browser.isElementPresent(registerPage.successfullRegistration));
    }

    @Test
    public void testRegisterButtonLogin() {
        registerPage.loginButton.click();
        Assert.assertEquals(browser.getCurrentUrl(), LOGIN_URL);
    }

    @Test
    public void testRegisterExistingEmail() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warningExistingEmail));
        registerPage.registration(PATIENT_LOGIN, "Patient77", "Patient77");
        Assert.assertEquals(registerPage.warningExistingEmail.getText(),WARNING_EXISTING_EMAIL);
    }

    @Test
    public void testRegisterByLogin() {
        Assert.assertFalse(browser.isElementPresent(registerPage.incorrectEmailFormat));
        registerPage.registration("patient", "Patient77", "Patient77");
        Assert.assertEquals(registerPage.incorrectEmailFormat.getText(),INCORRECT_EMAIL_FORMAT);
    }

    @Test
    public void testRegisterInsecurePassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.insecurePassword));
        registerPage.registration(PATIENT_LOGIN, "77", "77");
        Assert.assertEquals(registerPage.insecurePassword.getText(),INSECURE_PASSWORD);
    }

    @Test
    public void testRegisterWeakPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.weakPassword));
        registerPage.registration("patient@mail1234.ru", "patient77", "patient77");
        Assert.assertEquals(registerPage.weakPassword.getText(),WEAK_PASSWORD);
    }

    @Test
    public void testRegisterWithoutEmail() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
        registerPage.registration("", "Patient77", "Patient77");
        Assert.assertEquals(registerPage.warningByEmail.getText(),REQUIRED_FIELD);
    }

    @Test
    public void testRegisterWithoutConfirmPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "Patient77", "");
        Assert.assertEquals(registerPage.confirmPasswordError.getText(),REQUIRED_FIELD);
    }

    @Test
    public void testRegisterWithoutPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "", "Patient77");
        Assert.assertEquals(registerPage.confirmPasswordError.getText(),CONFIRM_PASSWORD_ERROR);
    }

    @Test
    public void testRegisterIncorrectConfirmation() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "Patient77", "Patient777");
        Assert.assertEquals(registerPage.confirmPasswordError.getText(),CONFIRM_PASSWORD_ERROR);
    }

}
