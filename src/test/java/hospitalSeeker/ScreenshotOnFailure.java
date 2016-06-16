package hospitalSeeker;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotOnFailure extends TestListenerAdapter {

    WebDriver driver;
    String filePath = "target/surefire-reports/screenshots/";

    @Override
    public void onTestFailure(ITestResult result) {
        this.driver = ((BaseTest)result.getInstance()).getWrapper().getDriver();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(filePath +
                result.getMethod().getMethodName() + "_Failure_" + dateFormat.format(new Date()) + ".png");
        try {
            FileUtils.copyFile(screenshotFile, targetFile);
        } catch (IOException e1) {
            System.out.println("Bad EXCEPTION");
        }
    }

}
