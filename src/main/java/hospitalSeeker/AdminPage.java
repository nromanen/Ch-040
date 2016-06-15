package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public static final String ALL_USERS_TABLE_ID = "allUsers";

    @FindBy(id = ALL_USERS_TABLE_ID)
    public WebElement allUsersTable;

    public static AdminPage init(WebDriver driver) {
        return PageFactory.initElements(driver, AdminPage.class);
    }

}
