package hospitalSeeker.googleApi; /**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidateHospital{
    @FindBy(id = "googleMap")
    public WebElement googleApi;

    @FindBy(css = "button.btn.btn-default.col-sm-12")
    public WebElement validateButton;

    @FindBy(css = "button.btn.btn-default")
    public WebElement addValidateHospital;

    public void checkGoogleApi(){
        googleApi.isDisplayed();
    }
    public void validateButtonClick(){
        validateButton.click();
    }
    public void addValidateHospitalClick(){
        addValidateHospital.click();
    }
    public void findValidateHospitalClick(){
        addValidateHospital.click();
    }

}
