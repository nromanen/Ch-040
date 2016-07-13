package hospitalSeeker.googleAPI;

import hospitalSeeker.BaseTest;
import hospitalSeeker.googleApi.NewHospitalPage;
import hospitalSeeker.pages.LoginPage;
import hospitalSeeker.templates.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNewHospitalPage extends BaseTest {
    public NewHospitalPage newHospitalPage;
    public LoginPage loginPage;
    public Header header;

    @BeforeMethod
    public void beforeMethod() {
        newHospitalPage = NewHospitalPage.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
    }

    @Test
    public void testNewHospitalPageElementsPresence() {
        String error = browser.checkIfElementNotPresent(header.actionsButton)
                .concat(browser.checkIfElementNotPresent(header.newHospitalButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.googleMap))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.addressField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.descriptionField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.nameField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.longitudeField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.latitudeField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.saveButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.backButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.resetButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.buildingField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.countryField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.cityField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.imagePathButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.streetField))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.fillButton))
                .concat(browser.checkIfElementNotPresent(newHospitalPage.findButton));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }

    @Test
    public void testValidationError() {
        newHospitalPage.saveButton.click();
        newHospitalPage.fillButton.click();
        assertTrue(newHospitalPage.errorCountryField.isDisplayed() &&
                newHospitalPage.errorNameField.isDisplayed() &&
                newHospitalPage.errorCityField.isDisplayed() &&
                newHospitalPage.errorLatitudeField.isDisplayed() &&
                newHospitalPage.errorLongitudeField.isDisplayed(), "element isn't present");
    }

    @Test
    public void testAddingNewHospital() {
        newHospitalPage.addNewHospital();
        newHospitalPage.saveButton.click();
        assertTrue(browser.containsText(NewHospitalPage.testName));
    }

    @Test
    public void testResetButton() {
        newHospitalPage.addNewHospital();
        newHospitalPage.resetButton.click();
        assertTrue(newHospitalPage.cityField.getAttribute("value").equals("") &&
                newHospitalPage.countryField.getAttribute("value").equals("") &&
                newHospitalPage.buildingField.getAttribute("value").equals("") &&
                newHospitalPage.streetField.getAttribute("value").equals("") &&
                newHospitalPage.nameField.getAttribute("value").equals("") &&
                newHospitalPage.descriptionField.getAttribute("value").equals(""));
    }

    @Test
    public void testBackButton() {
        newHospitalPage.backButton.click();
        assertEquals(browser.getCurrentUrl(), ADMIN_DASHBOARD_URL, "backButton doesn't work");
    }
}
