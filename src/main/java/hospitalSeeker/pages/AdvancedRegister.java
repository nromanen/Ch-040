package hospitalSeeker.pages;

import hospitalSeeker.BrowserWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedRegister {

    @FindBy(id = "detailForm")
    public WebElement detailForm;

    @FindBy(id = "firstName")
    public WebElement firstNameProfile;

    @FindBy(id = "lastName")
    public WebElement lastNameProfile;

    @FindBy(id = "image-uploaded")
    public WebElement imageUploader;

    @FindBy(id = "birthDate")
    public WebElement birthDateProfile;

    @FindBy(id = "gender")
    public WebElement gender;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "submitChanges")
    public WebElement submitChanges;

    @FindBy(css = "button.close[data-dismiss=modal]")
    public WebElement closeProfile;

    public void createProfile(String firstName, String lastName, String birthDate, String homeAddress, String phoneNumber, BrowserWrapper browser) {
        firstNameProfile.sendKeys(firstName);
        lastNameProfile.sendKeys(lastName);
        birthDateProfile.sendKeys(birthDate);
        browser.selectDropdown(gender, "WOMAN");
        address.sendKeys(homeAddress);
        phone.sendKeys(phoneNumber);
    }

    public static AdvancedRegister init(WebDriver driver) {
        return PageFactory.initElements(driver, AdvancedRegister.class);
    }
}
