import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alex on 23-May-16.
 */
public class TestSchedule extends BaseTest{
    SchedulePage schedulePage;
    LoginPage loginPage;
    HospitalPage hospitalPage;
    DepartmentPage departmentPage;
    DoctorPage doctorPage;


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage = PageFactory.initElements(browserAction.getDriver(), LoginPage.class);
        schedulePage = PageFactory.initElements(browserAction.getDriver(), SchedulePage.class);
        hospitalPage = PageFactory.initElements(browserAction.getDriver(), HospitalPage.class);
        departmentPage = PageFactory.initElements(browserAction.getDriver(), DepartmentPage.class);
        doctorPage = PageFactory.initElements(browserAction.getDriver(), DoctorPage.class);
    }

    @Test
    public void checkElementsOnLoginPage() {
        browserAction.goTo(HOME_URL);
        loginPage.loginButton.click();
        Assert.assertTrue(browserAction.isElementPresent(loginPage.loginDropdownButton), "Login button isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(loginPage.emailField), "Email field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(loginPage.passwordField), "Password field isn't present!");
        Assert.assertTrue(browserAction.isElementPresent(loginPage.loginButton), "Submit button isn't present!");
    }

    @Test
    public void checkElementsOnSchedulePage() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
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

    @Test (dependsOnMethods = "checkElementsOnSchedulePage")
    public void selectSecondHospital() {
        browserAction.goTo(HOSPITALS_URL);
        System.out.println(hospitalPage.hospitals.size());
        hospitalPage.hospitals.get(0).click();
    }

    @Test (dependsOnMethods = "checkElementsOnSchedulePage")
    public void selectSecondDepartment() {
        browserAction.goTo(DEPARTMENT_URL);
        System.out.println(departmentPage.departments.size());
        departmentPage.departments.get(1).click();
    }

    @Test (dependsOnMethods = "checkElementsOnSchedulePage")
    public void selectSecondDoctor() {
        browserAction.goTo(DOCTORS_URL);
        System.out.println(doctorPage.doctors.size());
    }

    @Test (priority = 4, dependsOnMethods = "checkElementsOnSchedulePage")
    public void testIfManagerCanEdit() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, manager edit, #7");
        schedulePage.saveChanges.click();
    }

    @Test (priority = 5, dependsOnMethods = {"checkElementsOnSchedulePage", "checkElementsOnLoginPage"})
    public void testIfPatientCanEdit() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(PATIENT_LOGIN, PATIENT_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, patient edit, #7");
        schedulePage.saveChanges.click();
    }

    @Test (priority = 6, dependsOnMethods = "checkElementsOnSchedulePage")
    public void testIfDoctorCanEdit() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(DOCTOR_LOGIN, DOCTOR_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, doctor edit, #7");
        schedulePage.saveChanges.click();
    }

    @Test (priority = 7, dependsOnMethods = "checkElementsOnSchedulePage")
    public void testIfAdminCanEdit() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
        browserAction.goTo(HOSPITALS_URL);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(6).click();
        schedulePage.eventEdit.click();
        schedulePage.editSchedule("text field test, admin edit, #7");
        schedulePage.saveChanges.click();
    }

    @Test (priority = 5)
    public void testManagerEditTimePeriod() {
        browserAction.goTo(HOME_URL);
        loginPage.loggingIn(MANAGER_LOGIN, MANAGER_PASSWORD);
        hospitalPage.hospitals.get(0).click();
        departmentPage.departments.get(0).click();
        doctorPage.doctors.get(3).click();
        schedulePage.previousDate.click();
        schedulePage.events.get(8).click();
        schedulePage.eventDetails.click();
        browserAction.selectTime(schedulePage.timePeriodHoursStart, "12:55");
        browserAction.selectTime(schedulePage.timePeriodHoursEnd, "19:55");
        schedulePage.saveDetailedChanges.click();
    }

    @AfterMethod
    public void afterMethod() {
        browserAction.driver.quit();
    }
}