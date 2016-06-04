import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Alex on 6/3/2016.
 */
public class HospitalPage {

    @FindAll(@FindBy(xpath = ".//*[@class='img-responsive']"))
    public List<WebElement> hospitals;
}
