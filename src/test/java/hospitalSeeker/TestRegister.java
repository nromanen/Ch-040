package hospitalSeeker;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;

public class TestRegister extends BaseTest {

	RegisterPage registerPage;

	@BeforeMethod
	public void beforeMethod(){
		registerPage = PageFactory.initElements(browser.getDriver(), RegisterPage.class);
	}

	  @Test(priority=0)
	    public void checkElementsRegisterPage() {
	        browser.goTo(REGISTER_URL);
	        Assert.assertTrue(browser.isElementPresent(registerPage.emailRegister),"1");
	        Assert.assertTrue(browser.isElementPresent(registerPage.passwordRegister),"2");
		  	Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordRegister),"3");
	        Assert.assertTrue(browser.isElementPresent(registerPage.registerButton),"4");
	        Assert.assertTrue(browser.isElementPresent(registerPage.loginButton),"5");
	    }

	 /*Correct registration
	 * go to registration page
	 * input e-mail
	 * input password
	 * confirm password
	 * click on button "Register"*/
	@Test(priority = 1)
	public void testRegister(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("nadiia111638974124@mail.ru");
		registerPage.passwordRegister.sendKeys("Perekuta96");
		registerPage.confirmPasswordRegister.sendKeys("Perekuta96");
		registerPage.registerButton.click();
		browser.sleep(3);
//		browser.waitUntilElementVisible(registerPage.successfullRegistration);
		Assert.assertTrue(browser.isElementPresent(registerPage.successfullRegistration));
	}

	 /*Correct work of button "Log in"
	 * go to registration page
	 * click on button "Log in"*/
	@Test(priority = 2)
	public void testRegisterButtonLogin(){
		browser.goTo(REGISTER_URL);
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
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
		Assert.assertFalse(browser.isElementPresent(registerPage.warningExistingEmail));
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.warningExistingEmail));
	}

	/*Registration by username (not by e-mail format)
	* go to registration page
	* input e-mail
	* input password
	* confirm password
	* click on button "Register"*/
	@Test(priority = 4)
	public void testRegisterByLogin(){
		browser.goTo(REGISTER_URL);
		Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
		registerPage.emailRegister.sendKeys("patient");
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
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
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		Assert.assertFalse(browser.isElementPresent(registerPage.insecurePassword));
		registerPage.passwordRegister.sendKeys("77");
		registerPage.confirmPasswordRegister.sendKeys("77");
		Assert.assertTrue(browser.isElementPresent(registerPage.insecurePassword));
		registerPage.registerButton.click();
	}

	/*Registration by password including no different case
	* go to registration page
	* input e-mail
	* input password including no different case
	* confirm password
	* click on button "Register"*/
	@Test(priority = 6)
	public void testRegisterWeakPassword(){
		browser.goTo(REGISTER_URL);
		Assert.assertFalse(browser.isElementPresent(registerPage.weakPassword));
		registerPage.emailRegister.sendKeys("patient5666@mail.ru");
		registerPage.passwordRegister.sendKeys("patient77");
		registerPage.confirmPasswordRegister.sendKeys("patient77");
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
		browser.goTo(REGISTER_URL);
		Assert.assertFalse(browser.isElementPresent(registerPage.warningByEmail));
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
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
		browser.goTo(REGISTER_URL);
		Assert.assertFalse(browser.isElementPresent(registerPage.confirmPasswordError));
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("");
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
		browser.goTo(REGISTER_URL);
		Assert.assertFalse(browser.isElementPresent(registerPage.withoutPasswordError));
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresent(registerPage.withoutPasswordError));
	}

}
