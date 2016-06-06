/**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPage {

    public  static String baseUrl =  "http://91.209.24.68/ch-040/mapsearch";

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @FindBy(id = "pac-input")
    public WebElement enterAdress;
    @FindBy(id = "googleMap")
    public WebElement googleMap;
    public static FindPage navigateTo(WebDriver driver) {
        driver.get(baseUrl);
        return PageFactory.initElements(driver, FindPage.class);
    }


    public void findInAction(String city){
        enterAdress.sendKeys(city);
    }
}
