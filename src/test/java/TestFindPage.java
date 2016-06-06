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

public class TestFindPage extends BaseClassTest{
    FindPage findPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        findPage = PageFactory.initElements(browserAction.getDriver(), FindPage.class);
    }
    @Test
    public void isElementsPresents(){
        FindPage.navigateTo(browserAction.getDriver());
       // assertTrue(browserAction.isElementPresent(findPage.googleMap),"Google Map not present in the page");
        assertTrue(browserAction.isElementPresent(findPage.enterAdress),"Input Box for Address not present lalka");
    }

    @Test(dependsOnMethods = "isElementsPresents")
    public void test() {
        FindPage.navigateTo(browserAction.getDriver());
        findPage.findInAction("Chernivtsi");
    }
    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }
}
