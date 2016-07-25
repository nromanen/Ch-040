package hospitalSeeker.tools;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
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

    public static void endTestCase(ITestResult iTestResult) {
        logger.info("Test " + iTestResult.getName() + " ended");
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
        logger.info("Test " + iTestResult.getName() + " started");
    }

    public static void onStartLog(ITestContext iTestContext) {
        logger.info("Suite " + iTestContext.getName());
    }

    public static void onError(String text) {
        logger.error(text);
    }

    public static void onFinishLog(ITestContext iTestContext) {
    }

    public static void printTestResults(ITestResult result) {

        logger.log(Level.INFO, "Test Method resides in " + result.getTestClass().getName(), true);
        String status = null;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;
            case ITestResult.FAILURE:
                status = "Failed";
                break;
            case ITestResult.SKIP:
                status = "Skipped";
        }
        logger.log(Level.INFO, "Test Status: " + status);
    }
}
