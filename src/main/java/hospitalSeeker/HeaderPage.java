package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HeaderPage {

    public static final String HOME_BUTTON_ID = "homeButton";
    public static final String FIND_BUTTON_ID = "findButton";
    public static final String LOGIN_BUTTON_ID = "logIn";
    public static final String ACTIONS_BUTTON_ID = "actionsButton";
    public static final String ALL_USERS_BUTTON_ID = "allUsersButton";
    public static final String ADD_NEW_USER_BUTTON_ID = "addNewUserButton";
    public static final String HOSPITAL_LIST_BUTTON_ID = "hospitalListButton";
    public static final String NEW_HOSPITAL_BUTTON_ID = "newHospitalButton";
    public static final String CHECK_HOSPITALS_BUTTON_ID = "checkHospButton";
    public static final String EDIT_HOSPITAL_MANAGERS_BUTTON_ID = "editHospManagersButton";
    public static final String USER_DROPDOWN_BUTTON_ID = "userDropdown";
    public static final String LOG_OUT_BUTTON_ID = "logout";
    public static final String CARD_BUTTON_ID = "cardButton";
    public static final String APPOINTMENTS_BUTTON_ID = "myappButton";
    public static final String PATIENTS_BUTTON_ID = "patientsButton";
    public static final String WORKSCHEDULER_BUTTON_ID = "worckschedulerButton";
    public static final String MANAGE_BUTTON_ID = "manageButton";

    @FindBy(id = HOME_BUTTON_ID)
    public WebElement homeButton;

    @FindBy(id = FIND_BUTTON_ID)
    public WebElement findButton;

    @FindBy(id = LOGIN_BUTTON_ID)
    public WebElement loginButton;

    @FindBy(id = ACTIONS_BUTTON_ID)
    public WebElement actionsButton;

    @FindBy(id = "userDropdown")
    public WebElement userDropdownButton;

    @FindBy(id = "logoutButton")
    public WebElement logoutButton;

    @FindBy(id = CARD_BUTTON_ID)
    public WebElement cardButton;

    @FindBy(linkText = "My appointments")
    public WebElement appointmentsButton;

    @FindBy(id = PATIENTS_BUTTON_ID)
    public WebElement patientsButton;

    @FindBy(id = WORKSCHEDULER_BUTTON_ID)
    public WebElement workschedulerButton;

    @FindBy(id = ALL_USERS_BUTTON_ID)
    public WebElement allUsersButton;

    @FindBy(id = ADD_NEW_USER_BUTTON_ID)
    public WebElement addNewUserButton;

    @FindBy(id = HOSPITAL_LIST_BUTTON_ID)
    public WebElement hospitalListButton;

    @FindBy(id = NEW_HOSPITAL_BUTTON_ID)
    public WebElement newHospitalButton;

    @FindBy(id = CHECK_HOSPITALS_BUTTON_ID)
    public WebElement checkHospitalsButton;

    @FindBy(id = EDIT_HOSPITAL_MANAGERS_BUTTON_ID)
    public WebElement editHospitalManagersButton;

    @FindBy(id = MANAGE_BUTTON_ID)
    public WebElement manageButton;

    public void logout() {
        userDropdownButton.click();
        logoutButton.click();
    }

    public static HeaderPage init(WebDriver driver) {
        return PageFactory.initElements(driver, HeaderPage.class);
    }

}
