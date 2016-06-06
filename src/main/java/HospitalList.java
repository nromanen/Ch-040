import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oleg on 25.05.2016.
 */
public class HospitalList extends BrowserWrapper {

    public  static String baseUrl =  "http://91.209.24.68/ch-040/listhospitals";

    @FindBy(linkText = "/admin/map/new")
    public WebElement addNewHospitalBtn;

    @FindBy(partialLinkText = "validate")
    public WebElement validateHospitalBtn;

    @FindBy(linkText = "/admin/map/edithospital1")
    public WebElement editBtn;

    @FindBy(xpath = "//form/button[@type = button")
    public WebElement srchInMap;

    @FindBy(xpath = "//form/button[@type = submit]")
    public WebElement dltBtn;

    public HospitalList(WebDriver driver) {
        super(driver);
    }
    public String getBaseUrl(){
        return this.baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public static HospitalList navigateTo(WebDriver driver) {
        driver.get(baseUrl);
        return PageFactory.initElements(driver, HospitalList.class);
    }
}
