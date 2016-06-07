package header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownRegister {

	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a")
	public WebElement dropdownRegister;
	
	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/ul/div/form/div[1]/input")
	public WebElement dropdownEmailRegister;
	
	@FindBy (xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/ul/div/form/div[2]/input")
	public WebElement dropdownPasswordRegister;
	
	@FindBy (id = "register-submit")
	public WebElement dropdownRegisterButton;

}
