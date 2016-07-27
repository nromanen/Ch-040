package hospitalSeeker.pages;

import hospitalSeeker.tools.BaseTest;
import hospitalSeeker.templates.Header;
import hospitalSeeker.tools.DataSetUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdvancedRegister extends BaseTest {

    Header header;
    LoginPage loginPage;
    RegisterPage registerPage;
    AdvancedRegister advancedRegister;
    PatientsPage patientsPage;
    AdminPage adminPage;

    @BeforeMethod
    public void beforeMethod() {
        header = Header.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        advancedRegister = AdvancedRegister.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
    }

    public void searchPatient(String email) {
        patientsPage.searchPatient.sendKeys(email);
        patientsPage.searchButton.click();
        patientsPage.patientCc.click();
    }

    @Test
    public void testAdvancedRegister() {
        dataSetUtils.selectDataSet(DataSetUtils.fullDataSet);
        browser.goTo(REGISTER_URL);
        registerPage.registration("patient.cc@hospitals.ua", "Per1111", "Per1111");
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        adminPage.enableUser("patient.cc@hospitals.ua", getWrapper());
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn("patient.cc@hospitals.ua", "Per1111");
        header.goToProfile();
        browser.waitUntilElementVisible(advancedRegister.detailForm);
        advancedRegister.createProfile("Perekuta", "Nadiia", "1990-01-10", "Che", "095123456789", getWrapper());
        advancedRegister.submitChanges.click();
        advancedRegister.closeProfile.click();
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_GH_LOGIN, DOCTOR_GH_PASSWORD);
        header.patientsButton.click();
        searchPatient("patient.cc@hospitals.ua");
        Assert.assertTrue(browser.isElementPresent(patientsPage.newRecord));
    }
}
