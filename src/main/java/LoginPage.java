package atqc.hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BrowserWrapper {
	
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
	
	public LoginPage(WebDriver driver) {
        super(driver);
    }

	public String getText1(){
		driver.findElement(By.tagName("body")).getText().contains("Invalid");
		return "Invalid e-mail or password";
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
		driver.findElement(By.tagName("body")).getText().contains("@");
		return "Log in successfully!";
	}
}
