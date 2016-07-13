package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DepartmentPage {

    @FindAll(@FindBy(xpath = ".//*[@class='heart img-responsive']"))
    public List<WebElement> departments;

    public static DepartmentPage init(WebDriver driver) {
        return PageFactory.initElements(driver, DepartmentPage.class);
    }
}