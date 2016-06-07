/**
 * Created by oleg on 25.05.2016.
 */
import googleApi.NewHospital;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestNewHospital extends BaseTest{
    NewHospital newHospital;
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        newHospital = PageFactory.initElements(browserAction.getDriver(), NewHospital.class);
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
        testLogin();
        browserAction.goTo(NEW_HOSPITAL_URL);

        assertTrue(browserAction.isElementPresent(newHospital.googleMap),"element googleMap isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.addresField),"element addres isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.descriptionField),"input element description isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.nameField),"input element description isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.longitudeField),"element isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.latitudeField),"element isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.submitButton),"element isn't present");
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
    *     </p>
     */
    @Test(dependsOnMethods = "isElementPresent")
    public void testLogin(){
        browserAction.goTo(HOME_URL);
        newHospital.logInAction(ADMIN_LOGIN,ADMIN_PASSWORD);
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
    @Test(dependsOnMethods = {"isElementPresent","testClick"})
    public void validationError(){
        testLogin();
        browserAction.goTo(NEW_HOSPITAL_URL);
        newHospital.submitButton.click();
        assertTrue(newHospital.errorField.isDisplayed(),"element isn't present");
    }
    /*
   *<p>
   * go to login page
	* input e-mail
    * input password
	 * click on button "Log in"
   *     go to new hospital page
   *     click on button "Save"
   *     @requires wait any actions
   *     @effect clickable button
   *     </p>
    */
    @Test(dependsOnMethods = "isElementPresent")
    public void testClick(){
        testLogin();
        browserAction.goTo(NEW_HOSPITAL_URL);
        newHospital.submitButton.click();
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * go to new hospital page
	 * check if isElementPresent true
	 * input address
	 * wait for 4 seconds
	 * input description
	 * input name
	 * input longitude
	 * input latitude
	 * click submitButton
	 * wait for 4 seconds
	 * check if confirm box present
	 * @requires true
	 * @effects check all page elements

    *     </p>
     */
    @Test(dependsOnMethods = "isElementPresent")
    public void addNewHospital(){
        testLogin();
        browserAction.goTo(NEW_HOSPITAL_URL);
        newHospital.inputAddress("Chernivtsi");
        browserAction.getDriver().manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        newHospital.inputName("OlegHospital");
        newHospital.inputDecsription("ololooloololol");
        newHospital.inputLon("180");
        newHospital.inputLat("180");
        newHospital.submitButton.click();
        browserAction.getDriver().manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        assertTrue(browserAction.isElementPresent(newHospital.confirmBox),"confirm box not displayed");
    }
    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
}

}
