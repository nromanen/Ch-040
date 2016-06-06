import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TestRegister extends BaseTest {
 
	RegisterPage registerPage;
	DropdownRegister dropdownRegister;
	
	@BeforeMethod
	public void beforeMethod(){
		super.beforeMethod();
		registerPage = PageFactory.initElements(browserAction.getDriver(), RegisterPage.class);
	}

	  @Test(priority=0)
	    public void checkElementsRegisterPage() {
	        browserAction.goTo(REGISTER_URL);
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.emailRegister));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.passwordRegister));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.enabledButton));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.roleAdmin));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.roleDoctor));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.roleManager));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.rolePatient));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.registerButton));
	        Assert.assertTrue(browserAction.isElementPresent(registerPage.cancelButton));
	    }

	 /*Correct registration
	 * go to registration page
	 * input e-mail
	 * input password
	 * choose any role
	 * click on button"Register"*/
	@Test(priority=0, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegister(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("user");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("registered successfully"));
	}
	
	 /*Correct work of button "Cancel"
	 * go to registration page
	 * input e-mail
	 * input password
	 * choose any role
	 * click on button "Cancel"*/
	@Test(priority=1, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterButtonCancel(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("user");
		registerPage.rolePatient.click();
		registerPage.cancelButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),HOME_URL);
	}
	
	/*Registration by already existing e-mail
	* go to registration page
	* input already existing e-mail 
	* input password
	* choose any role
	* click on button"Register" */
	@Test(priority=2, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterExistingEmail(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("atqc@mail.ru");
		registerPage.passwordRegister.sendKeys("atqc");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("is already exist"));
	}

	/*Registration by username (not by e-mail format)
	* go to registration page
	* input e-mail
	* input password
	* choose any role
	* click on button "Register"*/
	@Test(priority=3, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterByLogin(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("atqc");
		registerPage.passwordRegister.sendKeys("atqc");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),REGISTER_URL);
	}

	/*Registration by password including less than any 4 symbols
	* go to registration page
	* input e-mail
	* input password including less than any 4 symbols
	* choose any role
	* click on button "Register"*/
	@Test(priority=4, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterInsecurePassword(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("usr");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),REGISTER_URL);
	}

	/*Registration without e-mail
	 * go to registration page
	 * field for e-mail keep empty
	 * input password
	 * choose any role
	 * click on button "Register"*/
	@Test(priority=5, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutEmail(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("user");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),REGISTER_URL);
	} 
	
	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * choose any role
	 * click on button "Register"*/
	@Test(priority=6, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutPassword(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("user@gmail.com");
		registerPage.passwordRegister.sendKeys("");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),REGISTER_URL);
	} 

	@AfterMethod
	public void afterMethod(){
		browserAction.getDriver().quit();
	}
}
