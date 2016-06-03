import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/a")
    public WebElement loginDropdownButton;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[1]/input")
    public WebElement emailField;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[2]/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[3]/div/div[1]/input")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[3]/div/div[2]/input")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a")
    public WebElement logoutButton;

    public void loggingIn(String email, String password) {
        loginDropdownButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

}
