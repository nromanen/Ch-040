package hospitalSeeker;

import hospitalSeeker.BaseTest;
import hospitalSeeker.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

	LoginPage loginPage;

	@BeforeMethod
	public void beforeMethod() {
		loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
	}

	@Test(priority = 0)
	public void checkElementsLoginPage() {
		browser.goTo(LOGIN_URL);
		Assert.assertTrue(browser.isElementPresent(loginPage.emailLogin),"1");
		Assert.assertTrue(browser.isElementPresent(loginPage.passwordLogin),"2");
		Assert.assertTrue(browser.isElementPresent(loginPage.rememberMe),"3");
		Assert.assertTrue(browser.isElementPresent(loginPage.forgotPassword),"4");
		Assert.assertTrue(browser.isElementPresent(loginPage.loginButton),"5");
		Assert.assertTrue(browser.isElementPresent(loginPage.registerButton),"6");
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
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.rememberMe.click();
		loginPage.loginButton.click();
		browser.waitUntilElementIsPresent(By.id("userDropdown1"));
		Assert.assertTrue(browser.containsText("Charles Darvin"));
	}

	/*
	 * Login without e-mail 
	 * go to login page 
	 * field for e-mail keep empty 
	 * input password 
	 * click on button "Log in"
	 */
	@Test(priority = 2)
	public void testLoginWithoutEmail() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		browser.waitUntilElementIsPresent(By.cssSelector(loginPage.INVALID_USERNAME_OR_PASSWORD));
		Assert.assertTrue(browser.containsText("Invalid username or password."));
	}

	/*
	 * Login without password 
	 * go to login page 
	 * input e-mail 
	 * field for password
	 * keep empty 
	 * click on button "Log in"
	 */
	@Test(priority = 3)
	public void testLoginWithoutPassword() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("");
		loginPage.loginButton.click();
		browser.waitUntilElementIsPresent(By.cssSelector(loginPage.INVALID_USERNAME_OR_PASSWORD));
		Assert.assertTrue(browser.containsText("Invalid username or password."));
	}

	/*
	 * Login by unregistered e-mail 
	 * go to login page 
	 * input unregistered e-mail
	 * input password 
	 * click on button "Log in"
	 */
	@Test(priority = 4)
	public void testLoginIncorrectEmail() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("tututu@ukr.net");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		browser.waitUntilElementIsPresent(By.cssSelector(loginPage.INVALID_USERNAME_OR_PASSWORD));
		Assert.assertTrue(browser.containsText("Invalid username or password."));
	}

	/*
	 * Login by incorrect password 
	 * go to login page 
	 * input registered e-mail
	 * input incorrect password 
	 * click on button "Log in"
	 */
	@Test(priority = 5)
	public void testLoginIncorrectPassword() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("tututu2016");
		loginPage.loginButton.click();
		browser.waitUntilElementIsPresent(By.cssSelector(loginPage.INVALID_USERNAME_OR_PASSWORD));
		Assert.assertTrue(browser.containsText("Invalid username or password."));
	}
}
