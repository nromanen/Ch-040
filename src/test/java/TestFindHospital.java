/**
 * Created by oleg on 25.05.2016.
 */
import googleApi.FindHospital;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestFindHospital extends BaseTest{
    FindHospital findHospital;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        findHospital = PageFactory.initElements(browserAction.getDriver(), FindHospital.class);
    }
    /*
    *<p>
    *
	 *go to Find page
	 * check if google api is present
	 * check if input box is present
	 * @requires true
	 * @effect all elements must be present
    *     </p>
     */
    @Test
    public void isElementsPresents(){
        browserAction.goTo(FIND_URL);
        assertTrue(browserAction.isElementPresent(findHospital.enterAdress),"Input Box for Address not present lalka");
        assertTrue(browserAction.isElementPresent(findHospital.googleMap),"Input Box for Address not present lalka");
    }
    /*
        *<p>
        *
         *go to Find page
         * input address
         * @requires true
         * @effect google api 
        *     </p>
         */
    @Test(dependsOnMethods = "isElementsPresents")
    public void test() {
        browserAction.goTo(FIND_URL);
        findHospital.findInAction("Chernivtsi");
    }
    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }
}
