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
	        Assert.assertTrue(browser.isElementPresent(registerPage.emailRegister));
	        Assert.assertTrue(browser.isElementPresent(registerPage.passwordRegister));
	        Assert.assertTrue(browser.isElementPresent(registerPage.enabledButton));
	        Assert.assertTrue(browser.isElementPresent(registerPage.roleAdmin));
	        Assert.assertTrue(browser.isElementPresent(registerPage.roleDoctor));
	        Assert.assertTrue(browser.isElementPresent(registerPage.roleManager));
	        Assert.assertTrue(browser.isElementPresent(registerPage.rolePatient));
	        Assert.assertTrue(browser.isElementPresent(registerPage.registerButton));
	        Assert.assertTrue(browser.isElementPresent(registerPage.cancelButton));
	    }

	 /*Correct registration
	 * go to registration page
	 * input e-mail
	 * input password
	 * choose any role
	 * click on button"Register"*/
	@Test(priority = 1)
	public void testRegister(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("PATIENT_LOGIN");
		registerPage.passwordRegister.sendKeys("PATIENT_PASSWORD");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath("/html/body/section/div/div/div/h3"));
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div/h3"));
	}

	 /*Correct work of button "Cancel"
	 * go to registration page
	 * input e-mail
	 * input password
	 * choose any role
	 * click on button "Cancel"*/
	@Test(priority = 2)
	public void testRegisterButtonCancel(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("PATIENT_LOGIN");
		registerPage.passwordRegister.sendKeys("PATIENT_PASSWORD");
		registerPage.rolePatient.click();
		registerPage.cancelButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),HOME_URL);
	}

	/*Registration by already existing e-mail
	* go to registration page
	* input already existing e-mail
	* input password
	* choose any role
	* click on button"Register" */
	@Test(priority = 3)
	public void testRegisterExistingEmail(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("PATIENT_LOGIN");
		registerPage.passwordRegister.sendKeys("PATIENT_PASSWORD");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		browser.waitUntilElementIsPresent(By.xpath("/html/body/section/div/div/div/h3"));
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div/h3"));
	}

	/*Registration by username (not by e-mail format)
	* go to registration page
	* input e-mail
	* input password
	* choose any role
	* click on button "Register"*/
	@Test(priority = 4)
	public void testRegisterByLogin(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("tutu");
		registerPage.passwordRegister.sendKeys("PATIENT_PASSWORD");
		registerPage.rolePatient.click();
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div"));
	}

	/*Registration by password including less than any 4 symbols
	* go to registration page
	* input e-mail
	* input password including less than any 4 symbols
	* choose any role
	* click on button "Register"*/
	@Test(priority = 5)
	public void testRegisterInsecurePassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("PATIENT_LOGIN");
		registerPage.passwordRegister.sendKeys("tut");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div"));
	}

	/*Registration without e-mail
	 * go to registration page
	 * field for e-mail keep empty
	 * input password
	 * choose any role
	 * click on button "Register"*/
	@Test(priority = 6)
	public void testRegisterWithoutEmail(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("PATIENT_PASSWORD");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div"));
	}

	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * choose any role
	 * click on button "Register"*/
	@Test(priority = 7)
	public void testRegisterWithoutPassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("PATIENT_LOGIN");
		registerPage.passwordRegister.sendKeys("");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browser.isElementPresentByXpath("/html/body/section/div/div/div"));
	}

	@AfterMethod
	public void afterMethod(){
		browser.getDriver().quit();
	}
}
