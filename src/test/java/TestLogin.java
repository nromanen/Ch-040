
import header.DropdownLogin;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;

public class TestLogin extends BaseTest{
	
	LoginPage loginPage;
	DropdownLogin dropdownLogin;
	
	@BeforeMethod
	public void beforeMethod(){
		super.beforeMethod();
		loginPage = PageFactory.initElements(browserAction.getDriver(), LoginPage.class);
	}
	

	  @Test(priority=0)
	    public void checkElementsLoginPage() {
	        browserAction.goTo(LOGIN_URL);
	        Assert.assertTrue(browserAction.isElementPresent(loginPage.emailLogin));
	        Assert.assertTrue(browserAction.isElementPresent(loginPage.passwordLogin));
	        Assert.assertTrue(browserAction.isElementPresent(loginPage.rememberMe));
	        Assert.assertTrue(browserAction.isElementPresent(loginPage.loginButton));
	        Assert.assertTrue(browserAction.isElementPresent(loginPage.homeButton));
	    }
	  
	/*Correct log in
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"*/
	@Test(priority=0, dependsOnMethods={"checkElementsLoginPage"})
	public void testLogin(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertTrue(browserAction.containsText("Log out"));
	}
	
	/*Correct work of homeButton
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Home"*/
	@Test(priority=1, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginHomeButton(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.homeButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),HOME_URL);
	}
	
	/*Login without e-mail
	 * go to login page
	 * field for e-mail keep empty
	 * input password
	 * click on button "Log in"*/
	@Test(priority=2, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginWithoutEmail(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertEquals(browserAction.getCurrentUrl(),LOGIN_URL);
	}
	
	/*Login without password
	 * go to login page
	 * input e-mail
	 * field for password keep empty
	 * click on button "Log in"*/
	@Test(priority=3, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginWithoutPassword(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("");
		loginPage.loginButton.click();	
		Assert.assertEquals(browserAction.getCurrentUrl(),LOGIN_URL);
	}
	
	/*Login by unregistered e-mail
	 * go to login page
	 * input unregistered e-mail
	 * input password
	 * click on button "Log in"*/
	@Test(priority=4, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginIncorrectEmail(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("attqc@mail.ru");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertTrue(browserAction.containsText("Invalid"));
	}
	
	/*Login by incorrect password
	 * go to login page
	 * input registered e-mail
	 * input incorrect password
	 * click on button "Log in"*/
    @Test(priority=5, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginIncorrectPassword(){
		browserAction.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("attqc");
		loginPage.loginButton.click();
		Assert.assertTrue(browserAction.containsText("Invalid"));
	}
	
	@AfterMethod
	public void afterMethod(){
		browserAction.getDriver().quit();
	}
	
}
