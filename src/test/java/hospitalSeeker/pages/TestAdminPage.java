package hospitalSeeker.pages;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.Header;
import hospitalSeeker.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestAdminPage extends BaseTest {

	AdminPage adminPage;
	LoginPage loginPage;
	Header header;

	@BeforeMethod
	public void beforeMethod() {
		loginPage = LoginPage.init(browser.getDriver());
		adminPage = AdminPage.init(browser.getDriver());
		header = Header.init(browser.getDriver());
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
	}

	@Test
	public void checkElementsAdminPage() {
		String error = browser.checkIfElementNotPresent(adminPage.allUsersTable)
				.concat(browser.checkIfElementNotPresent(adminPage.showUsers))
				.concat(browser.checkIfElementNotPresent(adminPage.role))
				.concat(browser.checkIfElementNotPresent(adminPage.searchBy))
				.concat(browser.checkIfElementNotPresent(adminPage.search))
				.concat(browser.checkIfElementNotPresent(adminPage.searchButton))
				.concat(browser.checkIfElementNotPresent(adminPage.enabled))
				.concat(browser.checkIfElementNotPresent(adminPage.disabled))
				.concat(browser.checkIfElementNotPresent(adminPage.allUsers))
				.concat(browser.checkIfElementNotPresent(adminPage.actionsViewUser))
				.concat(browser.checkIfElementNotPresent(adminPage.actionsEditUser))
				.concat(browser.checkIfElementNotPresent(adminPage.actionsDeleteUser))
				.concat(browser.checkIfElementNotPresent(adminPage.sortEmailColumn))
				.concat(browser.checkIfElementNotPresent(adminPage.sortFirstNameColumn))
				.concat(browser.checkIfElementNotPresent(adminPage.sortRoleColumn));
		System.out.println(error);
	}

	/*Checking equality of count of all users in DB and shown on Web-page
    * log in as admin
    * choose filter "Role"->"All"
    * get count of all users in result
    * Checking equality with count in DB
    * */
	@Test(priority = 1)
	public void testCountAllUsers() {
		adminPage.searchButton.click();
		adminPage.lastPageButton.click();
		Assert.assertEquals(browser.getDataFromTable(adminPage.allRows.size(),1), "23");
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Admin"
	 * log in as admin
	 * choose filter "Role"->"Admin"
	 * get count of admins in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 2)
	public void testCountAdmins() {
		browser.selectDropdown(adminPage.role, "ADMIN");
		adminPage.searchButton.click();
		Assert.assertTrue(browser.getDataFromTable(1,5).contains("ADMIN"));
		Assert.assertEquals(browser.getDataFromTable(adminPage.allRows.size(),1),"1");
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Doctor"
	 * log in as admin
	 * choose filter "Role"->"Doctor"
	 * get count of doctors in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 3)
	public void testCountDoctor() {
		browser.selectDropdown(adminPage.role, "DOCTOR");
		adminPage.searchButton.click();
		Assert.assertTrue(browser.getDataFromTable(3,5).contains("DOCTOR"));
		adminPage.lastPageButton.click();
		Assert.assertEquals(browser.getDataFromTable(adminPage.allRows.size(),1),"11");
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Manager"
	 * log in as admin
	 * choose filter "Role"->"Manager"
	 * get count of managers in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 4)
	public void testCountManager() {
		browser.selectDropdown(adminPage.role, "MANAGER");
		adminPage.searchButton.click();
		Assert.assertTrue(browser.getDataFromTable(3,5).contains("MANAGER"));
		Assert.assertEquals(browser.getDataFromTable(adminPage.allRows.size(),1),"4");
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Patient"
	 * log in as admin
	 * choose filter "Role"->"Patient"
	 * get count of patients in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 5)
	public void testCountPatient() {
		browser.selectDropdown(adminPage.role, "PATIENT");
		adminPage.searchButton.click();
		Assert.assertTrue(browser.getDataFromTable(3,5).contains("PATIENT"));
		Assert.assertEquals(browser.getDataFromTable(adminPage.allRows.size(),1),"7");
	}

	 /**Checking correct result after using filter "Search By"->"Email"
	 * log in as admin
	 * choose filter "Search By"->"Email"
	 * input any existing email
	 * Check result
	 * */
	@Test(priority = 6)
	public void testSearchByEmail(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		Assert.assertEquals(browser.getDataFromTable(1,2),"manager.kk@hospitals.ua");
	}

	/*Checking correct result after using filter "Search By"->"First Name"
	 * log in as admin
	 * choose filter "Search By"->"First Name"
	 * input any existing first name
	 * Check result
	 * */
	@Test(priority = 7)
	public void testSearchByFirstName(){
		adminPage.search.sendKeys("Kurt");
		adminPage.searchButton.click();
		Assert.assertEquals(browser.getDataFromTable(1,3),"Kurt");
	}

	/*Checking correct result after using filter "Search By"->"Last Name"
 	 * log in as admin
 	 * choose filter "Search By"->"Last Name"
 	 * input any existing last name
 	 * Check result
	 * */
	@Test(priority = 8)
	public void testSearchByLastName(){
		browser.selectDropdown(adminPage.searchBy,"Last Name");
		adminPage.search.sendKeys("Kobein");
		adminPage.searchButton.click();
		Assert.assertEquals(browser.getDataFromTable(1,4),"Kobein");
	}

	/*Checking correct work of filter "Disabled" button
  	 * log in as admin
  	 * click on button "Disabled"
 	 * Checking equality with count in DB
 	 * */
	@Test(priority = 9)
	public void testDisabledUsers(){
		adminPage.disabled.click();
		Assert.assertEquals(adminPage.allRows.size(), 0);
	}

	/*Seeing information about user
   	 * log in as admin
   	 * click on icon "View user"
   	 * check information in modal window
  	 * */
	@Test(priority = 10)
	public void testViewUser(){
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
	@Test(priority = 11)
	public void testEditUser(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsEditUser.click();
		browser.waitUntilElementVisible(adminPage.editEditUserButton);
		Assert.assertTrue(browser.isElementPresent(adminPage.editEditUserButton));
	}

	/*Deleting user
    * log in as admin
    * click on icon "Delete user"
    * check functional on modal window
    * */
	@Test(priority = 12)
	public void testDeleteUser(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsDeleteUser.click();
		browser.waitUntilElementVisible(adminPage.deleteUserAlertDeleteButton);
		Assert.assertTrue(browser.isElementPresent(adminPage.deleteUserAlertDeleteButton));
	}

	/*Disabling user
	 * log in as patient
	 * check there is access to account
	 * log out and log in as admin
	 * disable user
	 * log out and log in as patient
	 * check there is no access to account
	 * */
	@Test(priority = 13)
	public void testDisableUser(){
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.in@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		browser.sleep(1);
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("patient.in@hospitals.ua");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		adminPage.actionsViewUser.click();
		browser.waitUntilElementVisible(adminPage.viewUserAlertEnabledButton);
		adminPage.viewUserAlertEnabledButton.click();
		adminPage.viewUserCancelButton.click();
		browser.sleep(2);
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.in@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
	}

	@Test(priority = 14)
	public void testSortingEmail(){
		adminPage.sortEmailColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,2),"patient.sf@hospitals.ua");
	}

	@Test(priority = 15)
	public void testSortingFirstName(){
		adminPage.sortFirstNameColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,3),"Charles");
	}

	@Test(priority = 16)
	public void testSortingLastName(){
		adminPage.sortLastNameColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,4),"Benington");
	}

	@Test(priority = 17)
	public void testSortingRole(){
		adminPage.sortRoleColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,5),"PATIENT");
	}
}


