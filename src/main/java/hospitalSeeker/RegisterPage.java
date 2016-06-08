package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/form/div[1]/div/input")
	public WebElement emailRegister;
	
	@FindBy(xpath = "/html/body/section/div/div/div/div/form/div[2]/div/input")
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
	
}