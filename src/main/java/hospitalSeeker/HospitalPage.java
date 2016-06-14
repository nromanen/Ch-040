package hospitalSeeker;

import hospitalSeeker.header.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Alex on 6/3/2016.
 */
public class HospitalPage {

    @FindAll(@FindBy(xpath = ".//*[@class='img-responsive']"))
    public List<WebElement> hospitals;

    public static HospitalPage init(WebDriver driver) {
        return PageFactory.initElements(driver, HospitalPage.class);
    }
}
