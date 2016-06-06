package atqc.hospital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownLogin extends BrowserWrapper {
	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/a")
	public WebElement dropdownLogin;
	
	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[1]/input")
	public WebElement dropdownEmailLogin;
	
	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[2]/input")
	public WebElement dropdownPasswordLogin;
	
	@FindBy (id = "remember")
	public WebElement dropdownRememberLogin;
	
	@FindBy (id = "login-submit")
	public WebElement dropdownLoginButton;
	
	public DropdownLogin(WebDriver driver) {
        super(driver);
   }	
}

