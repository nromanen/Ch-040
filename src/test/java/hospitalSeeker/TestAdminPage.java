package hospitalSeeker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdminPage extends BaseTest {
	
	AdminPage adminPage;
	LoginPage loginPage;
	HeaderPage headerPage;
	
	@BeforeMethod
	public void beforeMethod() {
		loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
		adminPage = PageFactory.initElements(browser.getDriver(), AdminPage.class);
		headerPage = HeaderPage.init(browser.getDriver());
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
		Assert.assertTrue(browser.isElementPresent(adminPage.searchButton),"6");
		Assert.assertTrue(browser.isElementPresent(adminPage.enabled),"7");
		Assert.assertTrue(browser.isElementPresent(adminPage.disabled),"8");
		Assert.assertTrue(browser.isElementPresent(adminPage.allUsers),"9");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsViewUser),"10");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsEditUser),"11");
		Assert.assertTrue(browser.isElementPresent(adminPage.actionsDeleteUser),"12");
		Assert.assertTrue(browser.isElementPresent(adminPage.sortEmailColumn),"13");
		Assert.assertTrue(browser.isElementPresent(adminPage.sortFirstNameColumn),"14");
		Assert.assertTrue(browser.isElementPresent(adminPage.sortLastNameColumn),"15");
		Assert.assertTrue(browser.isElementPresent(adminPage.sortRoleColumn),"16");
		Assert.assertTrue(browser.isElementPresent(headerPage.userDropdownButton),"17");
		headerPage.userDropdownButton.click();
		browser.sleep(2);
		Assert.assertTrue(browser.isElementPresent(headerPage.logoutButton),"18");
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
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.showUsers,"30");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(), 21);
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
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"ADMIN");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Doctor"
	 * log in as admin
	 * choose filter "Role"->"Doctor"
	 * get count of doctors in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 2)
	public void countDoctor(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"DOCTOR");
		browser.selectDropdown(adminPage.showUsers,"15");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),11);
	}


	/*Checking equality of count admins in DB and after using filter "Role"->"Manager"
	 * log in as admin
	 * choose filter "Role"->"Manager"
	 * get count of managers in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 3)
	public void countManager(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"MANAGER");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),4);
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Patient"
	 * log in as admin
	 * choose filter "Role"->"Patient"
	 * get count of patients in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 4)
	public void countPatient(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"PATIENT");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),5);
	}


	/*Checking correct result after using filter "Search By"->"Email"
	 * log in as admin
	 * choose filter "Search By"->"Email"
	 * input any existing email
	 * Check result
	 * */
	@Test(priority = 5)
	public void SearchByEmail(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}


	/*Checking correct result after using filter "Search By"->"First Name"
	 * log in as admin
	 * choose filter "Search By"->"First Name"
	 * input any existing first name
	 * Check result
	 * */
	@Test(priority = 6)
	public void SearchByFirstName(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"First Name");
		adminPage.search.sendKeys("Kurt");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	/*Checking correct result after using filter "Search By"->"Last Name"
 	 * log in as admin
 	 * choose filter "Search By"->"Last Name"
 	 * input any existing last name
 	 * Check result
	 * */
	@Test(priority = 7)
	public void SearchByLastName(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Last Name");
		adminPage.search.sendKeys("Kobein");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	/*Checking correct work of filter "Enabled" button
 	 * log in as admin
 	 * click on button "Enabled"
 	 * Checking equality with count in DB
	 * */
	@Test(priority = 8)
	public void EnabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.enabled.click();
		browser.selectDropdown(adminPage.showUsers,"30");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),21);
	}

	/*Checking correct work of filter "Disabled" button
  	 * log in as admin
  	 * click on button "EDisabled"
 	 * Checking equality with count in DB
 	 * */
	@Test(priority = 9)
	public void DisabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.disabled.click();
		browser.selectDropdown(adminPage.showUsers,"30");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(),0);
	}

	/*Checking correct work of filter "All Users" button
  	 * log in as admin
  	 * click on button "All Users"
  	 * Checking equality with count in DB
 	 * */
	@Test(priority = 10)
	public void AllUsers() {
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.allUsers.click();
		browser.selectDropdown(adminPage.showUsers,"50");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		System.out.println(adminPage.usersAll.size());
		Assert.assertEquals(adminPage.usersAll.size(), 0);
	}

	/*Seeing information about user
   	 * log in as admin
   	 * click on icon "View user"
   	 * check information in modal window
  	 * */
	@Test(priority = 11)
	public void ViewUser(){
 	browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsViewUser.click();
		browser.waitUntilElementVisible(adminPage.viewUserTitle);
		Assert.assertTrue(browser.isElementPresent(adminPage.viewUserTitle));
	}

	/*Editing user
   	 * log in as admin
   	 * click on icon "Edit user"
   	 * check available actions on this page
   	 * */
	@Test(priority = 12)
	public void EditUser(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsEditUser.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.editEditUserButton));
	}

	/*Deleting user
    * log in as admin
    * click on icon "Delete user"
    * check functional on modal window
    * */
	@Test(priority = 13)
	public void DeleteUser(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsDeleteUser.click();
		browser.waitUntilElementVisible(adminPage.deleteUserAlertDeleteButton);
		Assert.assertTrue(browser.isElementPresent(adminPage.deleteUserAlertDeleteButton));
	}

	/*Disabling user
	 * log in as patient
	 * check that he has access to account
	 * log out and log in as admin
	 * disable user
	 * log out and log in as patient
	 * check that he has no access to account
	 * */
	@Test(priority = 14)
	public void DisableUser(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.rr@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		browser.sleep(1);
		headerPage.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("patient.rr@hospitals.ua");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		adminPage.actionsViewUser.click();
		browser.waitUntilElementVisible(adminPage.viewUserAlertEnabledButton);
		adminPage.viewUserAlertEnabledButton.click();
		adminPage.viewUserCancelButton.click();
		browser.sleep(2);
		headerPage.logout();
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.rr@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
	}
}
