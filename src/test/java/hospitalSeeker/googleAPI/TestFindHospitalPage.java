package hospitalSeeker.googleAPI;

import hospitalSeeker.BaseTest;
import hospitalSeeker.googleApi.FindHospitalPage;
import hospitalSeeker.templates.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFindHospitalPage extends BaseTest {
    public FindHospitalPage findHospitalPage;
    public Header header;

    @BeforeMethod
    public void beforeMethod() {
        findHospitalPage = FindHospitalPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(FIND_URL);
    }

    @Test
    public void testFindHospitalElementsPresence() {
        String error = browser.checkIfElementNotPresent(header.findButton)
                .concat(browser.checkIfElementNotPresent(findHospitalPage.enterAddress))
                .concat(browser.checkIfElementNotPresent(findHospitalPage.googleMap));
        if (!(error.isEmpty())) {
            throw new AssertionError(error);
        }
    }
}
