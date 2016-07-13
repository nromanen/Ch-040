package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegisterPage extends BaseTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        registerPage = RegisterPage.init(browser.getDriver());
        browser.goTo(REGISTER_URL);
    }

    @Test
    public void checkElementsRegisterPage() {
        String error = browser.checkIfElementNotPresent(registerPage.emailRegister)
                .concat(browser.checkIfElementNotPresent(registerPage.passwordRegister))
                .concat(browser.checkIfElementNotPresent(registerPage.confirmPasswordRegister))
                .concat(browser.checkIfElementNotPresent(registerPage.registerButton))
                .concat(browser.checkIfElementNotPresent(registerPage.loginButton));
        System.out.println(error);
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
        Assert.assertTrue(browser.isElementPresent(registerPage.warningExistingEmail));
    }

    @Test
    public void testRegisterByLogin() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
        registerPage.registration("patient", "Patient77", "Patient77");
        Assert.assertTrue(browser.isElementPresent(registerPage.warningByEmail));
    }

    @Test
    public void testRegisterInsecurePassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.insecurePassword));
        registerPage.registration(PATIENT_LOGIN, "77", "77");
        Assert.assertTrue(browser.isElementPresent(registerPage.insecurePassword));
    }

    @Test
    public void testRegisterWeakPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.weakPassword));
        registerPage.registration("patient@mail1234.ru", "patient77", "patient77");
        Assert.assertTrue(browser.isElementPresent(registerPage.weakPassword));
    }

    @Test
    public void testRegisterWithoutEmail() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
        registerPage.registration("", "Patient77", "Patient77");
        Assert.assertTrue(browser.isElementPresent(registerPage.warningByEmail));
    }

    @Test
    public void testRegisterWithoutConfirmPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "Patient77", "");
        Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
    }

    @Test
    public void testRegisterWithoutPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "", "Patient77");
        Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
    }

    @Test
    public void testRegisterIncorrectConfirmation() {
        Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
        registerPage.registration(PATIENT_LOGIN, "Patient77", "Patient777");
        Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
    }

}
