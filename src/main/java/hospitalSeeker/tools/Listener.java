package hospitalSeeker.tools;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.onTestStartLog(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.endTestCase();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.onTestFailure(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.onStartLog(iTestContext);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("finished");
    }
}
