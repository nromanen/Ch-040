package hospitalSeeker;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Alex on 23-May-16.
 */
public class SchedulePage {

    public Dimension dimension = new Dimension(1366, 768);
    public int columnWidth = 177;
    //first row width = 50
    //other rows = 177

    @FindBy(css = "div.dhx_cal_event")
    public WebElement eventBody;

    @FindBy(css = "div.dhx_menu_icon.icon_details[title=Details]")
    public WebElement eventDetails;

    @FindBy(css = "div.dhx_menu_icon.icon_edit[title=Edit]")
    public WebElement eventEdit;

    @FindBy(css = "div.dhx_menu_icon.icon_delete[title=Delete]")
    public WebElement eventDelete;

    @FindBy(css = "textarea.dhx_cal_editor")
    public WebElement editorField;

    @FindBy(css = "div.dhx_event_move.dhx_title")
    public WebElement eventTitle;

    @FindBy(css = "div.dhx_menu_icon.icon_save")
    public WebElement saveChanges;

    @FindBy(css = "div.dhx_menu_icon.icon_cancel")
    public WebElement cancelChanges;

    @FindBy(css = "div.dhx_cal_prev_button")
    public WebElement previousDate;

    @FindBy(css = "div.dhx_cal_next_button")
    public WebElement nextDate;

    @FindBy(css = "div.dhx_scale_holder")
    public WebElement dateColumn;

    @FindBy(css = "div.dhx_cal_tab.dhx_cal_tab_first[name=day_tab]")
    public WebElement switchViewToDay;

    @FindBy(css = "div.dhx_cal_tab[name=week_tab]")
    public WebElement switchViewToWeek;

    @FindBy(css = "div.dhx_cal_tab.dhx_cal_tab_last[name=month_tab]")
    public WebElement switchViewToMonth;

    @FindBy(css = "div.dhx_minical_icon[id=dhx_minical_icon]")
    public WebElement datePicker;

    @FindBy(css = "div.dhx_cal_today_button")
    public WebElement selectToday;

    @FindBy(css = "div.dhx_cal_date")
    public WebElement selectedDate;

    @FindBy(css = "div.dhx_cal_ltext")
    public WebElement detailedEditorField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[1]")
    public WebElement timePeriodHoursStart;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[5]")
    public WebElement timePeriodHoursEnd;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[2]")
    public WebElement timePeriodDayStart;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[6]")
    public WebElement timePeriodDayEnd;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[3]")
    public WebElement timePeriodMonthStart;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[7]")
    public WebElement timePeriodMonthEnd;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[4]")
    public WebElement timePeriodYearStart;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/select[8]")
    public WebElement timePeriodYearEnd;

    @FindBy(css = "div.dhx_btn_set.dhx_left_btn_set.dhx_save_btn_set")
    public WebElement saveDetailedChanges;

    @FindBy(css = "div.dhx_btn_set.dhx_left_btn_set.dhx_cancel_btn_set")
    public WebElement cancelDetailedChanges;

    @FindBy(css = "div.dhx_btn_set.dhx_right_btn_set.dhx_delete_btn_set")
    public WebElement deleteDetailedChanges;

    @FindBy(css = "button.btn.btn-success")
    public WebElement saveDoctorSchedule;

    @FindBy(id = "save")
    public WebElement saveAppointment;

    @FindBy(id = "close")
    public WebElement cancelAppointment;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='0']")
    public WebElement hours0000;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='1']")
    public WebElement hours0100;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='2']")
    public WebElement hours0200;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='3']")
    public WebElement hours0300;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='4']")
    public WebElement hours0400;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='5']")
    public WebElement hours0500;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='6']")
    public WebElement hours0600;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='7']")
    public WebElement hours0700;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='8']")
    public WebElement hours0800;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='9']")
    public WebElement hours0900;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='10']")
    public WebElement hours1000;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='11']")
    public WebElement hours1100;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='12']")
    public WebElement hours1200;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='13']")
    public WebElement hours1300;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='14']")
    public WebElement hours1400;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='15']")
    public WebElement hours1500;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='16']")
    public WebElement hours1600;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='17']")
    public WebElement hours1700;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='18']")
    public WebElement hours1800;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='19']")
    public WebElement hours1900;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='20']")
    public WebElement hours2000;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='21']")
    public WebElement hours2100;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='22']")
    public WebElement hours2200;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='23']")
    public WebElement hours2300;

    @FindAll(@FindBy(className = "dhx_scale_hour"))
    public List<WebElement> scheduleRows;

    @FindAll(@FindBy(className = "dhx_scale_holder"))
    public List<WebElement> scheduleColumns;

    @FindAll(@FindBy(xpath = ".//*[@class='dhx_body']"))
    public List<WebElement> events;

    public void editSchedule(String text) {
        editorField.sendKeys(text);
    }

    public static SchedulePage init(WebDriver driver) {
        return PageFactory.initElements(driver, SchedulePage.class);
    }
}