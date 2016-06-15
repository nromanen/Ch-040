package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage {
	@FindBy (css = "a.btn.btn-info")
	public WebElement newRecordButton;
	
	@FindBy (css = "a.collapsed")
	public WebElement dateRecordButton;
	
	@FindBy (linkText="Edit")
	public WebElement editButton;

	public static CardPage init(WebDriver driver) {
		return PageFactory.initElements(driver, CardPage.class);
	}
}
