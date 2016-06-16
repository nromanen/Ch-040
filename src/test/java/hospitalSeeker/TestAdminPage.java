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
		browser.implicitWait(3);
		Assert.assertTrue(browser.isElementPresent(adminPage.allUsersTable),"1");
		Assert.assertTrue(browser.isElementPresent(adminPage.showUsers),"2");
		Assert.assertTrue(browser.isElementPresent(adminPage.role),"3");
		Assert.assertTrue(browser.isElementPresent(adminPage.searchBy),"4");
		Assert.assertTrue(browser.isElementPresent(adminPage.search),"5");
		Assert.assertTrue(browser.isElementPresent(adminPage.submitButton),"6");
		Assert.assertTrue(browser.isElementPresent(adminPage.enabled),"7");
		Assert.assertTrue(browser.isElementPresent(adminPage.disabled),"8");
		Assert.assertTrue(browser.isElementPresent(adminPage.allUsers),"9");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsViewUser),"10");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsEditUser),"11");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsDeleteUser),"12");
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableEmailColumn),"13");
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableFirstNameColumn),"14");
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableLastNameColumn),"15");
		Assert.assertTrue(browser.isElementPresent(adminPage.headerTableRoleColumn),"16");	
	}
}
