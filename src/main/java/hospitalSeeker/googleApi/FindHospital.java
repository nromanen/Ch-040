package hospitalSeeker.googleApi; /**
 * Created by oleg on 25.05.2016.
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindHospital {

    public  static final String baseUrl =  "http://91.209.24.68/ch-040/mapsearch";


    @FindBy(id = "pac-input")
    public WebElement enterAdress;

    @FindBy(id = "googleMap")
    public WebElement googleMap;



    public void findInAction(String city){
        enterAdress.sendKeys(city);
    }
}
