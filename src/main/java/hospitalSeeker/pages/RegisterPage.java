package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public static final String SUCCESSFULL_REGISTRATION = "h3.text-success.text-center.menu";
    public static final String WARNING_EMAIL = "span.has-error.text-danger";

    @FindBy(id = "email")
    public WebElement emailRegister;

    @FindBy(id = "password")
    public WebElement passwordRegister;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordRegister;

    @FindBy(id = "registerSubmit")
    public WebElement registerButton;

    @FindBy(id = "loginRedirect")
    public WebElement loginButton;

    @FindBy(css = SUCCESSFULL_REGISTRATION)
    public WebElement successfullRegistration;

    @FindBy(css = WARNING_EMAIL)
    public WebElement warningExistingEmail;

    @FindBy(id = "email-error")
    public WebElement warningByEmail;

    @FindBy(id = "email-error")
    public WebElement incorrectEmailFormat;

    @FindBy(id = "password-error")
    public WebElement insecurePassword;

    @FindBy(css = "span.has-error.text-danger")
    public WebElement weakPassword;

    @FindBy(id = "confirmPassword-error")
    public WebElement confirmPasswordError;

    public void registration(String email, String password, String confirmPassword) {
        emailRegister.sendKeys(email);
        passwordRegister.sendKeys(password);
        confirmPasswordRegister.sendKeys(confirmPassword);
        registerButton.click();
    }

    public static RegisterPage init(WebDriver driver) {
        return PageFactory.initElements(driver, RegisterPage.class);
    }
}