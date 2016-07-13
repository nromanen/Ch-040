package hospitalSeeker.pages;

import hospitalSeeker.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCardPage extends BaseTest {
	
    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;
    HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
    		patientsPage = PatientsPage.init(browser.getDriver());
    		cardPage = CardPage.init(browser.getDriver());
    		newRecordPage = NewRecordPage.init(browser.getDriver());
    		loginPage = LoginPage.init(browser.getDriver());
    		headerPage = HeaderPage.init(browser.getDriver());
    }

    @Test 
   	public void testEmptyTextAreasInCardPage(){
    	browser.goTo(LOGIN_URL);
	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
	    browser.goTo(PATIENTS_LIST_URL);
	 	patientsPage.patientsf.click();
   	cardPage.newRecordButton.click();
   	 	
   	newRecordPage.complaintArea.click();
	 	newRecordPage.complaintArea.sendKeys("111");
	 	
	 	newRecordPage.resultArea.click();
	 	newRecordPage.resultArea.sendKeys("111");
	 	
	 	newRecordPage.prescriptionArea.click();
	 	newRecordPage.prescriptionArea.sendKeys("111");
	 	
	 	newRecordPage.submitButton.click();	
	 	Assert.assertTrue(browser.isElementPresent(newRecordPage.cError));
	 	Assert.assertTrue(browser.isElementPresent(newRecordPage.pError));
	 	Assert.assertTrue(browser.isElementPresent(newRecordPage.rError));
   		}
    
    @Test
    public void checkPatientsSearch(){
    	browser.goTo(LOGIN_URL);
	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
	    browser.goTo(PATIENTS_LIST_URL);
	    
	    patientsPage.searchField.click();
	    patientsPage.searchField.sendKeys("patient.sf@hospitals.ua");
	    patientsPage.submitButton.click();
	    Assert.assertTrue(browser.isElementPresent(patientsPage.patientsf));
	    
	    patientsPage.searchField.click();
	    patientsPage.searchField.sendKeys("patient.rr@hospitals.ua");
	    patientsPage.submitButton.click();
	    Assert.assertTrue(browser.isElementPresent(patientsPage.patientrr));
    }
    
//    @Test
//    public void testPatientsSortingByEmail (){
//    	browser.goTo(LOGIN_URL);
//	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
//	    browser.goTo(PATIENTS_LIST_URL);
//	    patientsPage.sortButtonByEmail.click();
//	    String first_patient_after_sort =  getTableData(PATIENT_TABLE_XPATH_FOR_ROWS, PATIENT_TABLE_XPATH_FOR_COLUMNS, 0, 1);
//	    Assert.assertEquals(first_patient_after_sort, "patient.cd@hospitals.ua"); 
//    }
//    
//    @Test
//    public void testPatientsSortingByFirstName (){
//    	browser.goTo(LOGIN_URL);
//	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
//	    browser.goTo(PATIENTS_LIST_URL);
//	    patientsPage.sortButtonByFirstName.click();
//	    String first_patient_after_sort =  getTableData(PATIENT_TABLE_XPATH_FOR_ROWS, PATIENT_TABLE_XPATH_FOR_COLUMNS, 0, 2);
//	    Assert.assertEquals(first_patient_after_sort, "Charles"); 
//    }
//    
//    @Test
//    public void testPatientsSortingByLastName (){
//    	browser.goTo(LOGIN_URL);
//	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
//	    browser.goTo(PATIENTS_LIST_URL);
//	    patientsPage.sortButtonByLastName.click();
//	    String first_patient_after_sort =  getTableData(PATIENT_TABLE_XPATH_FOR_ROWS, PATIENT_TABLE_XPATH_FOR_COLUMNS, 0, 3);
//	    Assert.assertEquals(first_patient_after_sort, "Darvin"); 
//    }
    
//    @Test
//    public void testWorkNextPageButton (){
//    	browser.goTo(LOGIN_URL);
//	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
//	    browser.goTo(PATIENTS_LIST_URL);
//	    patientsPage.secondPage.click();
//	    String url = browser.getDriver().getCurrentUrl();
//	    Assert.assertEquals(url, "https://localhost:8443/HospitalSeeker/patients?page=2&order=false&sortBy=firstName");
//    }
    
