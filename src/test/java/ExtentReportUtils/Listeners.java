package ExtentReportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentTest test;

    ExtentReports extent = ExtentRepoterNG.getReporterObject();

    @Override
    public void onTestStart(ITestResult result){
         test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        // method for test success
        test.log(Status.PASS, "Test Paseed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        // method for test failure
        //screenshot attachment
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }

}
