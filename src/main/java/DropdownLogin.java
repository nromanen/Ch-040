import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownLogin {
	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/a")
	public WebElement dropdownLoginButton;

	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[1]/input")
	public WebElement dropdownEmailField;

	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[2]/input")
	public WebElement dropdownPasswordField;

	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[3]/div/div[1]/input")
	public WebElement dropdownRememberMeCheckbox;

	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[3]/div/div[2]/input")
	public WebElement dropdownLoginSubmitButton;

	@FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a")
	public WebElement dropdownLogoutButton;

	public void loggingIn(String email, String password) {
		dropdownLoginButton.click();
		dropdownEmailField.sendKeys(email);
		dropdownPasswordField.sendKeys(password);
		dropdownLoginButton.click();
	}

	public void logout() {
		dropdownLogoutButton.click();
	}
}

