package hospitalSeeker;

//import hospitalSeeker.header.DropdownLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alex on 23-May-16.
 */
public class TestSchedule extends BaseTest{
    SchedulePage schedulePage;
    HospitalPage hospitalPage;
    DepartmentPage departmentPage;
    DoctorPage doctorPage;


    @BeforeMethod
    public void beforeMethod() {
        schedulePage = PageFactory.initElements(browser.getDriver(), SchedulePage.class);
        hospitalPage = PageFactory.initElements(browser.getDriver(), HospitalPage.class);
        departmentPage = PageFactory.initElements(browser.getDriver(), DepartmentPage.class);
        doctorPage = PageFactory.initElements(browser.getDriver(), DoctorPage.class);
    }

    @Test (priority = 1)
    public void checkElementsOnSchedulePage() {
        browser.goTo(HOME_URL);
        browser.goTo(DOCTOR_URL);
        Assert.assertTrue(browser.isElementPresent(schedulePage.eventBody), "Event body isn't present!");
        schedulePage.events.get(0).click();
        Assert.assertTrue(browser.isElementPresent(schedulePage.eventDetails), "Event details button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.eventEdit), "Event edit button isn't present!");
        schedulePage.eventEdit.click();
        Assert.assertTrue(browser.isElementPresent(schedulePage.editorField), "Editor field isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.saveChanges), "Save changes button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.cancelChanges), "Cancel changes button isn't present!");
        schedulePage.cancelChanges.click();
        Assert.assertTrue(browser.isElementPresent(schedulePage.eventDelete), "Event delete button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.previousDate), "Previous dave button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.nextDate), "Next date button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToDay), "Switch view to day button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToMonth), "Switch view to month button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToWeek), "Switch view to week button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.datePicker), "Date picker button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.selectToday), "Select today button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.selectedDate), "Selected date field isn't present!");
        schedulePage.eventDetails.click();
        Assert.assertTrue(browser.isElementPresent(schedulePage.detailedEditorField), "Detailed editor field isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodHoursStart), "Start hours dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodHoursEnd), "End hours dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodDayStart), "Start day dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodDayEnd), "End day dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodMonthStart), "Start month dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodMonthEnd), "End month dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodYearStart), "Start year dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodYearEnd), "End year dropdown isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.cancelDetailedChanges), "Cancel detailed changes button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.deleteDetailedChanges), "Delete detailed changes button isn't present!");
        Assert.assertTrue(browser.isElementPresent(schedulePage.saveDetailedChanges), "Save detailed changes button isn't present!");
    }

    /*
    1. Go to the home page.
    2. Login from the dropdown login form as manager.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Change description of the event and click save changes.
    8. Check if these changes are correct.
     */

    @Test (priority = 4)
    public void testIfManagerCanEdit() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, manager edit, #7");
        schedulePage.saveChanges.click();
        assertTrue(schedulePage.events.get(6).getText().equals("text field test, manager edit, #7"), "Event isn't present!");
    }

    /*
    1. Go to the home page.
    2. Login from the dropdown login form as patient.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Check if you can edit this event.
    */

    @Test (priority = 5)
    public void testIfPatientCanEdit() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        browser.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browser.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
    }

    /*
    1. Go to the home page.
    2. Login from the dropdown login form as doctor.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Check if you can edit this event.
    */

    @Test (priority = 6)
    public void testIfDoctorCanEdit() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browser.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browser.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
    }

    /*
    1. Go to the home page.
    2. Login from the dropdown login form as administrator.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Check if you can edit this event.
    */

    @Test (priority = 7)
    public void testIfAdminCanEdit() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browser.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browser.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
    }

    /*
    1. Go to the home page.
    2. Login from the dropdown login form as manager.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Select different day and time (from 8:00 to 20:00) for this event.
    8. Save changes.
    9. Check if these changes are correct.
     */
    @Test (priority = 8)
    public void testManagerEditTimePeriod() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browser.selectDropdown(schedulePage.timePeriodHoursStart, "12:55");
        browser.selectDropdown(schedulePage.timePeriodHoursEnd, "19:55");
        browser.selectDropdown(schedulePage.timePeriodMonthStart, "June");
        browser.selectDropdown(schedulePage.timePeriodMonthEnd, "June");
        browser.selectDropdown(schedulePage.timePeriodDayStart, "7");
        browser.selectDropdown(schedulePage.timePeriodDayEnd, "7");
        schedulePage.saveDetailedChanges.click();
        assertTrue(schedulePage.eventTitle.getText().equals("12:55 - 19:55"), "Event isn't present!");
    }
    /*
    1. Go to the home page.
    2. Login from the dropdown login form as manager.
    3. Select hospital.
    4. Select department.
    5. Select doctor.
    6. Choose event that you want to edit.
    7. Select time beyond working hours (20:05 - 07:55) for this event.
    8. Save changes.
    9. Check if these changes are correct.
     */
    @Test (priority = 9)
    public void testManagerEditBeyondWorkingHours() {
        browser.goTo(HOME_URL);
        //dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browser.selectDropdown(schedulePage.timePeriodHoursStart, "17:00");
        browser.selectDropdown(schedulePage.timePeriodHoursEnd, "20:30");
        schedulePage.saveDetailedChanges.click();
        assertFalse(schedulePage.eventTitle.getText().equals("17:00 - 20:30"), "Event is present!");
    }
}