package hospitalSeeker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Alex on 23-May-16.
 */
public class SchedulePage {

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

    @FindAll(@FindBy(xpath = ".//*[@class='dhx_body']"))
    public List<WebElement> events;

    public void editSchedule(String text) {
        editorField.sendKeys(text);
    }
}