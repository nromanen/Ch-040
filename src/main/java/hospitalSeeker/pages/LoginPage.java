package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement emailLogin;

    @FindBy(id = "password")
    public WebElement passwordLogin;

    @FindBy(css = "button.btn.btn-default")
    public WebElement rememberMe;

    @FindBy(css = "a.btn.btn-link.pull-right")
    public WebElement forgotPassword;

    @FindBy(id = "loginSubmit")
    public WebElement loginButton;

    @FindBy(id = "registerRedirect")
    public WebElement registerButton;

    @FindBy(id = "email-error")
    public WebElement loginWarning;

    @FindBy(id = "password-error")
    public WebElement passwordWarning;

    @FindBy(css = "div.alert.alert-danger")
    public WebElement warning;

    public void loggingIn(String email, String password) {
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }

    public static LoginPage init(WebDriver driver) {
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
