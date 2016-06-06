package hospital;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPage {
	@FindBy (css = "a.btn.btn-info")
	public WebElement newRecordButton;
	
	@FindBy (css = "a.collapsed")
	public WebElement dateRecordButton;
	
	@FindBy (linkText="Edit")
	public WebElement editButton;
	
}
