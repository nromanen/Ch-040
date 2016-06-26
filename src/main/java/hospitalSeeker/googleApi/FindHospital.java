package hospitalSeeker.googleApi; /**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindHospital {

    @FindBy(id = "pac-input")
    public WebElement enterAdress;

    @FindBy(id = "googleMap")
    public WebElement googleMap;



    public void findInAction(String city){
        enterAdress.sendKeys(city);
    }

    public static FindHospital init(WebDriver driver) {
        return PageFactory.initElements(driver, FindHospital.class);
    }
}
