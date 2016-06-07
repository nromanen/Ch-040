/**
 * Created by oleg on 03.06.2016.
 */
import googleApi.NewHospital;
import googleApi.ValidateHospital;
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
        validateHospital = PageFactory.initElements(browserAction.getDriver(), ValidateHospital.class);
        newHospital = PageFactory.initElements(browserAction.getDriver(), NewHospital.class);
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * check if google api is present
	 * </p>
	 */
    @Test(priority = 0)
    public void isElementsPresent() {
        testLogin();
        browserAction.goTo(HOME_URL);
        browserAction.goTo(VALIDATE_URL);
        assertTrue(browserAction.isElementPresent(validateHospital.googleApi), "Dude, Google Api is not present");
        assertTrue(browserAction.isElementPresent(validateHospital.validateButton), "Button for validate hospital is not present");
        validateHospital.addValidateHospitalClick();
        browserAction.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital), "Button for validate hospital is not present");
    }

    @Test(dependsOnMethods = "isElementsPresent")
    public void testLogin() {
        browserAction.goTo(HOME_URL);
        newHospital.logInAction(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test(dependsOnMethods = "isElementsPresent")
    public void validateButtonClick() {
        testLogin();
        browserAction.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
    }

    @Test(dependsOnMethods = {"isElementsPresent","validateButtonClick"})
    public void addValidateHospital(){
        testLogin();
        browserAction.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital));
        validateHospital.addValidateHospitalClick();
    }

    @Test(dependsOnMethods = "addValidateHospital")
    public void  resirectToOtheUrl(){
        testLogin();
        browserAction.goTo(VALIDATE_URL);
        validateHospital.validateButtonClick();
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital));
        validateHospital.addValidateHospitalClick();
        browserAction.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       assertEquals(false, (browserAction.getCurrentUrl() == VALIDATE_URL));
    }
    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }
}
