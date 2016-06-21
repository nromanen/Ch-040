package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public static final String SUCCESSFULL_REGISTRATION = "/html/body/section/div/div/div/h3";
	public static final String THIS_USER_IS_ALREADY_EXIST = "/html/body/section/div/div/div/h3";

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

	public static RegisterPage init(WebDriver driver) {
		return PageFactory.initElements(driver, RegisterPage.class);
	}
}