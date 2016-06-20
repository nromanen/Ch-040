package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public static final String SUCCESSFULL_REGISTRATION = "/html/body/section/div/div/div/h3";
	public static final String THIS_USER_IS_ALREADY_EXIST = "/html/body/section/div/div/div/h3";
	public static final String REGISTER_FORM = "/html/body/section/div/div/div";

	@FindBy(id = "email")
	public WebElement emailRegister;

	@FindBy(id = "password")
	public WebElement passwordRegister;
	
	@FindBy(id = "enabled")
	public WebElement enabledButton;
	
	@FindBy(css = "option[value=ADMIN]")
	public WebElement roleAdmin;
	
	@FindBy(css = "option[value=DOCTOR]")
	public WebElement roleDoctor;
	
	@FindBy(css = "option[value=MANAGER]")
	public WebElement roleManager;
	
	@FindBy(css = "option[value=PATIENT]")
	public WebElement rolePatient;
	
	@FindBy(css = "input.btn.btn-primary.btn-sm")
	public WebElement registerButton;
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/form/div[5]/div/a")
	public WebElement cancelButton;

	public static RegisterPage init(WebDriver driver) {
		return PageFactory.initElements(driver, RegisterPage.class);
	}
}