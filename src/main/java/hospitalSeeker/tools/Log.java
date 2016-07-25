package hospitalSeeker.tools;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class.getName());

    public static void endTestCase() {
        logger.info("-E---N---D-");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(ITestResult iTestResult) {
        logger.warn(iTestResult);
    }

    public static void error(ITestResult iTestResult) {
        logger.error(iTestResult);
    }

    public static void onTestStartLog(ITestResult iTestResult) {
        logger.info("Test " + iTestResult.getName());
    }

    public static void onTestFailure(ITestResult iTestResult) {
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
    }

    public static void onStartLog(ITestContext iTestContext) {
        logger.info("About to begin executing Suite " + iTestContext.getName());
    }

    public static void onFinishLog(ITestContext iTestContext) {
    }
}
