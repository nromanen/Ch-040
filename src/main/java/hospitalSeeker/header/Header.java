package hospitalSeeker.header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    public static final String HOME_BUTTON_TEXT = "Home";
    public static final String FIND_BUTTON_TEXT = "Find";
    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String ACTIONS_BUTTON_TEXT = "Actions";
    public static final String USER_DROPDOWN_BUTTON_CLASS = "open";
    public static final String LOG_OUT_BUTTON_CLASS = "glyphicon.glyphicon-log-out";
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

    @FindBy(className = USER_DROPDOWN_BUTTON_CLASS)
    public WebElement userDropdownButton;

    @FindBy(className = LOG_OUT_BUTTON_CLASS)
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

}
