import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    public static final String adminButtonXPATH = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a";
    public static final String adminButtonText = "Admin";
    public static final String patientsButtonXPATH = "/html/body/header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a";

    //only for admin
    @FindBy(linkText = adminButtonText)
    public WebElement adminButtonByText;

    @FindBy(xpath = adminButtonXPATH)
    public WebElement adminButtonByXpath;

    //only for doctors
    @FindBy(xpath = patientsButtonXPATH)
    public WebElement patientsButtonByXpath;

}
