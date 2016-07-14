package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsPage {

    @FindBy(id = "usr")
    public WebElement searchPatient;

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    @FindBy(linkText = "patient.cc@hospitals.ua")
    public WebElement patientCc;

    @FindBy(linkText = "New record")
    public WebElement newRecord;

    @FindBy(linkText = "patient.sf@hospitals.ua")
    public WebElement patientsf;

    @FindBy(linkText = "patient.rr@hospitals.ua")
    public WebElement patientrr;

    @FindBy(linkText = "patient.ml@hospitals.ua")
    public WebElement patientml;

    @FindBy(linkText = "patient.in@hospitals.ua")
    public WebElement patientin;

    @FindBy(linkText = "patient.cd@hospitals.ua")
    public WebElement patientcd;

    @FindBy(xpath = "//table/thead/tr/th[2]/div[2]/a/i")
    public WebElement sortButtonByEmail;

    @FindBy(xpath = "//table/thead/tr/th[3]/div[2]/a/i")
    public WebElement sortButtonByFirstName;

    @FindBy(xpath = "//table/thead/tr/th[4]/div[2]/a/i")
    public WebElement sortButtonByLastName;

    @FindBy(id = "usr")
    public WebElement searchField;

    @FindBy(css = "button.btn.btn-default")
    public WebElement submitButton;

    @FindBy(css = "a.back-to-top")
    public WebElement backToTopButton;

    @FindBy(xpath = "html/body/section/div/div/div[2]/div/div/ul/li[3]/a")
    public WebElement secondPage;

    @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[6]/a")
    public WebElement doctorLink;

    @FindBy(xpath = ".//*[@id='dropdawn']/li[2]/a")
    public WebElement logoutButton;

    public static PatientsPage init(WebDriver driver) {
        return PageFactory.initElements(driver, PatientsPage.class);
    }
}
