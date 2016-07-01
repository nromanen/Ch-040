package hospitalSeeker.pages;

import hospitalSeeker.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 23-May-16.
 */
public class TestSchedulePage extends BaseTest {
    SchedulePage schedulePage;
    HospitalPage hospitalPage;
    DepartmentPage departmentPage;
    DoctorPage doctorPage;
    LoginPage loginPage;
    Header header;


    @BeforeMethod
    public void beforeMethod() {
        schedulePage = SchedulePage.init(browser.getDriver());
        hospitalPage = HospitalPage.init(browser.getDriver());
        departmentPage = DepartmentPage.init(browser.getDriver());
        doctorPage = DoctorPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
    }

    @Test()
    public void checkElementsOnSchedulePage() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.doctors.get(0).click();
        String error = browser.checkIfElementNotPresent(schedulePage.workDayEndAt)
                .concat(browser.checkIfElementNotPresent(schedulePage.workDayBeginAt))
                .concat(browser.checkIfElementNotPresent(schedulePage.workWeekSize))
                .concat(browser.checkIfElementNotPresent(schedulePage.appointmentSize))
                .concat(browser.checkIfElementNotPresent(schedulePage.saveDoctorSchedule))
                .concat(browser.checkIfElementNotPresent(schedulePage.switchViewToDay))
                .concat(browser.checkIfElementNotPresent(schedulePage.switchViewToWeek))
                .concat(browser.checkIfElementNotPresent(schedulePage.switchViewToMonth))
                .concat(browser.checkIfElementNotPresent(schedulePage.datePicker))
                .concat(browser.checkIfElementNotPresent(schedulePage.selectToday))
                .concat(browser.checkIfElementNotPresent(schedulePage.nextDate))
                .concat(browser.checkIfElementNotPresent(schedulePage.previousDate))
                .concat(browser.checkIfElementNotPresent(schedulePage.calendarHeader));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
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

    @Test()
    public void testIfManagerCanEdit() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.gregoryHouseLink.click();
        schedulePage.saveDoctorSchedule.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        schedulePage.switchViewToDay.click();
        browser.doubleClickOnCoordinates(schedulePage.hours0100, schedulePage.columnWidth, schedulePage.columnHeight);
        browser.waitUntilElementVisible(schedulePage.saveChanges);
        schedulePage.saveChanges.click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule(schedulePage.MANAGER_EDIT_TEXT);
        schedulePage.saveChanges.click();
        assertTrue(browser.isElementPresent(schedulePage.eventBody));
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

    @Test()
    public void testIfPatientCanEdit() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        header.searchButton.click();
        header.searchField.sendKeys(hospitalPage.HOSPITAL_NAME);
        header.searchConfirm.click();
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(0).click();
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

    @Test()
    public void testIfDoctorCanEdit() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        header.searchButton.click();
        header.searchField.sendKeys(hospitalPage.HOSPITAL_NAME);
        header.searchConfirm.click();
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(0).click();
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

