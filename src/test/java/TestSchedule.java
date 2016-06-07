import header.DropdownLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alex on 23-May-16.
 */
public class TestSchedule extends BaseTest{
    SchedulePage schedulePage;
    DropdownLogin dropdownLogin;
    HospitalPage hospitalPage;
    DepartmentPage departmentPage;
    DoctorPage doctorPage;


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        dropdownLogin = PageFactory.initElements(browserAction.getDriver(), DropdownLogin.class);
        schedulePage = PageFactory.initElements(browserAction.getDriver(), SchedulePage.class);
        hospitalPage = PageFactory.initElements(browserAction.getDriver(), HospitalPage.class);
        departmentPage = PageFactory.initElements(browserAction.getDriver(), DepartmentPage.class);
        doctorPage = PageFactory.initElements(browserAction.getDriver(), DoctorPage.class);
    }

    @Test (priority = 0)
    public void checkDropdownLoginElements() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.dropdownLoginButton.click();
        Assert.assertTrue(browserAction.isElementPresent(dropdownLogin.dropdownLoginButton), "Login button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(dropdownLogin.dropdownEmailField), "Email field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(dropdownLogin.dropdownPasswordField), "Password field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(dropdownLogin.dropdownLoginSubmitButton), "Submit button isn't present!");
    }

    @Test (priority = 1)
    public void checkElementsOnSchedulePage() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        browserAction.goTo(DOCTOR_URL);
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.eventBody), "Event body isn't present!");
        schedulePage.events.get(0).click();
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.eventDetails), "Event details button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.eventEdit), "Event edit button isn't present!");
        schedulePage.eventEdit.click();
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.editorField), "Editor field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.saveChanges), "Save changes button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.cancelChanges), "Cancel changes button isn't present!");
        schedulePage.cancelChanges.click();
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.eventDelete), "Event delete button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.previousDate), "Previous dave button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.nextDate), "Next date button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.switchViewToDay), "Switch view to day button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.switchViewToMonth), "Switch view to month button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.switchViewToWeek), "Switch view to week button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.datePicker), "Date picker button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.selectToday), "Select today button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.selectedDate), "Selected date field isn't present!");
        schedulePage.eventDetails.click();
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.detailedEditorField), "Detailed editor field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodHoursStart), "Start hours dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodHoursEnd), "End hours dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodDayStart), "Start day dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodDayEnd), "End day dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodMonthStart), "Start month dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodMonthEnd), "End month dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodYearStart), "Start year dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.timePeriodYearEnd), "End year dropdown isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.cancelDetailedChanges), "Cancel detailed changes button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.deleteDetailedChanges), "Delete detailed changes button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(schedulePage.saveDetailedChanges), "Save detailed changes button isn't present!");
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

    @Test (priority = 4, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testIfManagerCanEdit() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
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

    @Test (priority = 5, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testIfPatientCanEdit() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browserAction.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
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

    @Test (priority = 6, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testIfDoctorCanEdit() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browserAction.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
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

    @Test (priority = 7, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testIfAdminCanEdit() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        assertFalse(browserAction.isElementPresent(schedulePage.eventEdit), "Event edit button is present!");
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
    @Test (priority = 8, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testManagerEditTimePeriod() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browserAction.selectTime(schedulePage.timePeriodHoursStart, "12:55");
        browserAction.selectTime(schedulePage.timePeriodHoursEnd, "19:55");
        browserAction.selectTime(schedulePage.timePeriodMonthStart, "June");
        browserAction.selectTime(schedulePage.timePeriodMonthEnd, "June");
        browserAction.selectTime(schedulePage.timePeriodDayStart, "7");
        browserAction.selectTime(schedulePage.timePeriodDayEnd, "7");
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
    @Test (priority = 9, dependsOnMethods = {"checkElementsOnSchedulePage", "checkDropdownLoginElements"})
    public void testManagerEditBeyondWorkingHours() {
        browserAction.goTo(HOME_URL);
        dropdownLogin.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browserAction.selectTime(schedulePage.timePeriodHoursStart, "17:00");
        browserAction.selectTime(schedulePage.timePeriodHoursEnd, "20:30");
        schedulePage.saveDetailedChanges.click();
        assertFalse(schedulePage.eventTitle.getText().equals("17:00 - 20:30"), "Event is present!");
    }

    @AfterMethod
    public void afterMethod() {
        browserAction.driver.quit();
    }
}