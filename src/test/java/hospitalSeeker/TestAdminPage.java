package hospitalSeeker;

import org.openqa.selenium.support.PageFactory;
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

	@Test
	public void checkElementsAdminPage(){
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
	
	
	/*Checking equality of count of all users in DB and shown on Web-page
	 * log in as admin
	 * choose filter "Role"->"All"
	 * get count of all users in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 0)
	public void countAllUsers() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		adminPage.showUsers.click();
		browser.implicitWait(3);
		adminPage.roleAll.click();
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		Assert.assertEquals(adminPage.usersAll.size()-1, 41);
	}
	
	/*Checking equality of count admins in DB and after using filter "Role"->"Admin"
	 * log in as admin
	 * choose filter "Role"->"Admin"
	 * get count of admins in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 0)
	public void countAdmins() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		adminPage.showUsers.click();
		browser.implicitWait(3);
		adminPage.roleAdmin.click();
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,2);
	}
}
