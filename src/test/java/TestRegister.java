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
		dropdownRegister = PageFactory.initElements(browserAction.getDriver(), DropdownRegister.class);
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
	@Test(priority=10, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegister(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("nadjacv12345@rmail.ru");
		registerPage.passwordRegister.sendKeys("12345");
		registerPage.enabledButton.click();
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
		registerPage.emailRegister.sendKeys("nadjacv456@rmail.ru");
		registerPage.passwordRegister.sendKeys("nadja456");
		registerPage.rolePatient.click();
		registerPage.cancelButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),"http://localhost:8080/hospital/");
	}
	
	/*Registration by already existing e-mail
	*go to registration page
	*input already existing e-mail 
	*input password
	* choose any role
	* click on button"Register" */
	@Test(priority=2, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterExistingEmail(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("nadjacv76@rmail.ru");
		registerPage.passwordRegister.sendKeys("nadja76");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("is already exist"));
	}

	/*Registration by username (not by e-mail format)
	*go to registration page
	*input е-mail
	*input е-mail
	*choose any role
	*click on button "Register"*/
	@Test(priority=0, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterByLogin(){
		browserAction.goTo(REGISTER_URL);
		System.out.println(registerPage.emailRegister.getAttribute("required"));
		registerPage.emailRegister.sendKeys("nadjacv");
		registerPage.passwordRegister.sendKeys("nadja76");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		//Assert.assertEquals(registerPage.getText5(),("Input e-mail in correct format!"));
		//System.out.println(registerPage.getText5());
		//System.out.println(browserActions.getDriver().findElement(By.tagName("body")).getText());
		//Assert.assertTrue(registerPage.containsText("Пожалуйста"));
//		Assert.assertTrue(browserAction.getText5());
		
	}

	/*Registration by password including less than any 4 symbols
	*go to registration page
	*input е-mail
	*input password including less than any 4 symbols
	*choose any role
	*click on button "Register"*/
	@Test(priority=4, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterInsecurePassword(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("nadjacv@mail.ru");
		registerPage.passwordRegister.sendKeys("123");
		registerPage.rolePatient.click();
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("Пожалуйста, используйте требуемый формат:"));
	}

	/*Registration without e-mail
	 * go to registration page
	 * field for e-mail keep empty
	 * input password
	 * click on button "Register"*/
	@Test(priority=5, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutEmail(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("");
		registerPage.passwordRegister.sendKeys("nadja");
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("Пожалуйста, заполните это поле."));
	} 
	
	/*Registration without password
	 * go to registration page
	 * input e-mail
	 * field for password keep empty
	 * click on button "Register"*/
	@Test(priority=6, dependsOnMethods={"checkElementsRegisterPage"})
	public void testRegisterWithoutPassword(){
		browserAction.goTo(REGISTER_URL);
		registerPage.emailRegister.sendKeys("nadjacv545@mail.ru");
		registerPage.passwordRegister.sendKeys("");
		registerPage.registerButton.click();
		Assert.assertTrue(browserAction.containsText("Пожалуйста, заполните это поле."));
	} 

	@AfterMethod
	public void afterMethod(){
		browserAction.getDriver().quit();
	}
}
