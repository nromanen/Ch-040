package hospitalSeeker.pages;

import hospitalSeeker.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Надежда on 12.07.2016.
 */
public class TestAdvancedRegister extends BaseTest{

    Header header;
    LoginPage loginPage;
    RegisterPage registerPage;
    AdvancedRegister advancedRegister;

    @BeforeMethod
    public void beforeMethod() {
        header = Header.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        advancedRegister = AdvancedRegister.init(browser.getDriver());
    }

    @Test
    public void goToProfile(){
        browser.goTo(REGISTER_URL);
        registerPage.registration("patient.cc@hospitals.ua","Per1111","Per1111");
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn("patient.cc@hospitals.ua","Per1111");
        header.goToProfile();


    }
}
