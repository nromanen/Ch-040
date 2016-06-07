import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDoctorPage extends BaseTest {

    DropdownLogin dropdownLogin;
    DoctorPage doctorPage;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        dropdownLogin = PageFactory.initElements(browserAction.getDriver(), DropdownLogin.class);
        doctorPage = PageFactory.initElements(browserAction.getDriver(), DoctorPage.class);
    }

    @Test
    public void testLogin() {
        browserAction.goTo(DOCTOR_PAGE_URL);
        dropdownLogin.dropdownLoginButton.click();
        dropdownLogin.dropdownEmailField.sendKeys("admin@admin.com");
        dropdownLogin.dropdownPasswordField.sendKeys("12345");
        dropdownLogin.dropdownRememberMeCheckbox.click();
        dropdownLogin.dropdownLogoutButton.click();
    }

    @Test
    public void testDoctorLinks() {
        browserAction.goTo(DOCTOR_PAGE_URL);

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
