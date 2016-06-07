

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRecordPage {

	@FindBy (id="complaint")
	public WebElement complaintArea;
	
	@FindBy (id="result")
	public WebElement resultArea;
	
	@FindBy (id="prescription")
	public WebElement prescriptionArea;
	
	@FindBy (css = "button.btn.btn-danger")
	public WebElement backButton;
	
	@FindBy (css = "button.btn.btn-default")
	public WebElement submitButton;
	
	@FindBy (css = "p.error")
	public WebElement errorString;
	
	@FindBy (css = "p.error")
	public WebElement editTimeError;
	
}
