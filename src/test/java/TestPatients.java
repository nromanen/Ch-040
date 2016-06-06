

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPatients extends BaseTest{
    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        patientsPage = PageFactory.initElements(browserAction.getDriver(), PatientsPage.class);
        cardPage = PageFactory.initElements(browserAction.getDriver(), CardPage.class);
        newRecordPage = PageFactory.initElements(browserAction.getDriver(), NewRecordPage.class);
        loginPage = PageFactory.initElements(browserAction.getDriver(), LoginPage.class);
    }
 
   @Test 
   public void testIfDoctorCanEditOwnRecord(){
    	 browserAction.goTo(HOME_URL);
    	 loginPage.loggingIn(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
    	 browserAction.goTo(PATIENTS_URL);
    	 
    	 patientsPage.tutu.click();
    	 cardPage.dateRecordButton.click();
    	 cardPage.editButton.click();
    	 
    	 newRecordPage.complaintArea.click();
    	 String compArea = new String(newRecordPage.complaintArea.getAttribute("value"));
    	 newRecordPage.complaintArea.sendKeys("Well Done");
    	 newRecordPage.complaintArea.clear();
    	 newRecordPage.complaintArea.sendKeys(compArea);
    	 
    	 newRecordPage.resultArea.click();
    	 String resArea = new String(newRecordPage.resultArea.getAttribute("value"));
    	 newRecordPage.resultArea.sendKeys("Very Good");
    	 newRecordPage.resultArea.clear();
    	 newRecordPage.resultArea.sendKeys(resArea);
    	 
    	 newRecordPage.prescriptionArea.click();
    	 String preArea = new String(newRecordPage.prescriptionArea.getAttribute("value"));
    	 newRecordPage.prescriptionArea.sendKeys("Almost Ok");
    	 newRecordPage.prescriptionArea.clear();
    	 newRecordPage.prescriptionArea.sendKeys(preArea);
    	 
    	 newRecordPage.submitButton.click();
   }
   
    @Test 
    public void testIfDoctorCanMakeNewRecord(){
    	browserAction.goTo(HOME_URL);
   	 	loginPage.loggingIn(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
   	 	browserAction.goTo(PATIENTS_URL);
   	 	patientsPage.tutu.click();
   	 	cardPage.newRecordButton.click();
   	 	
   	 	newRecordPage.complaintArea.click();
   	 	newRecordPage.complaintArea.sendKeys("11kkkkkk11");
   	 	
   	 	newRecordPage.resultArea.click();
   	 	newRecordPage.resultArea.sendKeys("12llll12");
   	 	
   	 	newRecordPage.prescriptionArea.click();
   	 	newRecordPage.prescriptionArea.sendKeys("13jjjjj13");
   	 	
   	 	newRecordPage.submitButton.click();	
    }
    
    @Test 
   	public void testEmptyTextAreasInCardPage(){
    	browserAction.goTo(HOME_URL);
   	 	loginPage.loggingIn(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
   	 	browserAction.goTo(PATIENTS_URL);
   	 	patientsPage.tutu.click();
   	 	cardPage.newRecordButton.click();
   	 	
   	 	newRecordPage.complaintArea.click();
	 	newRecordPage.complaintArea.sendKeys("111");
	 	
	 	newRecordPage.resultArea.click();
	 	newRecordPage.resultArea.sendKeys("111");
	 	
	 	newRecordPage.prescriptionArea.click();
	 	newRecordPage.prescriptionArea.sendKeys("111");
	 	
	 	newRecordPage.submitButton.click();	
	 	Boolean isPresent = newRecordPage.errorString.isDisplayed();
   		}
   
    @Test 
    public void checkElementsInPatientsPage() {
    	browserAction.goTo(HOME_URL);
   	 	loginPage.loggingIn(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
        browserAction.goTo(PATIENTS_URL);
    	Boolean isPresent1 = patientsPage.patient2iua.isDisplayed();
    	Boolean isPresent2 = patientsPage.tutu.isDisplayed();
    	Boolean isPresent4 = patientsPage.nadja_cvmailru.isDisplayed();
    	Boolean isPresent5 = patientsPage.olegolegovich1996gmailcom.isDisplayed();
    	Boolean isPresent6 = patientsPage.archermailru.isDisplayed();
    	Boolean isPresent7 = patientsPage.nadja_cv8mailru.isDisplayed();
    }

    @AfterMethod
    public void afterMethod() {
        browserAction.driver.quit();
    }
}
