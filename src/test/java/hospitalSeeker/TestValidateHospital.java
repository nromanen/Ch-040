package hospitalSeeker; /**
 * Created by oleg on 03.06.2016.
 */
import hospitalSeeker.googleApi.NewHospital;
import hospitalSeeker.googleApi.ValidateHospital;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class TestValidateHospital extends BaseTest {

    ValidateHospital validateHospital;
    NewHospital newHospital;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        validateHospital = PageFactory.initElements(browser.getDriver(), ValidateHospital.class);
        newHospital = PageFactory.initElements(browser.getDriver(), NewHospital.class);
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * go to validate url
	 * check if google api is present
	 * check if "validate" button is present
	 * click "validate" button
	 * wait for 4 seconds
	 * check if add button is present
	 * @requires true
	 * @effects all elements must be present
	 * </p>
	 */
    @Test(priority = 0)
    public void isElementsPresent() {
        testLogin();
        browser.goTo(HOME_URL);
        browser.goTo(VALIDATE_URL);
        assertTrue(browser.isElementPresent(validateHospital.googleApi), "Dude, Google Api is not present");
        assertTrue(browser.isElementPresent(validateHospital.validateButton), "Button for validate hospital is not present");
        validateHospital.addValidateHospitalClick();
        browser.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertTrue(browser.isElementPresent(validateHospital.addValidateHospital), "Button for addvalidate hospital is not present");
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * * @requires true
	 * @effects Log in
    *     </p>
     */
    @Test(dependsOnMethods = "isElementsPresent")
    public void testLogin() {
        browser.goTo(HOME_URL);
        newHospital.logInAction(ADMIN_LOGIN, ADMIN_PASSWORD);
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 *  @requires true
	 * @effects button must be clickable
    *     </p>
     */
    @Test(dependsOnMethods = "isElementsPresent")
    public void validateButtonClick() {
        testLogin();
        browser.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 * wait for 4 second
	 * click addHospital
	 *  @requires true
	 * @effects button must be clickable
	 *
    *     </p>
     */
    @Test(dependsOnMethods = {"isElementsPresent","validateButtonClick"})
    public void addValidateHospital(){
        testLogin();
        browser.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
        browser.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        validateHospital.addValidateHospitalClick();
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 * wait for 4 second
	 * click addHospital
	 *  * wait for 4 second
	 *  check if page url has been changed
	 *  @requires true
	 * @effects Page url has been changed
	 *
    *     </p>
     */
    @Test(dependsOnMethods = "addValidateHospital")
    public void  resirectToOtheUrl(){
        testLogin();
        browser.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
        assertTrue(browser.isElementPresent(validateHospital.addValidateHospital));
        validateHospital.addValidateHospitalClick();
        browser.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       assertEquals(false, (browser.getCurrentUrl() == VALIDATE_URL));
    }
    @AfterMethod
    public void afterMethod() {
        browser.getDriver().quit();
    }
}
