package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    public static final String HOME_BUTTON_TEXT = "Home";
    public static final String FIND_BUTTON_TEXT = "Find";
    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String ACTIONS_BUTTON_TEXT = "Actions";
    public static final String USER_DROPDOWN_BUTTON_SELECTOR = "#bs-example-navbar-collapse-1 > ul > li:nth-child(8) > a";
    public static final String LOG_OUT_BUTTON_SELECTOR = "#dropdawn > li:nth-child(2) > a";
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

    @FindBy(css = USER_DROPDOWN_BUTTON_SELECTOR)
    public WebElement userDropdownButton;

    @FindBy(css = LOG_OUT_BUTTON_SELECTOR) //terrifyingly bad thing!!!
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

    public void logout() {
        userDropdownButton.click();
        logoutButton.click();
    }

    public static HeaderPage init(WebDriver driver) {
        return PageFactory.initElements(driver, HeaderPage.class);
    }

}
