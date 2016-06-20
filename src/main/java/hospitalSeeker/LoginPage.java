package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static final String INVALID_USERNAME_OR_PASSWORD = "/html/body/section/div/div/div/div/div/form/fieldset/div[1]/p";

	@FindBy(id = "email")
	public WebElement emailLogin;
	
	@FindBy(id="password")
	public WebElement passwordLogin;
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/div/form/fieldset/span/button")
	public WebElement rememberMe;
	
	@FindBy(linkText = "Forgot Password?")
	public WebElement forgotPassword;
	
	@FindBy(css = "input.btn.btn-lg.btn-info.btn-block")
    public WebElement loginButton;
	
	@FindBy(linkText = "Register")
    public WebElement registerButton;

	public void loggingIn(String email, String password) {
		emailLogin.sendKeys(email);
		passwordLogin.sendKeys(password);
		loginButton.click();
	}

	public static LoginPage init(WebDriver driver) {
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
