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


    public int columnWidth = 177;
    public int columnHeight = 20;

    public final String WORK_WEEK_SIZE_5 = "5 days";
    public final String WORK_HOURS_24 = "24:00";
    public final String WORK_HOURS_10 = "10:00";
    public final String WORK_HOURS_23 = "23:00";
    public final String APPOINTMENT_REASON = "stomach ache";
    public final String MANAGER_EDIT_TEXT = "text field test, manager edit, #7";

    @FindBy(className = "dhx_cal_event")
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

    @FindBy(className = "dhx_scale_bar")
    public WebElement calendarHeader;

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

    @FindBy(css = "div.dhx_btn_set.dhx_left_btn_set.dhx_save_btn_set")
    public WebElement saveDetailedChanges;

    @FindBy(css = "div.dhx_btn_set.dhx_left_btn_set.dhx_cancel_btn_set")
    public WebElement cancelDetailedChanges;

    @FindBy(css = "div.dhx_btn_set.dhx_right_btn_set.dhx_delete_btn_set")
    public WebElement deleteDetailedChanges;

    @FindBy(css = "button.btn.btn-success")
    public WebElement saveDoctorSchedule;

    @FindBy(css = "div.dhtmlx_popup_button.dhtmlx_ok_button")
    public WebElement confirmDeletingSchedule;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='1']")
    public WebElement hours0100;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='17']")
    public WebElement hours1700;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='21']")
    public WebElement hours2100;

    @FindBy(xpath = "//span[contains(@class, 'dhx_scale_h') and text()='22']")
    public WebElement hours2200;

    @FindBy(id = "workWeekSize")
    public WebElement workWeekSize;

    @FindBy(id = "workDayBeginAt")
    public WebElement workDayBeginAt;

    @FindBy(id = "workDayEndAt")
    public WebElement workDayEndAt;

    @FindBy(id = "appointmentTime")
    public WebElement appointmentSize;

    @FindBy(id = "TheReasonForVisit")
    public WebElement reasonForVisitField;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-default') and text()='Confirm']")
    public WebElement appointmentConfirm;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-danger') and text()='Cancel the appointment']")
    public WebElement cancelAppointment;

    @FindBy(id = "batOne")
    public WebElement confirmCancellingAppointment;

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