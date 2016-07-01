package hospitalSeeker.pages;

import hospitalSeeker.AdminPage;
import hospitalSeeker.BaseTest;
import hospitalSeeker.Header;
import hospitalSeeker.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

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

/*	@Test
	public void getTableFromPage(){
		        WebElement table_element = browser.getDriver().findElement(By.id("allUsers"));
		        java.util.List<WebElement> tr_collection=table_element.findElements(By.xpath("/html/body/section/div[1]/div/table/tbody/tr"));

				System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		        int row_num,col_num;
		        row_num=1;
		        for(WebElement trElement : tr_collection)
			        {
						java.util.List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
						List list = new ArrayList(tr_collection);
//						Assert.assertTrue(tr_collection.contains("ADMIN"));
						System.out.println("NUMBER OF COLUMNS="+td_collection.size());
						System.out.println(list.toString());
						row_num++;
		        }
		}

	@Test
	public void testPrintData(){
		int Row_count = browser.getDriver().findElements(By.xpath("html/body/section/div/div/div[2]/table/tbody/tr")).size();
		System.out.println("Number Of Rows = "+Row_count);

		int Col_count = browser.getDriver().findElements(By.xpath("html/body/section/div/div/div[2]/table/tbody/tr[1]/td")).size();
		System.out.println("Number Of Columns = "+Col_count);

		String first_part = "html/body/section/div/div/div[2]/table/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";

		for (int i=1; i<=Row_count; i++){
			for(int j=1; j<=Col_count; j++){
				String final_xpath = first_part+i+second_part+j+third_part;
				String Table_data = browser.getDriver().findElement(By.xpath(final_xpath)).getText();
				System.out.print(Table_data +" ");
			}
			System.out.println("");
			System.out.println("");
		} }}*/

	@Test
	public void getTableFromPage() {
		WebElement table_element = browser.getDriver().findElement(By.id("allUsers"));
		java.util.List<WebElement> tr_collection = table_element.findElements(By.xpath("/html/body/section/div[1]/div/table/tbody/tr"));

		System.out.println("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
		int row_num, col_num;
		row_num = 1;
		for (WebElement trElement : tr_collection) {
			java.util.List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			System.out.println("NUMBER OF COLUMNS=" + td_collection.size());
			col_num = 1;
			System.out.println("row" + row_num);
			for (WebElement tdElement : td_collection) {
				System.out.println(("col" + col_num + "text=" + tdElement.getText()).toString());
				col_num++;
			}
			row_num++;
		}
	}



	/*@Test
	public void getTableFromPage(){
		WebElement table_element = browser.getDriver().findElement(By.id("allUsers"));
		java.util.List<WebElement> tr_collection=table_element.findElements(By.xpath("/html/body/section/div[1]/div/table/tbody/tr"));

		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		int row_num,col_num;
		row_num=1;
		for(WebElement trElement : tr_collection)
		{
			java.util.List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			System.out.println("NUMBER OF COLUMNS="+td_collection.size());
			col_num=1;
			for(WebElement tdElement : td_collection)
			{
				System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
				col_num++;
			}
			row_num++;
		}

	}*/

/*	*//*Checking equality of count of all users in DB and shown on Web-page
	 * log in as admin
	 * choose filter "Role"->"All"
	 * get count of all users in result
	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 1)
	public void testCountAllUsers() {
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.searchButton.click();
		adminPage.fourthPage.click();
		Assert.assertEquals(adminPage.usersAll.size(), 2);
	}

	*//*Checking equality of count admins in DB and after using filter "Role"->"Admin"
	 * log in as admin
	 * choose filter "Role"->"Admin"
	 * get count of admins in result
	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 2)
	public void testCountAdmins() {
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"ADMIN");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	*//*Checking equality of count admins in DB and after using filter "Role"->"Doctor"
	 * log in as admin
	 * choose filter "Role"->"Doctor"
	 * get count of doctors in result
	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 3)
	public void testCountDoctor(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.role,"DOCTOR");
		adminPage.searchButton.click();
		adminPage.nextPageButton.click();
		Assert.assertEquals(adminPage.usersAll.size(),2);
	}

	*//*Checking equality of count admins in DB and after using filter "Role"->"Manager"
	 * log in as admin
	 * choose filter "Role"->"Manager"
	 * get count of managers in result
	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 4)
	public void testCountManager(){

		browser.selectDropdown(adminPage.role,"MANAGER");
		adminPage.searchButton.click();
		Assert.assertEquals(adminPage.usersAll.size(),4);
	}

	*//*Checking equality of count admins in DB and after using filter "Role"->"Patient"
	 * log in as admin
	 * choose filter "Role"->"Patient"
	 * get count of patients in result
	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 5)
	public void testCountPatient(){

		browser.selectDropdown(adminPage.role,"PATIENT");
		adminPage.searchButton.click();
		adminPage.nextPageButton.click();
		Assert.assertEquals(adminPage.usersAll.size(),6);
	}

	*//*Checking correct result after using filter "Search By"->"Email"
	 * log in as admin
	 * choose filter "Search By"->"Email"
	 * input any existing email
	 * Check result
	 * *//*
	@Test(priority = 6)
	public void testSearchByEmail(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	*//*Checking correct result after using filter "Search By"->"First Name"
	 * log in as admin
	 * choose filter "Search By"->"First Name"
	 * input any existing first name
	 * Check result
	 * *//*
	@Test(priority = 7)
	public void testSearchByFirstName(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.search.sendKeys("Kurt");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}



	*//*Checking correct result after using filter "Search By"->"Last Name"
 	 * log in as admin
 	 * choose filter "Search By"->"Last Name"
 	 * input any existing last name
 	 * Check result
	 * *//*
	@Test(priority = 8)
	public void testSearchByLastName(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Last Name");
		adminPage.search.sendKeys("Kobein");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),1);
	}

	*//*Checking correct work of filter "Enabled" button
 	 * log in as admin
 	 * click on button "Enabled"
 	 * Checking equality with count in DB
	 * *//*
	@Test(priority = 9)
	public void testEnabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.enabled.click();
		browser.selectDropdown(adminPage.showUsers,"30");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),10);
	}

	*//*Checking correct work of filter "Disabled" button
  	 * log in as admin
  	 * click on button "Disabled"
 	 * Checking equality with count in DB
 	 * *//*
	@Test(priority = 10)
	public void testDisabledUsers(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.disabled.click();
		browser.selectDropdown(adminPage.showUsers,"30");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(),0);
	}

	*//*Checking correct work of filter "All Users" button
  	 * log in as admin
  	 * click on button "All Users"
  	 * Checking equality with count in DB
 	 * *//*
	@Test(priority = 11)
	public void testAllUsers() {
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		adminPage.allUsers.click();
		browser.selectDropdown(adminPage.showUsers,"50");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		Assert.assertEquals(adminPage.usersAll.size(), 21);
	}

	*//*Seeing information about user
   	 * log in as admin
   	 * click on icon "View user"
   	 * check information in modal window
  	 * *//*
	@Test(priority = 12)
	public void testViewUser(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsViewUser.click();
		browser.waitUntilElementVisible(adminPage.viewUserTitle);
		Assert.assertTrue(browser.isElementPresent(adminPage.viewUserTitle));
	}

	*//*Editing user
   	 * log in as admin
   	 * click on icon "Edit user"
   	 * check available actions on this page
   	 * *//*
	@Test(priority = 13)
	public void testEditUser(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsEditUser.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.editEditUserButton));
	}

	*//*Deleting user
    * log in as admin
    * click on icon "Delete user"
    * check functional on modal window
    * *//*
	@Test(priority = 14)
	public void testDeleteUser(){
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("manager.kk@hospitals.ua");
		adminPage.searchButton.click();
		adminPage.actionsDeleteUser.click();
		browser.waitUntilElementVisible(adminPage.deleteUserAlertDeleteButton);
		Assert.assertTrue(browser.isElementPresent(adminPage.deleteUserAlertDeleteButton));
	}

	*//*Disabling user
	 * log in as patient
	 * check there is access to account
	 * log out and log in as admin
	 * disable user
	 * log out and log in as patient
	 * check there is no access to account
	 * *//*
	@Test(priority = 15)
	public void testDisableUser(){
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.ml@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		browser.sleep(1);
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
		browser.selectDropdown(adminPage.searchBy,"Email");
		adminPage.search.sendKeys("patient.ml@hospitals.ua");
		adminPage.searchButton.click();
		browser.waitUntilElementIsPresent(By.id("allUsers"));
		adminPage.actionsViewUser.click();
		browser.waitUntilElementVisible(adminPage.viewUserAlertEnabledButton);
		adminPage.viewUserAlertEnabledButton.click();
		adminPage.viewUserCancelButton.click();
		browser.sleep(2);
		header.logout();
		browser.goTo(LOGIN_URL);
		loginPage.emailLogin.sendKeys("patient.ml@hospitals.ua");
		loginPage.passwordLogin.sendKeys("1111");
		loginPage.loginButton.click();
		Assert.assertTrue(browser.isElementPresent(adminPage.blockedAccount));
	}*/


}
