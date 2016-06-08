package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/div/form/div[1]/input")
	public WebElement emailLogin;
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/div/form/div[2]/input")
	public WebElement passwordLogin;
	
	@FindBy(id = "rememberme")
	public WebElement rememberMe;
	
	@FindBy(css = "input.btn.btn-block.btn-primary.btn-default")
    public WebElement loginButton;
	
	@FindBy(css = "input.btn.btn-block.btn-default.btn-default")
    public WebElement homeButton;
}
