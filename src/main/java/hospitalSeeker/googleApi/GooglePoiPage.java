package hospitalSeeker.googleApi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePoiPage {
    @FindBy(id = "googleMap")
    public WebElement googleApi;

    @FindBy(css = "button.btn.btn-default[title=Show on map]")
    public WebElement showOnMap;

    @FindBy(css = "span.glyphicon.glyphicon-plus")
    public WebElement addValidateHospital;

    @FindBy(className = "nav navbar-nav dropdown dropdown-toggle active")
    public WebElement actionsButton;

    @FindBy(partialLinkText = "Check Hospitals List")
    public WebElement checkButton;

    @FindBy(css=".btn-default")
    public WebElement getGooglePoi;

    @FindBy(css = ".table")
    public WebElement table;

    @FindBy(id = "table-out")
    public WebElement hospitalsTable;

    @FindBy(css = "table")
    public WebElement tables;

    public static GooglePoiPage init(WebDriver driver) {
        return PageFactory.initElements(driver, GooglePoiPage.class);
    }

}
