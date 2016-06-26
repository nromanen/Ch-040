package hospitalSeeker; /**
 * Created by oleg on 25.05.2016.
 */

import hospitalSeeker.googleApi.NewHospital;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNewHospital extends BaseTest{
    NewHospital newHospital;
    LoginPage loginPage;
    String testAddress = "Головна вулиця, 239, Чернівці, Чернівецька область, Украина";
    @BeforeMethod
    public void beforeMethod() {
        newHospital = PageFactory.initElements(browser.getDriver(), NewHospital.class);
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        browser.goTo(LOGIN_URL);
        loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
        loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
        loginPage.loginButton.click();
        browser.goTo(ADDING_NEW_HOSPITAL_URL);
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * go to new hospital page
	 * check if google api present
	 * check if description field is present
	 * check if name field is present
	 * check if address field is present
	 * check if longitude field is present
	 * check if latitude field is present
	 * check if submitButton field is present
	 * @requires true
	 * @effects check all page elements

    *     </p>
     */
    @Test(priority = 0)
    public void isElementPresent(){
        assertTrue(browser.isElementPresent(newHospital.googleMap),"element googleMap isn't present");
        assertTrue(browser.isElementPresent(newHospital.addresField),"element addres isn't present");
        assertTrue(browser.isElementPresent(newHospital.descriptionField),"input element description isn't present");
        assertTrue(browser.isElementPresent(newHospital.nameField),"input element description isn't present");
        assertTrue(browser.isElementPresent(newHospital.longitudeField),"element longitudeField isn't present");
        assertTrue(browser.isElementPresent(newHospital.latitudeField),"element  latitudeField isn't present");
        assertTrue(browser.isElementPresent(newHospital.submitButton),"element submitButton isn't present");
        assertTrue(browser.isElementPresent(newHospital.backButton),"element  backButton isn't present");
        assertTrue(browser.isElementPresent(newHospital.resetButton),"element  resetButton isn't present");
        assertTrue(browser.isElementPresent(newHospital.buildingField),"element buildingField isn't present");
        assertTrue(browser.isElementPresent(newHospital.countryField),"element countryField isn't present");
        assertTrue(browser.isElementPresent(newHospital.cityField),"element cityField isn't present");
        assertTrue(browser.isElementPresent(newHospital.imagePathButton),"element imagePathButton isn't present");
        assertTrue(browser.isElementPresent(newHospital.streetField),"element streetField isn't present");
        assertTrue(browser.isElementPresent(newHospital.fillButton),"element fillButton isn't present");
        assertTrue(browser.isElementPresent(newHospital.findButton),"element findButton isn't present");

    }

    /*
    *<p>
    *     * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
    *     go to new hospital page
    *     click on button "Save"
    *     @requires true
    *     @effect visible error field
    *     </p>
     */
    @Test
    public void validationError(){
        newHospital.submitButton.click();
        newHospital.fillButton.click();
        assertTrue(newHospital.errorField.isDisplayed(),"element isn't present");
        assertTrue(newHospital.errorAddressField.isDisplayed(),"element isn't present");
        assertTrue(newHospital.errorCityField.isDisplayed(),"element isn't present");
        assertTrue(newHospital.errorLatitudeField.isDisplayed(),"element isn't present");
        assertTrue(newHospital.errorLongitudeField.isDisplayed(),"element isn't present");
    }

    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * go to validate hospital page
	 * check if isElementPresent true
	 * input address
	 * wait for 4 seconds
	 * input description
	 * input name
	 * input longitude
	 * input latitude
	 * click on imageButton
	 * click submitButton
	 * wait for 4 seconds
	 * check if confirm box present
	 * @requires confirm
	 * @effects new hospital add

    *     </p>
     */
    @Test
    public void addNewHospital(){
        newHospital.inputAddress(testAddress);
        newHospital.findButton.click();
        newHospital.fillButton.click();
        newHospital.inputName("OlegHospital");
        newHospital.inputDecsription("ololooloololol");
        newHospital.inputLon("180");
        newHospital.inputLat("180");
        newHospital.imagePathButton.click();
        newHospital.submitButton.click();
        assertEquals(true, (browser.getCurrentUrl() == HOSPITALS_URL));
    }
    @Test
    public void resetAllFields(){
        newHospital.inputAddress(testAddress);
        newHospital.findButton.click();
        newHospital.fillButton.click();
        newHospital.inputName("OlegHospital");
        newHospital.inputDecsription("ololooloololol");
        newHospital.inputLon("180");
        newHospital.inputLat("180");
        newHospital.imagePathButton.click();
        newHospital.resetButton.click();
        System.out.println("oleg" + newHospital.descriptionField.getText()+"oleg");
        assertEquals(false,newHospital.cityField.getAttribute("value") == " ");
        assertEquals(false,newHospital.countryField.getText() == " ");
        assertEquals(false,newHospital.buildingField.getAttribute("value") == " ");
        assertEquals(false,newHospital.streetField.getAttribute("value") == " ");
        assertEquals(false,newHospital.nameField.getAttribute("value") == " ");
        assertEquals(false,newHospital.descriptionField.getAttribute("value") == " ");
}
    @Test
    public void testBackButton(){
        newHospital.backButton.click();
        assertEquals(true, (browser.getCurrentUrl() != browser.getCurrentUrl()));

    }
}
