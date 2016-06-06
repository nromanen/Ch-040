/**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewHospital {

    public  static String baseUrl =  "http://91.209.24.68/ch-040/admin/map/new";

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/a/span")
    public WebElement loginButtonXpath;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[1]/input")
    public WebElement emailField;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[7]/ul/div/form/div[2]/input")
    public WebElement passwordField;

    @FindBy(id = "login-submit")
    public WebElement loginSubmitButton;

    @FindBy(css = "i.removable-i.fade.in")
    public WebElement errorField;
    @FindBy(className = "alert.alert-warning.fade.in")
    public WebElement confirmBox;
    @FindBy(id="address")
    public WebElement addresField;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id="description")
    public WebElement descriptionField;

    @FindBy(css = "button.imagePath")
    public WebElement imagePathButton;

    @FindBy(css = "button.col-sm-2.btn.btn-default")
    public WebElement submitButton;

    @FindBy(id = "latitude")
    public WebElement latitudeField;

    @FindBy(id = "longitude")
    public WebElement longitudeField;
    @FindBy(id = "googleMap")
    public WebElement googleMap;

    public void inputName(String name){
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
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void logInAction(String username, String password) {
        loginButtonXpath.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }
    public static NewHospital navigateTo(WebDriver driver) {
        driver.get(baseUrl);
        return PageFactory.initElements(driver, NewHospital.class);
    }
    public static NewHospital navigateToLgn(WebDriver driver) {
        driver.get("http://91.209.24.68/ch-040");
        return PageFactory.initElements(driver, NewHospital.class);
    }
}
