package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

    public static final String dashboardClassName = "dashboard";
    public static final String optionsButtonXPATH = "/html/body/section/div/a";

    @FindBy(className = dashboardClassName)
    public WebElement dashboardTable;

    @FindBy(xpath = optionsButtonXPATH)
    public WebElement optionsButton;
}
