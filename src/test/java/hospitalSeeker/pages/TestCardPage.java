package hospitalSeeker.pages;

import hospitalSeeker.BaseTest;
import hospitalSeeker.DataSetUtils;
import hospitalSeeker.templates.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

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
    public void testDoctorCanEditOwnRecordAfterDay() throws ParseException {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        if (browser.getDate().after(cardPage.dateParser()))
            assertFalse(browser.isElementPresent(cardPage.editButton));
    }

    @Test
    public void testDoctorCanEditOwnRecordOnSameDay() {
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
        assertTrue(browser.containsText(browser.getStringDate()), "something gone wrong");
    }


    @Test
    public void testEmptyTextAreasInCardPage() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientCharlesDarvin.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("comp", "res", "pres");
        assertTrue(browser.containsText("min size"), "something gone wrong");
    }

}
