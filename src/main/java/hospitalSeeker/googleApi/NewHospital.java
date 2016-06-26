package hospitalSeeker.googleApi; /**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewHospital {

    @FindBy(xpath = "/html/body/hospitalSeeker.header/div/div/div[2]/nav/div/div[2]/ul/li[7]/a/span")
    public WebElement loginButtonXpath;

    @FindBy(xpath = "/html/body/hospitalSeeker.header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[1]/input")
    public WebElement emailField;

    @FindBy(xpath = "/html/body/hospitalSeeker.header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[2]/input")
    public WebElement passwordField;

    @FindBy(id = "login-submit")
    public WebElement loginSubmitButton;

    @FindBy(id = "address.country-error")
    public WebElement errorAddressField;
    @FindBy(id = "geo-error")
    public WebElement errorGeoField;

    @FindBy(id = "address.city-error")
    public WebElement errorCityField;

    @FindBy(id = "name-error")
    public WebElement errorField;

    @FindBy(id = "longitude-error")
    public WebElement errorLongitudeField;

    @FindBy(id = "latitude-error")
    public WebElement errorLatitudeField;

    @FindBy(className = "alert.alert-warning.fade.in")
    public WebElement confirmBox;

    @FindBy(id ="address.country")
    public WebElement countryField;

    @FindBy(id ="address.street")
    public WebElement streetField;

    @FindBy(id ="address.building")
    public WebElement buildingField;

    @FindBy(id="addressGeo")
    public WebElement addresField;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id="description")
    public WebElement descriptionField;

    @FindBy(id = "button-save")
    public WebElement submitButton;

    @FindBy(id = "latitude")
    public WebElement latitudeField;

    @FindBy(id = "address.city")
    public WebElement cityField;

    @FindBy(id="button-reset")
    public WebElement resetButton;

    @FindBy(id = "longitude")
    public WebElement longitudeField;

    @FindBy(id="image-uploaded")
    public WebElement imagePathButton;

    @FindBy(id = "googleMap")
    public WebElement googleMap;

    @FindBy(id="button-back")
    public WebElement backButton;

    @FindBy(id="button-fill")
    public WebElement fillButton;

    @FindBy(id="button-find")
    public WebElement findButton;





    public void inputName(String name){
        nameField.sendKeys(name);
    }
    public void input(String name){
        nameField.sendKeys(name);
    }
    public void inputAddress(String adrs){
        addresField.sendKeys(adrs);
    }
    public void inputDecsription(String desc){
        descriptionField.sendKeys(desc);
    }
    public void inputLat(String lat){
        latitudeField.sendKeys(lat);
    }
    public void inputLon(String lon){
        longitudeField.sendKeys(lon);
    }

    public void logInAction(String username, String password) {
        loginButtonXpath.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }

    public static NewHospital init(WebDriver driver) {
        return PageFactory.initElements(driver, NewHospital.class);
    }

}
