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
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("Perekuta96");
		registerPage.confirmPasswordRegister.sendKeys("Perekuta96");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.SUCCESSFULL_REGISTRATION));
		Assert.assertTrue(browser.isElementPresentByXpath(registerPage.SUCCESSFULL_REGISTRATION));
		Assert.assertTrue(browser.containsText("successfully"));
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
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.cssSelector(registerPage.WARNING_EMAIL));
		Assert.assertTrue(browser.containsText("User with this email is already exists"));
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
		registerPage.emailRegister.sendKeys("patient");
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresentByXpath(registerPage.PLEASE_REGISTER_TITLE));
	}

	/*Registration by password including less than any 6 symbols or more than 16
	* go to registration page
	* input e-mail
	* input password including less than any 6 symbols or more than 16
	* confirm password
	* click on button "Register"*/
	@Test(priority = 5)
	public void testRegisterInsecurePassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("77");
		registerPage.confirmPasswordRegister.sendKeys("77");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.WARNING_PASSWORD));
		Assert.assertTrue(browser.containsText("Your password must between 6 and 16 characters"));
	}

	/*Registration by password including no different case
	* go to registration page
	* input e-mail
	* input password including no different case
	* confirm password
	* click on button "Register"*/
	@Test(priority = 6)
	public void testRegisterLowerUpperCasePassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("patient77");
		registerPage.confirmPasswordRegister.sendKeys("patient77");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.WARNING_PASSWORD));
		Assert.assertTrue(browser.containsText("Your password must contains at least:one lowercase characters, one uppercase characters"));
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
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.WARNING_EMAIL));
		Assert.assertTrue(browser.containsText("Please enter your email"));
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
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("Patient77");
		registerPage.confirmPasswordRegister.sendKeys("");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.WARNING_CONFIRM_PASSWORD));
		Assert.assertTrue(browser.containsText("Please enter your password again."));
	}

	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * confirm password
	 * click on button "Register"*/
	@Test(priority = 8)
	public void testRegisterWithoutPassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys(PATIENT_LOGIN);
		registerPage.passwordRegister.sendKeys("");
		registerPage.confirmPasswordRegister.sendKeys("Patient77");
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath(registerPage.WARNING_PASSWORD));
		Assert.assertTrue(browser.containsText("Please enter your password."));
	}

}
