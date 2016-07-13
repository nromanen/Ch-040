package hospitalSeeker.googleAPI;

import hospitalSeeker.BaseTest;
import hospitalSeeker.googleApi.GooglePoiPage;
import hospitalSeeker.googleApi.NewHospitalPage;
import hospitalSeeker.pages.LoginPage;
import hospitalSeeker.templates.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestGooglePoiPage extends BaseTest {

    GooglePoiPage googlePoiPage;
    NewHospitalPage newHospitalPage;
    LoginPage loginPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        googlePoiPage = GooglePoiPage.init(browser.getDriver());
        newHospitalPage = NewHospitalPage.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browser.goTo(VALIDATE_URL);
    }

    @Test
    public void checkElementsPresent() {
        String error = browser.checkIfElementNotPresent(googlePoiPage.googleApi)
                .concat(browser.checkIfElementNotPresent(googlePoiPage.getGooglePoi))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.tables))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.addValidateHospital))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.showOnMap));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void checkButtonClickable() {
        googlePoiPage.getGooglePoi.click();
        assertTrue(browser.isElementPresent(googlePoiPage.table));
    }

    @Test
    public void checkAddingHospital() {
        googlePoiPage.getGooglePoi.click();
        browser.doubleClick(header.actionsButton);
        googlePoiPage.addValidateHospital.click();
        assertTrue(browser.isElementPresent(newHospitalPage.imagePathButton));
    }
}
