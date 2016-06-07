/**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    @Test(priority = 0)
    public void isElementPresent(){
        testLogin();
        NewHospital.navigateToLgn(browserAction.getDriver());
        NewHospital.navigateTo(browserAction.getDriver());
        assertTrue(browserAction.isElementPresent(newHospital.googleMap),"element googleMap isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.descriptionField),"input element description isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.nameField),"input element description isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.longitudeField),"element isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.latitudeField),"element isn't present");
        assertTrue(browserAction.isElementPresent(newHospital.submitButton),"element isn't present");
    }

    @Test(dependsOnMethods = "isElementPresent")
    public void testLogin(){
        NewHospital.navigateToLgn(browserAction.getDriver());
        newHospital.logInAction(ADMIN_LOGIN,ADMIN_PASSWORD);
    }
    @Test(dependsOnMethods = "isElementPresent")
    public void testGoogleApi(){
        testLogin();
        NewHospital.navigateTo(browserAction.getDriver());
        assertTrue(newHospital.googleMap.isDisplayed(),"element googleMap isn't present");
    }
    @Test(dependsOnMethods = "isElementPresent")
    public void validationError(){
        testLogin();
        NewHospital.navigateTo(browserAction.getDriver());
        newHospital.submitButton.click();
        assertTrue(newHospital.errorField.isDisplayed(),"element isn't present");
    }

    @Test(dependsOnMethods = "isElementPresent")
    public void testClick(){
        testLogin();
        NewHospital.navigateTo(browserAction.getDriver());
        newHospital.submitButton.click();
    }
    @Test(dependsOnMethods = "isElementPresent")
    public void addNewHospital(){
        testLogin();
        newHospital.navigateTo(browserAction.getDriver());
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
