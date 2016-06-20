package hospitalSeeker.googleApi; /**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateHospital{
    @FindBy(id = "googleMap")
    public WebElement googleApi;

    @FindBy(xpath = "xpath=(//button[@type='button'])[4]")
    public WebElement showOnMap;

    @FindBy(css = "span.glyphicon.glyphicon-plus")
    public WebElement addValidateHospital;

    @FindBy(className = "nav navbar-nav dropdown dropdown-toggle active")
    public WebElement actionsButton;

    @FindBy(partialLinkText = "Check Hospitals List")
    public WebElement checkButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement getGooglePoi;

    @FindBy(className = "table table-striped table-bordered")
    public WebElement table;

    public void checkGoogleApi(){
        googleApi.isDisplayed();
    }
    public void googlePoiButtonClick(){
        getGooglePoi.click();
    }
    public void addValidateHospitalClick(){
        addValidateHospital.click();
    }
    public void findValidateHospitalClick(){
        showOnMap.click();
    }

    public static ValidateHospital init(WebDriver driver) {
        return PageFactory.initElements(driver, ValidateHospital.class);
    }

}
