package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Надежда on 12.07.2016.
 */
public class AdvancedRegister {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "image-uploaded")
    public WebElement imageUploader;

    @FindBy(id = "birthDate")
    public WebElement birthDate;

    @FindBy(id = "gender")
    public WebElement gender;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "submitChanges")
    public WebElement submitChanges;

    @FindBy(css = "close")
    public WebElement closeButton;

/*    @FindBy(id = "")
    public WebElement ;*/

    public static AdvancedRegister init(WebDriver driver) {
        return PageFactory.initElements(driver, AdvancedRegister.class);
    }
}
