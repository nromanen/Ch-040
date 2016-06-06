package atqc.hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BrowserWrapper {
	
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
	
	
	public RegisterPage(WebDriver driver) {
        super(driver);
    }
	
	public String getText1(){
		if(driver.findElement(By.tagName("body")).getText().contains("registered successfully"))
			return "Registered successfully";
		else
			return "Registered unsuccessfully";
	}
	
	public String getText2(){
		driver.findElement(By.tagName("body")).getText().contains("Пожалуйста, заполните это поле.");
		return "Input e-mail!";
	}
	
	public String getText3(){
		driver.findElement(By.tagName("body")).getText().contains("Пожалуйста, заполните это поле.");
		return "Input password!";
	}
	
	public String getText4(){
		driver.findElement(By.tagName("body")).getText().contains("is already exist");
		return "This user is already exist!";
	}
	
	public boolean getText5(){
		if(driver.findElement(By.tagName("body")).getText().contains("Пожалуйста, введите адрес электронной почты.")){
			return true;
		}
		else return false;
		
	}
	
	public String getText6(){
		driver.findElement(By.tagName("body")).getText().contains("Пожалуйста, используйте требуемый формат:");
		return "Input password in correct format!";
	}
	
}