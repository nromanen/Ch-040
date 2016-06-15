package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    @FindBy(id = "allUsers")
    public WebElement allUsersTable;
    
    @FindBy(id = "pref-perpage" )
    public WebElement showUsers;
    
    @FindBy(id = "pref-roleby")
    public WebElement role;
    
    @FindBy (id = "searchBy")
    public WebElement searchBy;
    
    @FindBy (id = "search")
    public WebElement search;
    
    @FindBy (id = "input.btn.btn-default")
    public WebElement submitButton;
    
    @FindBy (linkText = "Enabled")
    public WebElement enabled;
    
    @FindBy (linkText = "Disabled")
    public WebElement disabled;
    
    @FindBy (linkText = "All users")
    public WebElement allUsers;
    
    @FindBy (id = "viewUser")
    public WebElement actionsViewUser;
    
    @FindBy (css = "a.btn.btn_user")
    public WebElement actionsEditUser;
    
    @FindBy (id = "deleteUser")
    public WebElement actionsDeleteUser;
    
    @FindBy (xpath = "/html/body/section/div/div[1]/table/thead/tr/th[2]/div")
    public WebElement headerTableEmailColumn;

    @FindBy (xpath = "/html/body/section/div/div[1]/table/thead/tr/th[3]")
    public WebElement headerTableFirstNameColumn;
    
    @FindBy (xpath = "/html/body/section/div/div[1]/table/thead/tr/th[4]/div")
    public WebElement headerTableLastNameColumn;

    @FindBy (xpath = "/html/body/section/div/div[1]/table/thead/tr/th[5]/div")
    public WebElement headerTableRoleColumn;
    
    @FindBy (xpath = "/html/body/section/div/div[1]/table/thead/tr/th[6]/div")
    public WebElement headerTableActionsColumn;
    
    @FindBy (xpath = "/html/body/section/div/div[2]/div/div")
    public WebElement viewUserAlert;
    
    @FindBy (xpath = "/html/body/section/div/div[2]/div/div/div[2]/div/tr[3]/td[2]/input")
    public WebElement viewUserAlertEnabledButton;
    
    @FindBy (xpath = "/html/body/section/div/div[2]/div/div/div[3]/a")
    public WebElement viewUserAlertCancel;

    @FindBy(id = "enabled")
	public WebElement editEnabledButton;
	
	@FindBy(css = "option[value=ADMIN]")
	public WebElement editRoleAdmin;
	
	@FindBy(css = "option[value=DOCTOR]")
	public WebElement editRoleDoctor;
	
	@FindBy(css = "option[value=MANAGER]")
	public WebElement editRoleManager;
	
	@FindBy(css = "option[value=PATIENT]")
	public WebElement editRolePatient;
	
	@FindBy(css = "input.btn.btn-primary.btn-sm")
	public WebElement editEditButton;
	
	@FindBy (xpath = "/html/body/section/div/div/div/div/form/div[3]/div/a")
	public WebElement editCancelButton;
	
    @FindBy (xpath = "/html/body/section/div/div[3]/div/div")
    public WebElement deleteUserAlert;
    
    @FindBy (xpath = "/html/body/section/div/div[3]/div/div/div[3]/a[1]")
    public WebElement deleteUserAlertCancelButton;
    
    @FindBy (id = "deleteButton")
    public WebElement deleteUserAlertDeleteButton;
    
	public static AdminPage init(WebDriver driver) {
        return PageFactory.initElements(driver, AdminPage.class);
    }
}
