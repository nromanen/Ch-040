package hospitalSeeker;

import hospitalSeeker.header.DropdownLogin;
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
        dropdownLogin = PageFactory.initElements(browser.getDriver(), DropdownLogin.class);
        doctorPage = PageFactory.initElements(browser.getDriver(), DoctorPage.class);
    }

    @Test
    public void testLogin() {
        browser.goTo(DOCTOR_PAGE_URL);
        dropdownLogin.dropdownLoginButton.click();
        dropdownLogin.dropdownEmailField.sendKeys("admin@admin.com");
        dropdownLogin.dropdownPasswordField.sendKeys("12345");
        dropdownLogin.dropdownRememberMeCheckbox.click();
        dropdownLogin.dropdownLogoutButton.click();
    }

    @Test
    public void testDoctorLinks() {
        browser.goTo(DOCTOR_PAGE_URL);

        doctorPage.GregoryHouseLink.click();
        browser.browserBack();
        doctorPage.LisaCuddyLink.click();
        browser.browserBack();
        doctorPage.EricForemanLink.click();
        browser.browserBack();
        doctorPage.RemyHeadleyLink.click();
    }


    @AfterMethod
    public void afterMethod() {
        browser.getDriver().quit();
    }

}
