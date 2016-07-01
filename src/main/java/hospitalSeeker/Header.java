package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public static final String HOME_BUTTON_ID = "homeButton";
    public static final String FIND_BUTTON_ID = "findButton";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String ACTIONS_BUTTON_ID = "actionsButton";
    public static final String ALL_USERS_BUTTON_ID = "allUsersButton";
    public static final String ADD_NEW_USER_BUTTON_ID = "addNewUserButton";
    public static final String HOSPITAL_LIST_BUTTON_ID = "hospitalListButton";
    public static final String NEW_HOSPITAL_BUTTON_ID = "addNewHospitalButton";
    public static final String CHECK_HOSPITALS_BUTTON_ID = "checkHospitalsButton";
    public static final String EDIT_HOSPITAL_MANAGERS_BUTTON_ID = "editHospitalsManagersButton";
    public static final String USER_DROPDOWN_BUTTON_ID = "userDropdown";
    public static final String LOG_OUT_BUTTON_ID = "logoutButton";
    public static final String CARD_BUTTON_ID = "cardButton";
    public static final String PATIENTS_BUTTON_ID = "patientsButton";
    public static final String MANAGE_BUTTON_ID = "manageButton";
    public static final String CONFIGURE_TOKENS_BUTTON = "configTokensButton";

    @FindBy(id = HOME_BUTTON_ID)
    public WebElement homeButton;

    @FindBy(id = FIND_BUTTON_ID)
    public WebElement findButton;

    @FindBy(id = LOGIN_BUTTON_ID)
    public WebElement loginButton;

    @FindBy(id = ACTIONS_BUTTON_ID)
    public WebElement actionsButton;

    @FindBy(id = USER_DROPDOWN_BUTTON_ID)
    public WebElement userDropdownButton;

    @FindBy(id = LOG_OUT_BUTTON_ID)
    public WebElement logoutButton;

    @FindBy(id = CARD_BUTTON_ID)
    public WebElement cardButton;

    @FindBy(linkText = "My appointments")
    public WebElement appointmentsButton;

    @FindBy(id = PATIENTS_BUTTON_ID)
    public WebElement patientsButton;

    @FindBy(xpath = "//a[contains(@class, 'menu') and text()='Worksheduler']")
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

    @FindBy(id = CONFIGURE_TOKENS_BUTTON)
    public WebElement configTokensButton;

    @FindBy(xpath = "//a[contains(@class, '[ animate ]')]")
    public WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class, '[ btn btn-info ]')]")
    public WebElement searchConfirm;

    @FindBy(id = "select_search")
    public WebElement searchField;

    public void logout() {
        userDropdownButton.click();
        logoutButton.click();
    }

    public static Header init(WebDriver driver) {
        return PageFactory.initElements(driver, Header.class);
    }

}
