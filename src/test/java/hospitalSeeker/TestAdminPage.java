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
		browser.selectDropdown(adminPage.role,"ALL");
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
	@Test(priority = 1)
	public void countAdmins() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.role,"ADMIN");
		//adminPage.roleAdmin.click();
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,3);
	}

	@Test(priority = 2)
	public void countDoctor(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.role,"DOCTOR");
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,11);
	}

	@Test(priority = 3)
	public void countManager(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.role,"MANAGER");
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,4);
	}

	@Test(priority = 4)
	public void countPatient(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.role,"PATIENT");
		browser.implicitWait(3);
		adminPage.submitButton.click();
		browser.implicitWait(3);
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,24);
	}

	@Test(priority = 5)
	public void SearchByEmail(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"Email");
		browser.implicitWait(3);
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.submitButton.click();
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,1);
	}

	@Test(priority = 6)
	public void SearchByFirstName(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"First Name");
		browser.implicitWait(3);
		adminPage.search.sendKeys("Kurt");
		adminPage.submitButton.click();
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,1);
	}

	@Test(priority = 7)
	public void SearchByLastName(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"Last Name");
		browser.implicitWait(3);
		adminPage.search.sendKeys("Kobein");
		adminPage.submitButton.click();
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,1);
	}

	@Test(priority = 8)
	public void EnabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		adminPage.enabled.click();
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,42);
	}

	@Test(priority = 9)
	public void DisabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		adminPage.disabled.click();
		System.out.println(adminPage.usersAll.size()-1);
		Assert.assertEquals(adminPage.usersAll.size()-1,0);
	}

	@Test(priority = 10)
	public void AllUsers() {
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		adminPage.allUsers.click();
		System.out.println(adminPage.usersAll.size() - 1);
		Assert.assertEquals(adminPage.usersAll.size() - 1, 42);
	}

	@Test(priority = 11)
	public void ViewUser(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"Email");
		browser.implicitWait(3);
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.submitButton.click();
		adminPage.actionsViewUser.click();
		browser.implicitWait(3);
		Assert.assertTrue(browser.containsText("View user"));
	}

	@Test(priority = 12)
	public void EditUser(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"Email");
		browser.implicitWait(3);
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.submitButton.click();
		adminPage.actionsEditUser.click();
		browser.implicitWait(3);
		Assert.assertTrue(browser.containsText("Edit User"));
	}

	@Test(priority = 13)
	public void DeleteUser(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
		loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
		loginPage.loginButton.click();
		browser.implicitWait(3);
		browser.selectDropdown(adminPage.searchBy,"Email");
		browser.implicitWait(3);
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.submitButton.click();
		adminPage.actionsDeleteUser.click();
		browser.implicitWait(3);
		Assert.assertTrue(browser.containsText("Delete User"));
	}
}
