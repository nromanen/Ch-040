package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

    public static final String ALL_USERS_TABLE_ID = "allUsers";

    @FindBy(id = ALL_USERS_TABLE_ID)
    public WebElement allUsersTable;


}
