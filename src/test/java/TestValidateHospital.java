/**
 * Created by oleg on 03.06.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class TestValidateHospital extends BaseClassTest {

    ValidateHospital validateHospital;
    NewHospital newHospital;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        validateHospital = PageFactory.initElements(browserAction.getDriver(), ValidateHospital.class);
        newHospital = PageFactory.initElements(browserAction.getDriver(), NewHospital.class);
    }



    @Test(priority = 0)
    public void isElementsPresent() {
        testLogin();
        NewHospital.navigateToLgn(browserAction.getDriver());
        ValidateHospital.navigateTo(browserAction.getDriver());

        assertTrue(browserAction.isElementPresent(validateHospital.googleApi), "Dude, Google Api is not present");
        assertTrue(browserAction.isElementPresent(validateHospital.validateButton), "Button for validate hospital is not present");
        validateHospital.addValidateHospitalClick();
        browserAction.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital), "Button for validate hospital is not present");

    }
    @Test(dependsOnMethods = "isElementsPresent")
    public void testLogin() {
        NewHospital.navigateToLgn(browserAction.getDriver());
        newHospital.logInAction("olegolegovich1996@gmail.com", "Spartak14");
    }
    @Test(dependsOnMethods = "isElementsPresent")
    public void validateButtonClick() {
        testLogin();
        ValidateHospital.navigateTo(browserAction.getDriver());
        validateHospital.validateButtonClick();
    }
    @Test(dependsOnMethods = {"isElementsPresent","validateButtonClick"})
    public void addValidateHospital(){
        testLogin();
        ValidateHospital.navigateTo(browserAction.getDriver());
        validateHospital.validateButtonClick();
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital));
        validateHospital.addValidateHospitalClick();
    }
    @Test(dependsOnMethods = "addValidateHospital")
    public void  gogoUrl(){
        testLogin();
        ValidateHospital.navigateTo(browserAction.getDriver());
        validateHospital.validateButtonClick();
        assertTrue(browserAction.isElementPresent(validateHospital.addValidateHospital));
        validateHospital.addValidateHospitalClick();
        browserAction.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       assertEquals(false, (browserAction.getCurrentUrl() == "http://91.209.24.68/ch-040/admin/map/validate"));


    }




    @AfterMethod
    public void afterMethod() {

        //testLogin();
        //newHospital.navigateTo(browserAction.getDriver());
        //hospitalList.navigateTo(browserAction.getDriver());
        browserAction.getDriver().quit();
    }
}
