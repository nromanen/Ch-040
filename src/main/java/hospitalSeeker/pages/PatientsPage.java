package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsPage {


	@FindBy (linkText="patient2@i.ua")
	public WebElement patient2iua;
	
	@FindBy (linkText="tutu@ukr.net")
	public WebElement tutu;
	
	@FindBy (linkText="doctor@gmail.Com")
	public WebElement doctorgmailCom;
	
	@FindBy (linkText="nadja_cv@mail.ru")
	public WebElement nadja_cvmailru;
	
	@FindBy (linkText="iamapatient@pat.com")
	public WebElement iamapatientpatcom;
	
	@FindBy (linkText="olegolegovich1996@gmail.com")
	public WebElement olegolegovich1996gmailcom;
	
	@FindBy (linkText="archer@mail.ru")
	public WebElement archermailru;
	
	@FindBy (linkText="nadja_cv8@mail.ru")
	public WebElement nadja_cv8mailru;
	
	@FindBy (linkText="nadjacv51@mail.ru")
	public WebElement nadjacv51mailru;

	public static PatientsPage init(WebDriver driver) {
		return PageFactory.initElements(driver, PatientsPage.class);
	}
	
}
