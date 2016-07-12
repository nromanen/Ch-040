package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegisterPage extends BaseTest {

	RegisterPage registerPage;

	@BeforeMethod
	public void beforeMethod(){
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

//	 /*Correct registration
//	 * go to registration page
//	 * input e-mail
//	 * input password
//	 * confirm password
//	 * click on button "Register"*/
	@Test(priority = 1)
	public void testRegister(){
		registerPage.registration("patient@mail1234.ru","Patient77","Patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.successfullRegistration));
	}

	 /*Correct work of button "Log in"
	 * go to registration page
	 * click on button "Log in"*/
	@Test(priority = 2)
	public void testRegisterButtonLogin(){
		registerPage.loginButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),LOGIN_URL);
	}

	/*Registration by already existing e-mail
	* go to registration page
	* input already existing e-mail
	* input password
	* confirm password
	* click on button "Register" */
	@Test(priority = 3)
	public void testRegisterExistingEmail(){
		registerPage.registration(PATIENT_LOGIN, "Patient77", "Patient77");
		Assert.assertFalse(browser.isElementPresent(registerPage.warningExistingEmail));
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.warningExistingEmail));
	}

	/*Registration by username (not by e-mail format)
	* go to registration page
	* input username
	* input password
	* confirm password
	* click on button "Register"*/
	@Test(priority = 4)
	public void testRegisterByLogin(){
		Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
		registerPage.registration("patient", "Patient77", "Patient77");
		Assert.assertTrue(browser.isElementPresent(registerPage.warningByEmail));
		registerPage.registerButton.click();
	}

	/*Registration by password including less than any 6 symbols
	* go to registration page
	* input e-mail
	* input password including less than any 6 symbols
	* confirm password
	* click on button "Register"*/
	@Test(priority = 5)
	public void testRegisterInsecurePassword(){
		Assert.assertFalse(browser.isElementPresent(registerPage.insecurePassword));
		registerPage.registration(PATIENT_LOGIN,"77","77");
		Assert.assertTrue(browser.isElementPresent(registerPage.insecurePassword));
		registerPage.registerButton.click();
	}

	/*Registration by password including no different case,symbols,numbers
	* go to registration page
	* input e-mail
	* input password including no different case,symbols,numbers
	* confirm password
	* click on button "Register"*/
	@Test(priority = 6)
	public void testRegisterWeakPassword(){
		Assert.assertFalse(browser.isElementPresent(registerPage.weakPassword));
		registerPage.registration("patient@mail1234.ru","patient77","patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.weakPassword));
	}

	/*Registration without e-mail
	 * go to registration page
	 * field for e-mail keep empty
	 * input password
	 * confirm password
	 * click on button "Register"*/
	@Test(priority = 7)
	public void testRegisterWithoutEmail(){
		Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
		registerPage.registration("","Patient77","Patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.warningByEmail));
	}

	/*Registration without confirming password
	 * go to registration page
	 * input e-mail
	 * input password
	 * field for password confirmation keep empty
	 * click on button "Register"*/
	@Test(priority = 8)
	public void testRegisterWithoutConfirmPassword(){
		Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
		registerPage.registration(PATIENT_LOGIN,"Patient77","");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
	}

	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * confirm password
	 * click on button "Register"*/
	@Test(priority = 9)
	public void testRegisterWithoutPassword(){
		Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
		registerPage.registration(PATIENT_LOGIN,"","Patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
	}

	/*Registration with incorrect confirmation
	 * go to registration page
	 * input e-mail
	 * input password
	 * confirm password incorrectly
	 * click on button "Register"*/
	@Test(priority = 10)
	public void testRegisterIncorrectConfirmation(){
		Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
		registerPage.registration(PATIENT_LOGIN,"Patient77","Patient777");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordError));
	}

}
