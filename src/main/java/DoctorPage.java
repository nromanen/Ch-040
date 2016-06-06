import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DoctorPage {


    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[1]/div/a/div[2]/img")
    public WebElement GregoryHouseLink;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div/a/div[1]/img")
    public WebElement LisaCuddyLink;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div/a/div[2]/img")
    public WebElement EricForemanLink;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[4]/div/a")
    public WebElement RemyHeadleyLink;
    
    @FindAll(@FindBy(xpath = ".//*[@class='person-detail']"))
    public List<WebElement> doctors;

}
