package hospitalSeeker;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.ParseException;

public class CardPage {
	@FindBy (css = "a.btn.btn-info")
	public WebElement newRecordButton;
	
	@FindBy (css = "a.collapsed")
	public WebElement dateRecordButton;
	
	@FindBy (linkText="Edit")
	public WebElement editButton;
	
	@FindBy (xpath = "//div/div[1]/div[2]/h1/a")
	public WebElement profileButton;
	
	@FindBy (css = ".//*[@id='headingOne']/h4/a > div???????????????????? ")
	public WebElement record1;
	
	@FindBy (xpath = ".//*[@id='headingOne']/h4/a")
	public WebElement record2;
	
	@FindBy (xpath = ".//*[@id='item-dm']/pre[1]")
	public WebElement cArea;
	
	@FindBy (xpath = ".//*[@id='item-dm']/pre[2]")
	public WebElement pArea;
	
	@FindBy (xpath = ".//*[@id='item-dm']/pre[3]")
	public WebElement rArea;

	public Date dateParser() throws ParseException, java.text.ParseException {
	        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd-MM-yyyy");
	        String dateString = dateRecordButton.getAttribute("text").trim();
	        Date date = formatter.parse(dateString);
	        System.out.println(date);
	        return date;
	    }

	public static CardPage init(WebDriver driver) {
		return PageFactory.initElements(driver, CardPage.class);
	}
}
