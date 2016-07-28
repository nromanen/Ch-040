package hospitalSeeker.tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listener implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogConfig.onTestStartLog(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogConfig.onTestSuccessLog(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = ((BaseTest) iTestResult.getInstance()).getWrapper().getDriver();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
        String filePath = "target/surefire-reports/screenshots/" + dateFormat.format(new Date()) + "/";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = iTestResult.getMethod().getMethodName() + "_Failure_" + timeFormat.format(new Date()) + ".png";
        File targetFile = new File(filePath + fileName);
        try {
            FileUtils.copyFile(screenshotFile, targetFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Reporter.log("<a href=\"../../../" + filePath + fileName + "\">Screenshot</a>");
        LogConfig.printTestResults(iTestResult);
        LogConfig.onTestFailureLog(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LogConfig.printTestResults(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LogConfig.onSuiteStartLog(iTestContext);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LogConfig.onSuiteFinishLog(iTestContext);
    }
}
