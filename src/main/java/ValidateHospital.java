/**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateHospital{

    public  static String baseUrl =  "http://91.209.24.68/ch-040/admin/map/validate";
    @FindBy(id = "googleMap")
    public WebElement googleApi;

    @FindBy(css = "button.btn.btn-default.col-sm-12")
    public WebElement validateButton;

    @FindBy(css = "button.btn.btn-default")
    public WebElement addValidateHospital;

    /*@FindBy(xpath = "/html/body/header/div.panel_nth-child[2]/div_nth-child[2]/table_nth-child[3]/tbody_nth-child[2]/tr_nth-child[9]/td_nth-child[2]/form_nth-child[1]/button_nth-child[3]")
    public WebElement addValidateHospital;

   /* public ValidateHospital(WebDriver driver) {
        super(driver);
    }*/


    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
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
    public static ValidateHospital navigateTo(WebDriver driver) {
        driver.get(baseUrl);
        return PageFactory.initElements(driver, ValidateHospital.class);
    }




}
