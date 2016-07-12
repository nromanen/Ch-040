package hospitalSeeker.pages;

import hospitalSeeker.*;
import hospitalSeeker.templates.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestCardPage extends BaseTest {
    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        patientsPage = PatientsPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        cardPage = CardPage.init(browser.getDriver());
        newRecordPage = NewRecordPage.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
    }

    @Test
    public void testDoctorCanEditAnotherDoctorsRecord() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_LHC_LOGIN, DOCTOR_LHC_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        assertFalse(browser.isElementPresent(cardPage.editButton));
    }

    @Test
    public void testDoctorCanEditOwnRecord() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        cardPage.dateRecordButton.click();
        cardPage.editButton.click();
        newRecordPage.clearAllFields();
        newRecordPage.createNewRecord("NEW complaint", "NEW result", "NEW prescription");
        assertTrue(browser.containsText("NEW complaint"), "something gone wrong");
    }

    @Test
    public void testDoctorCanCreateNewRecord() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        assertTrue(browser.containsText(cardPage.getDate()), "something gone wrong");
    }


    @Test
    public void testEmptyTextAreasInCardPage() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
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
        //Boolean isPresent = newRecordPage.errorString.isDisplayed();
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
        //dropdownLogin.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        browser.goTo(PATIENTS_LIST_URL);
        //Boolean isPresent1 = patientsPage.patient2iua.isDisplayed();
        //Boolean isPresent2 = patientsPage.tutu.isDisplayed();
        //Boolean isPresent4 = patientsPage.nadja_cvmailru.isDisplayed();
        //Boolean isPresent5 = patientsPage.olegolegovich1996gmailcom.isDisplayed();
        //Boolean isPresent6 = patientsPage.archermailru.isDisplayed();
        //Boolean isPresent7 = patientsPage.nadja_cv8mailru.isDisplayed();

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

    @Test()
    public void testThatDoctorCantEditRecordAfter00() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
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
        //Boolean isPresent10 = (newRecordPage.editTimeError).isDisplayed();

    }
}
