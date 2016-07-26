package hospitalSeeker.tools;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class.getName());

    public static void onTestSuccessLog(ITestResult iTestResult) {
        logger.info("Test " + iTestResult.getTestClass().getName() + "." + iTestResult.getName() + " ended");
    }

    public static void onTestFailureLog(ITestResult iTestResult) {
        logger.error(iTestResult);
    }

    public static void onTestStartLog(ITestResult iTestResult) {
        logger.info("Test " + iTestResult.getTestClass().getName() + "." + iTestResult.getName() + " started");
    }

    public static void onSuiteStartLog(ITestContext iTestContext) {
        logger.info("Suite " + iTestContext.getName() + " started");
    }

    public static void onSuiteFinishLog(ITestContext iTestContext) {
        logger.info("Suite " + iTestContext.getName() + " finished");
    }

    public static void printTestResults(ITestResult result) {
        String status = null;
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                status = "--FAILED--";
                break;
            case ITestResult.SKIP:
                status = "SKIPPED";
        }
        logger.log(Level.INFO, result.getTestClass().getName() + "." + result.getName() + status);
    }
}
