package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DoctorPage {

    @FindBy(xpath = ".//*[@class='person-detail' and .//text() = 'Gregory House']")
    public WebElement gregoryHouseLink;

    @FindAll(@FindBy(xpath = ".//*[@class='person-detail']"))
    public List<WebElement> doctors;

    public void selectDoctorAsManager() {
        doctors.get(0).click();
    }

    public static DoctorPage init(WebDriver driver) {
        return PageFactory.initElements(driver, DoctorPage.class);
    }

}
