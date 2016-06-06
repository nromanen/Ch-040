package hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestPatients extends BaseTest{
    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;
    
    private static final String USER_NAME_FOR_PATIENT = "pat12@uk.uk";
	private static final String PASSWORD_FOR_PATIENT = "pat12";
	private static final String USER_NAME_FOR_DOCTOR = "doctor@com.com";
	private static final String PASSWORD_FOR_DOCTOR = "doctor";
	

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        patientsPage = PageFactory.initElements(browserActions.getDriver(), PatientsPage.class);
        cardPage = PageFactory.initElements(browserActions.getDriver(), CardPage.class);
        newRecordPage = PageFactory.initElements(browserActions.getDriver(), NewRecordPage.class);
        loginPage = PageFactory.initElements(browserActions.getDriver(), LoginPage.class);
    }
 
   @Test (enabled = false )
   public void testIfDoctorCanEditOwnRecord(){
    	 browserActions.goTo(homeUrl);
    	 loginPage.logInAction(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
    	 browserActions.goTo(patientsUrl);
    	 
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
   
    @Test (enabled = false )
    public void testIfDoctorCanMakeNewRecord(){
    	browserActions.goTo(homeUrl);
   	 	loginPage.logInAction(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
   	 	browserActions.goTo(patientsUrl);
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
    
    @Test (enabled = false )
   	public void testEmptyTextAreasInCardPage(){
    	browserActions.goTo(homeUrl);
   	 	loginPage.logInAction(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
   	 	browserActions.goTo(patientsUrl);
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
   
    @Test (enabled = false ) 
    public void checkElementsInPatientsPage() {
    	browserActions.goTo(homeUrl);
   	 	loginPage.logInAction(USER_NAME_FOR_DOCTOR , PASSWORD_FOR_DOCTOR);
        browserActions.goTo(patientsUrl);
    	Boolean isPresent1 = patientsPage.patient2iua.isDisplayed();
    	Boolean isPresent2 = patientsPage.tutu.isDisplayed();
    	Boolean isPresent4 = patientsPage.nadja_cvmailru.isDisplayed();
    	Boolean isPresent5 = patientsPage.olegolegovich1996gmailcom.isDisplayed();
    	Boolean isPresent6 = patientsPage.archermailru.isDisplayed();
    	Boolean isPresent7 = patientsPage.nadja_cv8mailru.isDisplayed();
    }

    @AfterMethod
    public void afterMethod() {
        browserActions.driver.quit();
    }
}
