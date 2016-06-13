package hospitalSeeker.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public static final String HOME_BUTTON_TEXT = "Home";
    public static final String FIND_BUTTON_TEXT = "Find";
    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String ACTIONS_BUTTON_TEXT = "Actions";
    public static final String USER_DROPDOWN_BUTTON_XPATH = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a";
    public static final String LOG_OUT_BUTTON_XPATH = "//*[@id=\"dropdawn\"]/li[2]/a/text()";
    public static final String CARD_BUTTON_TEXT = "Card";
    public static final String APPOINTMENTS_BUTTON_TEXT = "my appointments";
    public static final String PATIENTS_BUTTON_TEXT = "Patients";
    public static final String WORKSCHEDULER_BUTTON_TEXT = "workscheduler";
    public static final String MANAGE_BUTTON_TEXT = "manage";

    @FindBy(linkText = HOME_BUTTON_TEXT)
    public WebElement homeButton;

    @FindBy(linkText = FIND_BUTTON_TEXT)
    public WebElement findButton;

    @FindBy(linkText = LOGIN_BUTTON_TEXT)
    public WebElement loginButton;

    @FindBy(linkText = ACTIONS_BUTTON_TEXT)
    public WebElement actionsButton;

    @FindBy(xpath = USER_DROPDOWN_BUTTON_XPATH)
    public WebElement userDropdownButton;

    @FindBy(xpath = LOG_OUT_BUTTON_XPATH) //terrifyingly bad thing!!!
    public WebElement logoutButton;

    @FindBy(className = CARD_BUTTON_TEXT)
    public WebElement cardButton;

    @FindBy(className = APPOINTMENTS_BUTTON_TEXT)
    public WebElement appointmentsButton;

    @FindBy(className = PATIENTS_BUTTON_TEXT)
    public WebElement patientsButton;

    @FindBy(className = WORKSCHEDULER_BUTTON_TEXT)
    public WebElement workschedulerButton;

    @FindBy(className = MANAGE_BUTTON_TEXT)
    public WebElement manageButton;

    public Header init(WebDriver driver) {
        return PageFactory.initElements(driver, Header.class);

//        wrapper.waitUntilElementVisible(homeButton);
    }

}
