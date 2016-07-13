package hospitalSeeker.pages;

import bsh.ParseException;
import hospitalSeeker.BaseTest;
import hospitalSeeker.BrowserWrapper;
import hospitalSeeker.DataSetUtils;
import hospitalSeeker.templates.Header;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCardPage extends BaseTest {

    PatientsPage patientsPage;
    CardPage cardPage;
    NewRecordPage newRecordPage;
    LoginPage loginPage;
    Header header;
    BrowserWrapper browserWrapper;
    RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        patientsPage = PatientsPage.init(browser.getDriver());
        cardPage = CardPage.init(browser.getDriver());
        newRecordPage = NewRecordPage.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
    }

    @Test
    public void checkPatientsSearch() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();

        patientsPage.searchField.click();
        patientsPage.searchField.sendKeys("patient.sf@hospitals.ua");
        patientsPage.submitButton.click();
        Assert.assertTrue(browser.isElementPresent(patientsPage.patientsf));
    }

    @Test
    public void testPatientsSortingByEmail() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.sortButtonByEmail.click();
        String first_patient_after_sort = browser.getDataFromTable(1, 2);
        Assert.assertEquals(first_patient_after_sort, "patient.cd@hospitals.ua");
    }

    @Test
    public void testPatientsSortingByFirstName() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.sortButtonByFirstName.click();
        String first_patient_after_sort = browser.getDataFromTable(1, 3);
        Assert.assertEquals(first_patient_after_sort, "Charles");
    }

    @Test
    public void testPatientsSortingByLastName() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.sortButtonByLastName.click();
        String first_patient_after_sort = browser.getDataFromTable(1, 4);
        Assert.assertEquals(first_patient_after_sort, "Darvin");
    }

    @Test
    public void testFullName() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        String patient_first_name = browser.getDataFromTable(1, 3);
        String patient_last_name = browser.getDataFromTable(1, 4);
        String f_name = patient_first_name + " " + patient_last_name;
        patientsPage.patientsf.click();
        String patient_full_name = cardPage.profileButton.getText();
        Assert.assertEquals(patient_full_name, f_name.toUpperCase());
    }

    @Test
    public void checkTextOfDoctorsRecords() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
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
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        header.cardButton.click();

        cardPage.dateRecordButton.click();

        Assert.assertEquals(cardPage.cArea.getText(), str);
        Assert.assertEquals(cardPage.pArea.getText(), str1);
        Assert.assertEquals(cardPage.rArea.getText(), str2);
    }

    @Test
    public void testCurentDate() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientsf.click();
        cardPage.newRecordButton.click();
        String strDate = new SimpleDateFormat("HH:mm dd-MM-yyyy").format(new Date());
        String fulStr = new String("Current date: ".concat(strDate));
        Assert.assertEquals(newRecordPage.currentDate.getText(), fulStr);
    }

    @Test
    public void testComplaintAreaError() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();

        newRecordPage.complaintArea.click();
        newRecordPage.complaintArea.sendKeys("111");

        newRecordPage.submitButton.click();
        Assert.assertTrue(newRecordPage.cError.isDisplayed());
    }

    @Test
    public void testResultAreaError() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();

        newRecordPage.resultArea.click();
        newRecordPage.resultArea.sendKeys("111");

        newRecordPage.submitButton.click();
        Assert.assertTrue(newRecordPage.rError.isDisplayed());
    }

    @Test
    public void testPrescriptionAreaError() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();

        newRecordPage.prescriptionArea.click();
        newRecordPage.prescriptionArea.sendKeys("111");

        newRecordPage.submitButton.click();
        Assert.assertTrue(newRecordPage.pError.isDisplayed());
    }

    @Test
    public void testDoctorCanEditAnotherDoctorsRecord() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_LHC_LOGIN, DOCTOR_LHC_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        Assert.assertFalse(browser.isElementPresent(cardPage.editButton));
    }

    @Test
    public void testDoctorCanEditOwnRecordAfterDay() throws ParseException, java.text.ParseException {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        if (browser.getDate().after(cardPage.dateParser()))
            Assert.assertFalse(browser.isElementPresent(cardPage.editButton));
    }

    @Test
    public void testDoctorCanEditOwnRecordOnSameDay() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        cardPage.dateRecordButton.click();
        cardPage.editButton.click();
        newRecordPage.clearAllFields();
        newRecordPage.createNewRecord("NEW complaint", "NEW result", "NEW prescription");
        Assert.assertTrue(browser.containsText("NEW complaint"), "something gone wrong");
    }

    @Test
    public void testDoctorCanCreateNewRecord2() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("complaint", "result", "prescription");
        Assert.assertTrue(browser.containsText(browser.getStringDate()), "something gone wrong");
    }


    @Test
    public void testEmptyTextAreasInCardPage2() {
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        patientsPage.patientcd.click();
        cardPage.newRecordButton.click();
        newRecordPage.createNewRecord("comp", "res", "pres");
        Assert.assertTrue(browser.containsText("min size"), "something gone wrong");
    }

}