//    @Test
//    public void testFullName (){
//    	browser.goTo(LOGIN_URL);
//    	loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
//    	browser.goTo(PATIENTS_LIST_URL);
//    /	String patient_first_name = getTableData(PATIENT_TABLE_XPATH_FOR_ROWS, PATIENT_TABLE_XPATH_FOR_COLUMNS, 0, 2);
//    //	String patient_last_name = getTableData(PATIENT_TABLE_XPATH_FOR_ROWS, PATIENT_TABLE_XPATH_FOR_COLUMNS, 0, 3);
//    	String f_name = patient_first_name + " " + patient_last_name;
//    	patientsPage.patientsf.click();
//    	String patient_full_name = cardPage.profileButton.getText();
//    	Assert.assertEquals(patient_full_name, f_name.toUpperCase());
//    	}
    
//      @Test // To do
//      public void testSortingAppoinmentsByDate (){
//      	browser.goTo(LOGIN_URL);
//      	loginPage.loggingIn(PATIENT_LOGIN,PATIENT_PASSWORD);
//      	browser.goTo(CARD_URL);
//      	String date1 = cardPage.record1.getText();
//      	String date2 = cardPage.record2.getText();
//      	System.out.println(date1);
//      	System.out.println(date2);
//      }
    
    @Test
    public void checkTextOfDoctorsRecords (){
    	browser.goTo(LOGIN_URL);
    	loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
    	browser.goTo(PATIENTS_LIST_URL);
    	patientsPage.patientcd.click();
    	cardPage.newRecordButton.click();
    	
    	newRecordPage.complaintArea.click();
    	String str = new String("11kkkkkk11");
	 	newRecordPage.complaintArea.sendKeys(str);
	 	
	 	newRecordPage.prescriptionArea.click();
    	String str1 = new String("11kkkkkk11");
	 	newRecordPage.prescriptionArea.sendKeys(str1);
	 	
	 	newRecordPage.resultArea.click();
    	String str2 = new String("11kkkkkk11");
	 	newRecordPage.resultArea.sendKeys(str2);
	 	
	 	newRecordPage.submitButton.click();
	 	patientsPage.doctorLink.click();
	 	patientsPage.logoutButton.click();
	 	
	 	browser.goTo(LOGIN_URL);
	 	loginPage.loggingIn(PATIENT_LOGIN,PATIENT_PASSWORD);
	 	browser.goTo("https://localhost:8443/HospitalSeeker/card");
	 	
	 	cardPage.dateRecordButton.click();
	 	
	 	Assert.assertEquals(cardPage.cArea.getText(), str);
	 	Assert.assertEquals(cardPage.pArea.getText(), str1);
	 	Assert.assertEquals(cardPage.rArea.getText(), str2);
    }
    
    @Test
    public void testCurentDate (){
    	browser.goTo(LOGIN_URL);
	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
	    browser.goTo(PATIENTS_LIST_URL);
	    patientsPage.patientsf.click();
	 	cardPage.newRecordButton.click();
	 	String strDate = new SimpleDateFormat("HH:mm dd-MM-yyyy").format(new Date());
	 	String fulStr = new String ("Current date: ".concat(strDate));
	 	Assert.assertEquals(newRecordPage.currentDate.getText(), fulStr);
    }
    
  @Test 
  public void testComplaintAreaError(){
  	browser.goTo(LOGIN_URL);
 	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
 	    browser.goTo(PATIENTS_LIST_URL);
 	 	patientsPage.patientcd.click();
 	 	cardPage.newRecordButton.click();
 	 	
 	 	newRecordPage.complaintArea.click();
 	 	newRecordPage.complaintArea.sendKeys("111");
 	 	
 	 	newRecordPage.submitButton.click();	
 	 	Assert.assertTrue(newRecordPage.cError.isDisplayed());
    }
  
  @Test 
  public void testResultAreaError(){
  		browser.goTo(LOGIN_URL);
 	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
 	    browser.goTo(PATIENTS_LIST_URL);
 	 	patientsPage.patientcd.click();
 	 	cardPage.newRecordButton.click();
 	 	
 	 	newRecordPage.resultArea.click();
 	 	newRecordPage.resultArea.sendKeys("111");
 	 	
 	 	newRecordPage.submitButton.click();	
 	 	Assert.assertTrue(newRecordPage.rError.isDisplayed());
    }
  
  @Test 
  public void testPrescriptionAreaError(){
  	browser.goTo(LOGIN_URL);
 	    loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
 	    browser.goTo(PATIENTS_LIST_URL);
 	 	patientsPage.patientcd.click();
 	 	cardPage.newRecordButton.click();
 	 	
 	 	newRecordPage.prescriptionArea.click();
 	 	newRecordPage.prescriptionArea.sendKeys("111");
 	 	
 	 	newRecordPage.submitButton.click();	
 	 	Assert.assertTrue(newRecordPage.pError.isDisplayed());
    }
    }

