package hospitalSeeker.googleApi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindHospitalPage {

    @FindBy(className = "pac-input")
    public WebElement enterAddress;

    @FindBy(id = "googleMap")
    public WebElement googleMap;

    public void find(String city) {
        enterAddress.sendKeys(city);
    }

    public static FindHospitalPage init(WebDriver driver) {
        return PageFactory.initElements(driver, FindHospitalPage.class);
    }
}
