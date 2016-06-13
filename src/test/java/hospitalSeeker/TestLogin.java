package hospitalSeeker;

import hospitalSeeker.BaseTest;
import hospitalSeeker.LoginPage;
import hospitalSeeker.header.DropdownLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

	LoginPage loginPage;
	DropdownLogin dropdownLogin;

	@BeforeMethod
	public void beforeMethod() {
		super.beforeMethod();
		loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
	}

	@Test
	public void googleCheck() {
		browser.goTo("http://www.google.com");
	}

	@Test(priority = 0)
	public void checkElementsLoginPage() {
		browser.goTo(LOGIN_URL);
		Assert.assertTrue(browser.isElementPresent(loginPage.emailLogin));
		Assert.assertTrue(browser.isElementPresent(loginPage.passwordLogin));
		Assert.assertTrue(browser.isElementPresent(loginPage.rememberMe));
		Assert.assertTrue(browser.isElementPresent(loginPage.loginButton));
		// Assert.assertTrue(browser.isElementPresent(loginPage.homeButton));
	}
	//

	/*
	 * Correct log in go to login page input e-mail input password click on
	 * button "Log in"
	 */
	@Test(priority = 1)
	public void testLogin() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertTrue(browser.containsText("Log out"));
	}

	/*
	 * Correct work of homeButton go to login page input e-mail input password
	 * click on button "Home"
	 */
	@Test(priority = 2)
	public void testLoginHomeButton() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		// loginPage.homeButton.click();
		Assert.assertEquals(browser.getCurrentUrl(), HOME_URL);
	}

	/*
	 * Login without e-mail go to login page field for e-mail keep empty input
	 * password click on button "Log in"
	 */
	@Test(priority = 3)
	public void testLoginWithoutEmail() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertEquals(browser.getCurrentUrl(), LOGIN_URL);
	}

	/*
	 * Login without password go to login page input e-mail field for password
	 * keep empty click on button "Log in"
	 */
	@Test(priority = 4)
	public void testLoginWithoutPassword() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("");
		loginPage.loginButton.click();
		Assert.assertEquals(browser.getCurrentUrl(), LOGIN_URL);
	}

	/*
	 * Login by unregistered e-mail go to login page input unregistered e-mail
	 * input password click on button "Log in"
	 */
	@Test(priority = 5)
	public void testLoginIncorrectEmail() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("attqc@mail.ru");
		loginPage.passwordLogin.sendKeys(PATIENT_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertTrue(browser.containsText("Invalid"));
	}

	/*
	 * Login by incorrect password go to login page input registered e-mail
	 * input incorrect password click on button "Log in"
	 */
	@Test(priority = 6)
	public void testLoginIncorrectPassword() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(PATIENT_LOGIN);
		loginPage.passwordLogin.sendKeys("attqc");
		loginPage.loginButton.click();
		Assert.assertTrue(browser.containsText("Invalid"));
	}

	@AfterMethod
	public void afterMethod() {
		browser.getDriver().quit();
	}

}
