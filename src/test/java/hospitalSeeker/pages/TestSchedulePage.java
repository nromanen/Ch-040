package hospitalSeeker.pages;

import hospitalSeeker.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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

    private void selectDoctor() {
        header.searchButton.click();
        header.searchField.sendKeys(hospitalPage.HOSPITAL_NAME);
        header.searchConfirm.click();
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(0).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        schedulePage = SchedulePage.init(browser.getDriver());
        hospitalPage = HospitalPage.init(browser.getDriver());
        departmentPage = DepartmentPage.init(browser.getDriver());
        doctorPage = DoctorPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
    }

    @Test
    public void checkElementsOnSchedulePage() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.saveDoctorSchedule.click();
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

    @Test
    public void testIfManagerCanEdit() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.createSchedule(getWrapper());
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        schedulePage.selectEvent();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule(schedulePage.MANAGER_EDIT_TEXT);
        schedulePage.saveChanges.click();
        schedulePage.backToTop(getWrapper());
        schedulePage.saveDoctorSchedule.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        assertEquals(schedulePage.eventText.getText(), schedulePage.MANAGER_EDIT_TEXT, "Event text is different!");
    }

    @Test
    public void testIfPatientCanAccessWorkSchedule() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.calendarHeader), "You can access work schedule!");
    }

    @Test
    public void testIfDoctorCanAccessWorkSchedule() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.calendarHeader), "You can access work schedule!");
    }

    @Test
    public void testIfAdminCanAccessWorkSchedule() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browser.goTo(DOCTOR_PAGE_URL);
        assertFalse(browser.isElementPresent(schedulePage.calendarHeader), "You can access work schedule!");
    }

    @Test
    public void createAndDeleteSchedule() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.createSchedule(getWrapper());
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        schedulePage.switchViewToDay.click();
        schedulePage.deleteSchedule(getWrapper());
        schedulePage.switchViewToDay.click();
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Schedule is present!");
    }

    @Test
    public void createScheduleCreateAppointmentAndCheckAppointment() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.createSchedule(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        selectDoctor();
        schedulePage.createAppointment(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        header.workschedulerButton.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        assertTrue(browser.isElementPresent(schedulePage.eventBody), "Event body is not present!");
    }

    @Test
    public void cancelAppointment() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.createSchedule(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        selectDoctor();
        schedulePage.createAppointment(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        header.workschedulerButton.click();
        schedulePage.cancelAppointment(getWrapper());
        header.workschedulerButton.click();
        browser.waitUntilElementVisible(schedulePage.calendarHeader);
        assertFalse(browser.isElementPresent(schedulePage.eventBody), "Event body is present!");
    }

    @Test
    public void createTwoAppointments() {
        browser.goTo(HOME_URL);
        header.loginButton.click();
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        doctorPage.selectDoctorAsManager();
        schedulePage.createSchedule(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        selectDoctor();
        schedulePage.createAppointment(getWrapper());
        header.logout();
        header.loginButton.click();
        loginPage.loggingIn(SECOND_PATIENT_LOGIN, SECOND_PATIENT_PASSWORD);
        selectDoctor();
        browser.waitUntilElementVisible(schedulePage.switchViewToDay);
        schedulePage.switchViewToDay.click();
        browser.doubleClickOnCoordinates(schedulePage.hours2100, schedulePage.columnWidth, schedulePage.columnHeight);
        assertFalse(browser.isElementPresent(schedulePage.appointmentConfirm), "You can create an appointment!");
    }
}