    @Test()
    public void testIfAdminCanEdit() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        header.searchButton.click();
        header.searchField.sendKeys(hospitalPage.HOSPITAL_NAME);
        header.searchConfirm.click();
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(0).click();
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Event body button is present!");
    }

    /*
    1. Go to the home page.
    2. Login as manager.
    3. Click on the first doctor.
    4. Select work week size, work day hours and appointment size. Press save.
    5. Check if you can see schedule.
    6. Switch to the day tab, and create work schedule for tomorrow. Press save.
    7. Switch to the day tab and find created schedule.
    8. Delete it and confirm that it is deleted.
     */

    @Test
    public void createAndDeleteSchedule() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.doctors.get(0).click();
        browser.waitUntilElementVisible(schedulePage.workWeekSize);
        browser.selectDropdown(schedulePage.workWeekSize, schedulePage.WORK_WEEK_SIZE_5);
        browser.selectDropdown(schedulePage.workDayEndAt, schedulePage.WORK_HOURS_24);
        schedulePage.saveDoctorSchedule.click();
        assertTrue(browser.isElementPresent(schedulePage.calendarHeader));
        schedulePage.switchViewToDay.click();
        schedulePage.nextDate.click();
        browser.doubleClickOnCoordinates(schedulePage.hours2200, schedulePage.columnWidth, schedulePage.columnHeight);
        schedulePage.saveChanges.click();
        schedulePage.saveDoctorSchedule.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        schedulePage.switchViewToDay.click();
        schedulePage.nextDate.click();
        assertTrue(browser.isElementPresent(schedulePage.eventBody));
        schedulePage.eventBody.click();
        schedulePage.eventDelete.click();
        browser.waitUntilElementVisible(schedulePage.confirmDeletingSchedule);
        schedulePage.confirmDeletingSchedule.click();
        schedulePage.saveDoctorSchedule.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        schedulePage.switchViewToDay.click();
        schedulePage.nextDate.click();
        assertFalse(browser.isElementPresent(schedulePage.eventBody));
    }

    /*
    1. Go to the home page.
    2. Login as manager.
    3. Click on the first doctor.
    4. Select work week size, work day hours and appointment size. Press save.
    5. Check if you can see schedule.
    6. Switch to the day tab, and create work schedule for today. Press save.
    7. Logout as manager and login as patient.
    8. Click on search and write "Regional".
    9. Select first hospital, department and doctor.
    10. Switch to the day tab, and create an appointment, type in the reason for visit. Confirm it.
    11. Logout as patient and login as doctor.
    12. Select workscheduler and find created appointment.
     */

    @Test(priority = 1)
    public void createScheduleCreateAppointmentAndCheckAppointment() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.doctors.get(0).click();
        browser.waitUntilElementVisible(schedulePage.workWeekSize);
        browser.selectDropdown(schedulePage.workWeekSize, schedulePage.WORK_WEEK_SIZE_5);
        browser.selectDropdown(schedulePage.workDayEndAt, schedulePage.WORK_HOURS_24);
        schedulePage.saveDoctorSchedule.click();
        assertTrue(browser.isElementPresent(schedulePage.calendarHeader));
        schedulePage.switchViewToDay.click();
        browser.doubleClickOnCoordinates(schedulePage.hours1700, schedulePage.columnWidth, schedulePage.columnHeight);
        browser.waitUntilElementVisible(schedulePage.saveChanges);
        schedulePage.saveChanges.click();
        schedulePage.events.get(0).click();
        schedulePage.eventDetails.click();
        browser.selectDropdown(schedulePage.timePeriodHoursStart, schedulePage.WORK_HOURS_10);
        browser.selectDropdown(schedulePage.timePeriodHoursEnd, schedulePage.WORK_HOURS_23);
        schedulePage.saveDetailedChanges.click();
        schedulePage.saveDoctorSchedule.click();
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        header.searchButton.click();
        header.searchField.sendKeys(hospitalPage.HOSPITAL_NAME);
        header.searchConfirm.click();
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(0).click();
        browser.waitUntilElementVisible(schedulePage.switchViewToDay);
        schedulePage.switchViewToDay.click();
        browser.doubleClickOnCoordinates(schedulePage.hours2100, schedulePage.columnWidth, schedulePage.columnHeight);
        browser.waitUntilElementVisible(schedulePage.appointmentConfirm);
        schedulePage.reasonForVisitField.sendKeys(schedulePage.APPOINTMENT_REASON);
        browser.sleep(1);
        schedulePage.appointmentConfirm.click();
        browser.sleep(6);
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        header.workschedulerButton.click();
        browser.waitUntilElementVisible(schedulePage.eventBody);
        assertTrue(browser.isElementPresent(schedulePage.eventBody));
    }

    /*
    1. Go to the home page.
    2. Login as doctor.
    3. Select an appointment.
    4. Try to cancel it.
    5. Confirm that it is cancelled.
     */

    @Test(priority = 2)
    public void cancelAppointment() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        header.workschedulerButton.click();
        browser.waitUntilElementVisible(schedulePage.eventBody);
        browser.doubleClick(schedulePage.eventTitle);
        browser.sleep(2);
        schedulePage.cancelAppointment.click();
        browser.waitUntilElementVisible(schedulePage.confirmCancellingAppointment);
        schedulePage.confirmCancellingAppointment.click();
        browser.sleep(6);
        header.workschedulerButton.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        assertFalse(browser.isElementPresent(schedulePage.eventBody));
    }
}