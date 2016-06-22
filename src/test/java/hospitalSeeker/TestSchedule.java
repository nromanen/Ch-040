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
    LoginPage loginPage;
    HeaderPage headerPage;


    @BeforeMethod
    public void beforeMethod() {
        schedulePage = PageFactory.initElements(browser.getDriver(), SchedulePage.class);
        hospitalPage = PageFactory.initElements(browser.getDriver(), HospitalPage.class);
        departmentPage = PageFactory.initElements(browser.getDriver(), DepartmentPage.class);
        doctorPage = PageFactory.initElements(browser.getDriver(), DoctorPage.class);
        headerPage = PageFactory.initElements(browser.getDriver(), HeaderPage.class);
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
    }

//    @Test (priority = 1)
//    public void checkElementsOnSchedulePage() {
//        browser.goTo(HOME_URL);
//        browser.goTo(DOCTOR_URL);
//        Assert.assertTrue(browser.isElementPresent(schedulePage.eventBody), "Event body isn't present!");
//        schedulePage.events.get(0).click();
//        Assert.assertTrue(browser.isElementPresent(schedulePage.eventDetails), "Event details button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.eventEdit), "Event edit button isn't present!");
//        schedulePage.eventEdit.click();
//        Assert.assertTrue(browser.isElementPresent(schedulePage.editorField), "Editor field isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.saveChanges), "Save changes button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.cancelChanges), "Cancel changes button isn't present!");
//        schedulePage.cancelChanges.click();
//        Assert.assertTrue(browser.isElementPresent(schedulePage.eventDelete), "Event delete button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.previousDate), "Previous dave button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.nextDate), "Next date button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToDay), "Switch view to day button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToMonth), "Switch view to month button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.switchViewToWeek), "Switch view to week button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.datePicker), "Date picker button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.selectToday), "Select today button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.selectedDate), "Selected date field isn't present!");
//        schedulePage.eventDetails.click();
//        Assert.assertTrue(browser.isElementPresent(schedulePage.detailedEditorField), "Detailed editor field isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodHoursStart), "Start hours dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodHoursEnd), "End hours dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodDayStart), "Start day dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodDayEnd), "End day dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodMonthStart), "Start month dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodMonthEnd), "End month dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodYearStart), "Start year dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.timePeriodYearEnd), "End year dropdown isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.cancelDetailedChanges), "Cancel detailed changes button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.deleteDetailedChanges), "Delete detailed changes button isn't present!");
//        Assert.assertTrue(browser.isElementPresent(schedulePage.saveDetailedChanges), "Save detailed changes button isn't present!");
//    }

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
        headerPage.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.gregoryHouseLink.click();
        schedulePage.events.get(0).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, manager edit, #7");
        schedulePage.saveChanges.click();
        assertTrue(schedulePage.events.get(0).getText().equals("text field test, manager edit, #7"), "Event isn't present!");
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
        headerPage.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
//        headerPage.findButton.click();
//        browser.implicitWait(5);
//        browser.findElementByText("Chernivtsi Regional").click();
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Event body button is present!");
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
        headerPage.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Event body button is present!");
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
        headerPage.loginButton.click();
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Event body button is present!");
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
        headerPage.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.gregoryHouseLink.click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browser.selectDropdown(schedulePage.timePeriodHoursStart, "08:00");
        browser.selectDropdown(schedulePage.timePeriodHoursEnd, "19:00");
        browser.selectDropdown(schedulePage.timePeriodMonthStart, "June");
        browser.selectDropdown(schedulePage.timePeriodMonthEnd, "June");
        browser.selectDropdown(schedulePage.timePeriodDayStart, "20");
        browser.selectDropdown(schedulePage.timePeriodDayEnd, "20");
        schedulePage.saveDetailedChanges.click();
        browser.implicitWait(5);
        schedulePage.saveDoctorSchedule.click();
        assertTrue(schedulePage.eventTitle.getText().equals("08:00 - 19:00"), "Event isn't present!");
    }

    @Test
    public void testAppointments() {
        browser.goTo(HOME_URL);
        headerPage.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
    }

    @Test
    public void createSchedule() {
//        browser.getDriver().manage().window().setSize(schedulePage.dimension);
        browser.goTo(HOME_URL);
        headerPage.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.gregoryHouseLink.click();
        schedulePage.switchViewToDay.click();
        browser.clickOnCoordinates(schedulePage.hours2200, schedulePage.columnWidth, 0);
        schedulePage.saveDoctorSchedule.click();
        browser.sleep(5);
//        browser.sleep(5);
//        browser.clickOnCoordinates(schedulePage.scheduleRows.get(1), 800, 0);
//        schedulePage.saveDoctorSchedule.click();
//        browser.sleep(5);
    }
}

/*TODO change schedule with another manager
* TODO create schedules
* TODO rewrite appointments
* TODO check if you can see an appointment in the appointments tab*/