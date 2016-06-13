package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
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
}
