import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDashboardPage {

    public static final String dashboardClassName = "dashboard";
    public static final String adminButtonXPATH = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a";
    public static final String adminButtonText = "Admin";
    public static final String optionsButtonXPATH = "/html/body/section/div/a";

    @FindBy(className = dashboardClassName)
    public WebElement dashboardTable;

    @FindBy(linkText = adminButtonText)
    public WebElement adminButtonByText;

    @FindBy(linkText = adminButtonXPATH)
    public WebElement adminButtonByXpath;

    @FindBy(xpath = optionsButtonXPATH)
    public WebElement optionsButton;
}
