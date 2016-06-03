import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDoctorPage extends BaseTest {

    LoginPage loginPage;
    DoctorPage doctorPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage = PageFactory.initElements(browserAction.getDriver(), LoginPage.class);
        doctorPage = PageFactory.initElements(browserAction.getDriver(), DoctorPage.class);
    }

    @Test
    public void testLogin() {
        browserAction.goTo(doctorPageUrl);
        loginPage.loginDropdownButton.click();
        loginPage.emailField.sendKeys("admin@admin.com");
        loginPage.passwordField.sendKeys("12345");
        loginPage.rememberMeCheckbox.click();
        loginPage.loginButton.click();
    }

    @Test
    public void testDoctorLinks() {
        browserAction.goTo(doctorPageUrl);

        doctorPage.GregoryHouseLink.click();
        browserAction.browserBack();
        doctorPage.LisaCuddyLink.click();
        browserAction.browserBack();
        doctorPage.EricForemanLink.click();
        browserAction.browserBack();
        doctorPage.RemyHeadleyLink.click();
        browserAction.sleep();
    }


    @AfterMethod
    public void afterMethod() {
        browserAction.getDriver().quit();
    }

}
