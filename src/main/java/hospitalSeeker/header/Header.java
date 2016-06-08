package hospitalSeeker.header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    public static final String adminButtonXPATH = "/html/body/hospitalSeeker.header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a";
    public static final String adminButtonText = "Admin";
    public static final String patientsButtonXPATH = "/html/body/hospitalSeeker.header/div/div/div[2]/nav/div/div[2]/ul/li[6]/a";
    public static final String patientsButtonText = "Patients";

    //only for admin
    @FindBy(linkText = adminButtonText)
    public static WebElement adminButtonByText;

    @FindBy(xpath = adminButtonXPATH)
    public WebElement adminButtonByXpath;

    //only for doctors
    @FindBy(xpath = patientsButtonXPATH)
    public static WebElement patientsButtonByXpath;

    @FindBy(linkText = patientsButtonText)
    public static WebElement patientsButtonByText;

}
