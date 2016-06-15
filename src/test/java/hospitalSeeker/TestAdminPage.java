package hospitalSeeker;

import org.openqa.selenium.support.PageFactory;
import hospitalSeeker.BaseTest;
import hospitalSeeker.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdminPage extends BaseTest {
	
	AdminPage adminPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void beforeMethod() {
		loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
		adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);
	}

	@Test(priority = 0)
	public void checkElementsAdminPage() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.allUsersTable));
		Assert.assertTrue(browser.isElementPresent(adminPage.showUsers));
		Assert.assertTrue(browser.isElementPresent(adminPage.role));
		Assert.assertTrue(browser.isElementPresent(adminPage.searchBy));
		Assert.assertTrue(browser.isElementPresent(adminPage.search));
		Assert.assertTrue(browser.isElementPresent(adminPage.submitButton));
		Assert.assertTrue(browser.isElementPresent(adminPage.enabled));
		Assert.assertTrue(browser.isElementPresent(adminPage.disabled));
		Assert.assertTrue(browser.isElementPresent(adminPage.allUsers));
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsViewUser));
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsEditUser));
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsDeleteUser));
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableEmailColumn));
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableFirstNameColumn));
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableLastNameColumn));
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableRoleColumn));
}
}
