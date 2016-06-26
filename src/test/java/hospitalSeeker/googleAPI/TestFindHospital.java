package hospitalSeeker.googleAPI; /**
 * Created by oleg on 25.05.2016.
 */

import hospitalSeeker.BaseTest;
import hospitalSeeker.googleApi.FindHospital;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestFindHospital extends BaseTest {
    FindHospital findHospital;

    @BeforeMethod
    public void beforeMethod() {
        findHospital = PageFactory.initElements(browser.getDriver(), FindHospital.class);
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
        browser.goTo(FIND_URL);
        assertTrue(browser.isElementPresent(findHospital.enterAdress),"Input Box for Address not present lalka");
        assertTrue(browser.isElementPresent(findHospital.googleMap),"Input Box for Address not present lalka");
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
    @Test
    public void test() {
        browser.goTo(FIND_URL);
        findHospital.findInAction("Chernivtsi");
        findHospital.enterAdress.sendKeys(Keys.RETURN);
    }
}
