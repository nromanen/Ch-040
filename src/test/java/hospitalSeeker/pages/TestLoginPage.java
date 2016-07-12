package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import hospitalSeeker.RegisterPage;
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
		System.out.println(error);
	}

	/*
	 * Correct log in
	 * go to login page 
	 * input e-mail 
	 * input password click on
	 * button "Log in"
	 */
	@Test(priority = 1)
	public void testLogin() {
		loginPage.loggingIn(PATIENT_LOGIN,PATIENT_PASSWORD);
		Assert.assertTrue(browser.isElementPresent(header.appointmentsButton));
	}

	/*
	 * Log in without e-mail
	 * go to login page 
	 * field for e-mail keep empty 
	 * input password 
	 * click on button "Log in"
	 */
	@Test(priority = 2)
	public void testLoginWithoutEmail() {
		loginPage.loggingIn("",PATIENT_PASSWORD);
		Assert.assertTrue(browser.isElementPresent(loginPage.loginWarning));
	}

	/*
	 * Log in without password
	 * go to login page
	 * input e-mail 
	 * field for password
	 * keep empty 
	 * click on button "Log in"
	 */
	@Test(priority = 3)
	public void testLoginWithoutPassword() {
		loginPage.loggingIn(PATIENT_LOGIN,"");
		Assert.assertTrue(browser.isElementPresent(loginPage.passwordWarning));
	}

	/*
	 * Log in by unregistered e-mail
	 * go to login page 
	 * input unregistered e-mail
	 * input password 
	 * click on button "Log in"
	 */
	@Test(priority = 4)
	public void testLoginIncorrectEmail() {
		loginPage.loggingIn("patient.cdd@hospitals.ua",PATIENT_PASSWORD);
		Assert.assertTrue(browser.isElementPresent(loginPage.invalidUsernameOrPasswordWarning));
	}

	 /** Log in by incorrect password
	 * go to login page
	 * input registered e-mail
	 * input incorrect password
	 * click on button "Log in"*/

	@Test(priority = 5)
	public void testLoginIncorrectPassword() {
		loginPage.loggingIn(PATIENT_LOGIN,"11111");
		Assert.assertTrue(browser.isElementPresent(loginPage.invalidUsernameOrPasswordWarning));
	}
}
