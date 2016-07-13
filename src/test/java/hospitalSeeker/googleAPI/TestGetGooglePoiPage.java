package hospitalSeeker.googleAPI;

import hospitalSeeker.BaseTest;
import hospitalSeeker.Header;
import hospitalSeeker.LoginPage;
import hospitalSeeker.googleApi.NewHospital;
import hospitalSeeker.googleApi.GooglePoiPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class TestGetGooglePoiPage extends BaseTest {

    GooglePoiPage googlePoiPage;
    NewHospital newHospital;
    LoginPage loginPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        googlePoiPage = GooglePoiPage.init(browser.getDriver());
        newHospital = NewHospital.init(browser.getDriver());
        loginPage =LoginPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN,ADMIN_PASSWORD);
        browser.goTo(VALIDATE_URL);
    }

    @Test(priority = 0)
    public void checkElementsPresent() {
        String error = browser.checkIfElementNotPresent(googlePoiPage.googleApi)
                .concat(browser.checkIfElementNotPresent(googlePoiPage.getGooglePoi))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.tables))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.addValidateHospital))
                .concat(browser.checkIfElementNotPresent(googlePoiPage.showOnMap));
        System.out.println(error);
    }

	/* go to login page
	 * log in
	 * goto validate url
	 * click on "get google poi" button
	 * check if table is present
     */
    @Test(priority = 1)
    public void checkButtonClickable() {
        googlePoiPage.getGooglePoi.click();
        assertTrue(browser.isElementPresent(googlePoiPage.table));
    }

    /* go to login page
	 * log in
	 * goto validate url
	 * click on "get google poi" button
	 * click addHospital
     * checking if redirected on addHpspitalPage
     */
    @Test(priority = 2)
    public void checkAddingHospital(){
        googlePoiPage.getGooglePoi.click();
        browser.doubleClick(header.actionsButton);
        googlePoiPage.addValidateHospital.click();
        assertTrue(browser.isElementPresent(newHospital.imagePathButton));
    }
}
