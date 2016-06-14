package hospitalSeeker;

import hospitalSeeker.header.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public static NewRecordPage init(WebDriver driver) {
		return PageFactory.initElements(driver, NewRecordPage.class);
	}
	
}
