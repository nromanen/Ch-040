package hospitalSeeker;

import hospitalSeeker.header.DropdownRegister;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;

public class TestRegister extends BaseTest {
 
	RegisterPage registerPage;
	DropdownRegister dropdownRegister;
	
	@BeforeMethod
	public void beforeMethod(){
		super.beforeMethod();
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
	@Test(priority=0, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegister(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("user");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browser.containsText("registered successfully"));
	}
	
	 /*Correct work of button "Cancel"
	 * go to registration page
	 * input e-mail
	 * input password
	 * choose any role
	 * click on button "Cancel"*/
	@Test(priority=1, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterButtonCancel(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("user");
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
	@Test(priority=2, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterExistingEmail(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("atqc@mail.ru");
		registerPage.passwordRegister.sendKeys("atqc");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browser.containsText("is already exist"));
	}

	/*Registration by username (not by e-mail format)
	* go to registration page
	* input e-mail
	* input password
	* choose any role
	* click on button "Register"*/
	@Test(priority=3, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterByLogin(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("atqc");
		registerPage.passwordRegister.sendKeys("atqc");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),REGISTER_URL);
	}

	/*Registration by password including less than any 4 symbols
	* go to registration page
	* input e-mail
	* input password including less than any 4 symbols
	* choose any role
	* click on button "Register"*/
	@Test(priority=4, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterInsecurePassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("usr");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),REGISTER_URL);
	}

	/*Registration without e-mail
	 * go to registration page
	 * field for e-mail keep empty
	 * input password
	 * choose any role
	 * click on button "Register"*/
	@Test(priority=5, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutEmail(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("user");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),REGISTER_URL);
	} 
	
	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * choose any role
	 * click on button "Register"*/
	@Test(priority=6, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutPassword(){
		browser.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browser.getCurrentUrl(),REGISTER_URL);
	} 

	@AfterMethod
	public void afterMethod(){
		browser.getDriver().quit();
	}
}
