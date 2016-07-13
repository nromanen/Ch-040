package hospitalSeeker.googleApi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewHospitalPage {

    public static final String testAddress = "Головна вулиця, 239, Чернівці, Чернівецька область, Украина";
    public static final String testName = "Новий тестовий госпіталь";
    public static final String testCity = "Чернівці";
    public static final String testDescription = "Лікарня для тестів";
    public static final String testBuildingNumber = "246";

    @FindBy(id = "address.country")
    public WebElement countryField;

    @FindBy(id = "address.country-error")
    public WebElement errorCountryField;

    @FindBy(id = "address.city")
    public WebElement cityField;

    @FindBy(id = "address.city-error")
    public WebElement errorCityField;

    @FindBy(id = "address.street")
    public WebElement streetField;

    @FindBy(id = "address.building")
    public WebElement buildingField;

    @FindBy(id = "addressGeo")
    public WebElement addressField;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "name-error")
    public WebElement errorNameField;

    @FindBy(id = "description")
    public WebElement descriptionField;

    @FindBy(id = "button-save")
    public WebElement saveButton;

    @FindBy(id = "latitude")
    public WebElement latitudeField;

    @FindBy(id = "latitude-error")
    public WebElement errorLatitudeField;

    @FindBy(id = "longitude")
    public WebElement longitudeField;

    @FindBy(id = "longitude-error")
    public WebElement errorLongitudeField;

    @FindBy(id = "button-reset")
    public WebElement resetButton;

    @FindBy(id = "image-uploaded")
    public WebElement imagePathButton;

    @FindBy(id = "googleMap")
    public WebElement googleMap;

    @FindBy(id = "button-back")
    public WebElement backButton;

    @FindBy(id = "button-fill")
    public WebElement fillButton;

    @FindBy(id = "button-find")
    public WebElement findButton;

    public void addNewHospital() {
        addressField.sendKeys(testAddress);
        findButton.click();
        fillButton.click();
        buildingField.clear();
        buildingField.sendKeys(testBuildingNumber);
        nameField.sendKeys(testName);
        descriptionField.sendKeys(testDescription);
    }

    public static NewHospitalPage init(WebDriver driver) {
        return PageFactory.initElements(driver, NewHospitalPage.class);
    }

}
