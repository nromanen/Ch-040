package hospitalSeeker;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotOnFailure extends TestListenerAdapter {

    WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        this.driver = ((BaseTest) result.getInstance()).getWrapper().getDriver();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
        String filePath = "target/surefire-reports/screenshots/" + dateFormat.format(new Date()) + "/";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = result.getMethod().getMethodName() + "_Failure_" + timeFormat.format(new Date()) + ".png";
        File targetFile = new File(filePath + fileName);
        try {
            FileUtils.copyFile(screenshotFile, targetFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Reporter.log("<a href=\"../../../" + filePath + fileName + "\">Screenshot</a>");
    }

}
