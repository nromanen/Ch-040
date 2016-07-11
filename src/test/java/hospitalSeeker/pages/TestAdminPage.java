package hospitalSeeker.pages;

import hospitalSeeker.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestAdminPage extends BaseTest {

	AdminPage adminPage;
	LoginPage loginPage;
	Header header;
	public static final String PATIENT_EMAIL = "patient.in@hospitals.ua";

	@DataProvider(name="rolesCount")
	public Object[][] rolesCount(){
		return new Object[][]{
				{"ADMIN",1},
				{"MANAGER",1},
				{"DOCTOR",1},
				{"PATIENT",2}
		};
	}

	@DataProvider(name="searchBy")
	public Object[][] searchBy(){
		return new Object[][]{
				{"Email", "manager.kh@hospitals.ua", 2},
				{"First Name", "Charles", 3},
				{"Last Name", "Darvin", 4}
		};
	}

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
		Assert.assertEquals(adminPage.allRows.size(),5);
	}

	/*Checking equality of count admins in DB and after using filter "Role"->"Admin", "Manager", "Doctor", "Patient"
	 * log in as admin
	 * choose filter "Role"->"Admin", "Manager", "Doctor", "Patient"
	 * get count of users in result
	 * Checking equality with count in DB
	 * */
	@Test(priority = 2, dataProvider = "rolesCount")
	public void testCountUsers(String role,int expectedCount) {
		browser.selectDropdown(adminPage.role, role);
		adminPage.searchButton.click();
		Assert.assertTrue(browser.getDataFromTable(1,5).contains(role));
		Assert.assertEquals(adminPage.allRows.size(),expectedCount);
	}

	 /**Checking correct result after using filter "Search By"->"Email", "Last Name", "First Name"
	 * log in as admin
	 * choose filter "Search By"->"Email", "Last Name", "First Name"
	 * input value, what you find
	 * Check result
	 * */
	@Test(priority = 3, dataProvider = "searchBy")
	public void testSearchBy(String filter, String expectedValue, int columnNumber){
		browser.selectDropdown(adminPage.searchBy,filter);
		adminPage.search.sendKeys(expectedValue);
		adminPage.searchButton.click();
		Assert.assertEquals(browser.getDataFromTable(1,columnNumber),expectedValue);
	}

	/*Checking correct work of filter "Disabled" button
  	 * log in as admin
  	 * click on button "Disabled"
 	 * Checking equality with count in DB
 	 * */
	@Test(priority = 4)
	public void testDisabledUsers(){
		adminPage.disabled.click();
		Assert.assertEquals(adminPage.allRows.size(), 0);
	}

	/*Seeing information about user
   	 * log in as admin
   	 * click on icon "View user"
   	 * check information in modal window
  	 * */
	@Test(priority = 5)
	public void testViewUser(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kh@hospitals.ua");
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
	@Test(priority = 6)
	public void testEditUser(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kh@hospitals.ua");
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
	@Test(priority = 7)
	public void testDeleteUser(){
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kh@hospitals.ua");
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
	@Test(priority = 8)
	public void testDisableUser(){
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(PATIENT_EMAIL,PATIENT_PASSWORD);
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
		adminPage.disableUser(PATIENT_EMAIL,getWrapper());
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(PATIENT_EMAIL,PATIENT_PASSWORD);
		Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
	}

	@Test(priority = 9)
	public void testSortingEmail(){
		adminPage.sortEmailColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,2),"patient.in@hospitals.ua");
	}

	@Test(priority = 10)
	public void testSortingFirstName(){
		adminPage.sortFirstNameColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,3),"Charles");
	}

	@Test(priority = 11)
	public void testSortingLastName(){
		adminPage.sortLastNameColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,4),"Darvin");
	}

	@Test(priority = 12)
	public void testSortingRole(){
		adminPage.sortRoleColumn.click();
		Assert.assertEquals(browser.getDataFromTable(1,5),"PATIENT");
	}
}


