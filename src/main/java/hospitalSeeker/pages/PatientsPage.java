package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsPage {

    @FindBy(linkText = "patient.cd@hospitals.ua")
    public WebElement patientCharlesDarvin;

    @FindBy(id = "usr")
    public WebElement searchPatient;

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    @FindBy(linkText = "patient.cc@hospitals.ua")
    public WebElement patientCc;

    @FindBy(linkText = "New record")
    public WebElement newRecord;

    public static PatientsPage init(WebDriver driver) {
        return PageFactory.initElements(driver, PatientsPage.class);
    }

}
