package hospitalSeeker.pages;

import hospitalSeeker.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Надежда on 12.07.2016.
 */
public class TestAdvancedRegister extends BaseTest{

    Header header;
    LoginPage loginPage;
    RegisterPage registerPage;
    AdvancedRegister advancedRegister;
    PatientsPage patientsPage;

    @BeforeMethod
    public void beforeMethod() {
        header = Header.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        advancedRegister = AdvancedRegister.init(browser.getDriver());
    }

    public void searchPatient(String email){
        patientsPage.searchPatient.sendKeys(email);
        patientsPage.searchButton.click();
        patientsPage.patientCc.click();
    }

    @Test
    public void testAdvancedRegister(){
        browser.goTo(REGISTER_URL);
        registerPage.registration("patient.cc@hospitals.ua","Per1111","Per1111");
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn("patient.cc@hospitals.ua","Per1111");
        header.goToProfile();
        browser.waitUntilElementVisible(advancedRegister.detailForm);
        advancedRegister.createProfile("Perekuta","Nadiia","1990-01-10","Che","095123456789",getWrapper());
        advancedRegister.submitChanges.click();
        advancedRegister.closeProfile.click();
        header.logout();
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(DOCTOR_LOGIN,DOCTOR_PASSWORD);
        header.patientsButton.click();
        searchPatient("patient.cc@hospitals.ua");
        Assert.assertTrue(browser.isElementPresent(patientsPage.newRecord));
    }
}
