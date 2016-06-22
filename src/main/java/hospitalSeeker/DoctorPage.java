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

    @FindBy(xpath = ".//*[@class='person-detail' and .//text() = 'Lisa Cuddy']")
    public WebElement lisaCuddyLink;

    @FindBy(xpath = ".//*[@class='person-detail' and .//text() = 'Eric Foreman']")
    public WebElement ericForemanLink;

    @FindBy(xpath = ".//*[@class='person-detail' and .//text() = 'Rhemy Hadley']")
    public WebElement remyHadleyLink;

    @FindBy(xpath = ".//*[@class='person-detail' and .//text() = 'James Wilson']")
    public WebElement jamesWilsonLink;



    @FindAll(@FindBy(xpath = ".//*[@class='person-detail']"))
    public List<WebElement> doctors;

    public static DoctorPage init(WebDriver driver) {
        return PageFactory.initElements(driver, DoctorPage.class);
    }

}
