package hospitalSeeker;

//import hospitalSeeker.header.DropdownLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPatients extends BaseTest{
    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;
    //DropdownLogin dropdownLogin;

    @BeforeMethod
    public void beforeMethod() {
        patientsPage = PageFactory.initElements(browser.getDriver(), PatientsPage.class);
        cardPage = PageFactory.initElements(browser.getDriver(), CardPage.class);
        newRecordPage = PageFactory.initElements(browser.getDriver(), NewRecordPage.class);
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        //dropdownLogin = PageFactory.initElements(browser.getDriver(), DropdownLogin.class);
    }

 /* Editing Record by Doctor
  * go to home url
  * logging to site
  * go to patients url
  * click to record
  * click to patient
  * click to edit button
  * click complaint area, result area, prescription area
  * type some text in each area
  * press submit button
  */

   @Test
   public void testIfDoctorCanEditOwnRecord(){
    	 browser.goTo(HOME_URL);
    	 //dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
    	 browser.goTo(PATIENTS_LIST_URL);

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

   /* New Record by Doctor
    * go to home url
    * logging to site
    * go to patients url
    * click to patient
    * click to new Record button
    * click complaint area, result area, prescription area
    * type some text in each area
    * press submit button
    */

    @Test
    public void testIfDoctorCanMakeNewRecord(){
    	browser.goTo(HOME_URL);
    	//dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
   	 	browser.goTo(PATIENTS_LIST_URL);
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

    /* Test min text size in new Record
     * go to home url
     * logging to site
     * go to patients url
     * click to patient
     * click to new Record button
     * click complaint area, result area, prescription area
     * type short text to 5 chars in each area
     * press submit button
     * check error message
     */

    @Test
   	public void testEmptyTextAreasInCardPage(){
    	browser.goTo(HOME_URL);
    	//dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
   	 	browser.goTo(PATIENTS_LIST_URL);
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

    /* Check elements in page
     * go to home url
     * logging to site
     * go to patients url
     * check elements
     */

    @Test
    public void checkElementsInPatientsPage() {
    	browser.goTo(HOME_URL);
    	//dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browser.goTo(PATIENTS_LIST_URL);
    	Boolean isPresent1 = patientsPage.patient2iua.isDisplayed();
    	Boolean isPresent2 = patientsPage.tutu.isDisplayed();
    	Boolean isPresent4 = patientsPage.nadja_cvmailru.isDisplayed();
    	Boolean isPresent5 = patientsPage.olegolegovich1996gmailcom.isDisplayed();
    	Boolean isPresent6 = patientsPage.archermailru.isDisplayed();
    	Boolean isPresent7 = patientsPage.nadja_cv8mailru.isDisplayed();

    }

    /* Editing Record by Doctor after 00:00
     * go to home url
     * logging to site
     * go to patients url
     * click to patient
     * click to record
     * click to edit button
     * click complaint area, result area, prescription area
     * type some text in each area
     * press submit button
     * check error message
     */

    @Test ()
    public void testThatDoctorCantEditRecordAfter00 (){
    	 browser.goTo(HOME_URL);
    	 //dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
   	 	 browser.goTo(PATIENTS_LIST_URL);

   	   	 patientsPage.tutu.click();
	     cardPage.dateRecordButton.click();
	   	 cardPage.editButton.click();

	   	 newRecordPage.complaintArea.click();
	   	 newRecordPage.complaintArea.sendKeys("Well Done");

	   	 newRecordPage.resultArea.click();
	   	 newRecordPage.resultArea.sendKeys("Very Good");

	   	 newRecordPage.prescriptionArea.click();
	   	 newRecordPage.prescriptionArea.sendKeys("Almost Ok");

	   	 newRecordPage.submitButton.click();
	  	 Boolean isPresent10 = (newRecordPage.editTimeError).isDisplayed();

    }

    @AfterMethod
    public void afterMethod() {
        browser.driver.quit();
    }
}
